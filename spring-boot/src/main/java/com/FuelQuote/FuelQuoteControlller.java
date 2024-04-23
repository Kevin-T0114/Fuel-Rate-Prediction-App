package com.FuelQuote;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
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
    public String getUser(@RequestBody Map<String,String> payLoad) {
        user = payLoad.get("User");
        return ((String) payLoad.get("User"));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/location")
    public String getLocation() {
        String location = fuelQuoteService.getState(user);
        return (String) location;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/price")
    public float makePrice() {
        String location = fuelQuoteService.getState(user);
        if (location =="TX") {
			//do the tx calc 
		} else {
			//do the other calc
		}
        float price = 37;
        return price;
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
