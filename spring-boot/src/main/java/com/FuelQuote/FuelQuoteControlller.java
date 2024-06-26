package com.FuelQuote;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/quotes")
public class FuelQuoteControlller {

    private final FuelQuoteService fuelQuoteService;
    private String user;

    @Autowired
    public FuelQuoteControlller(FuelQuoteService fuelQuoteService) {
        this.fuelQuoteService = fuelQuoteService;
    }

    @GetMapping("/getQuotes")
    public String getFuelQuoteHistory(@RequestParam(name = "User") String user) {
        Long id = fuelQuoteService.getUserID(user);
        String json = fuelQuoteService.getQuotes(id);
        return json;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user")
    public String getUser(@RequestBody Map<String, String> payLoad) {
        user = payLoad.get("User");
        return ((String) payLoad.get("User"));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/location")
    public String getLocation() {
        String location = fuelQuoteService.getState(user);
        return (String) location;
    }

    private static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(Double.toString(value));
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/price")
    public String makePrice(@RequestBody Map<String, String> payLoad) {
        float gallonsRequested = Float.parseFloat(payLoad.get("GallonsRequested"));
        String locationString = payLoad.get("Location");
        String userString = payLoad.get("User");

        Long userID = fuelQuoteService.getUserID(userString);
        boolean previousUser = fuelQuoteService.getHadPreviousQuotes(userID);
        float price = 37;
        float RateHistoryFactor = 0;
        if (previousUser) {
            RateHistoryFactor = (float) 0.01;
        } else {
            RateHistoryFactor = 0;
        }
        float LocationFactor = 0;
        if (locationString.equals("TX")) {
            LocationFactor = (float) 0.02;
        } else {
            LocationFactor = (float) 0.04;
        }

        float GallonsRequestedFactor = 0;
        if (gallonsRequested > 1000) {
            GallonsRequestedFactor = (float) 0.02;
        } else {
            GallonsRequestedFactor = (float) 0.03;
        }

        float CompanyProfitFactor = (float) 0.1;
        float CurrentPrice = (float) 1.50;
        float Margin = CurrentPrice
                * (LocationFactor - RateHistoryFactor + GallonsRequestedFactor + CompanyProfitFactor);
        price = CurrentPrice + Margin;
        double p = round((double) price, 3);
        System.out.println(p);
        String priceString = String.valueOf(p);
        System.out.println(priceString);
        return priceString;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/result")
    public String getQuotes(@RequestBody Map<String, String> payLoad) {

        if (((String) payLoad.get("Gallons")).equals("") || ((String) payLoad.get("Address")).equals("")
                || ((String) payLoad.get("Date")).equals("") || ((String) payLoad.get("Price")).equals("")
                || ((String) payLoad.get("Due")).equals("")) {
            return "fields not filled";
        }

        String user = (String) payLoad.get("User");
        Long id = fuelQuoteService.getUserID(user);
        float gallons = Float.parseFloat(payLoad.get("Gallons"));
        String address = fuelQuoteService.getAddress(user);
        Date date = Date.valueOf(payLoad.get("Date"));
        double ppg = Double.parseDouble(payLoad.get("Price"));
        System.out.println("ppg is" + ppg);
        Long userID = fuelQuoteService.getUserID(user);
        FuelQuote pricingModule = new FuelQuote();

        pricingModule.setAddress(address);
        pricingModule.setDeliveryDate(date);
        pricingModule.setGallonsRequested(gallons);
        pricingModule.setPricePerGallon(ppg);
        pricingModule.setTotalPrice(gallons, ppg);
        pricingModule.setUserID(userID);

        return fuelQuoteService.addQuote(pricingModule);
    }
}
