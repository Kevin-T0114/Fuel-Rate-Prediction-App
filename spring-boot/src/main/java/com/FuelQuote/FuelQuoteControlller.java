package com.FuelQuote;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/quotes")
public class FuelQuoteControlller {
    
    private final FuelQuoteService fuelQuoteService;
    
    public FuelQuoteControlller(FuelQuoteService fuelQuoteService) {
        this.fuelQuoteService = fuelQuoteService;
    }

    @PostMapping("/getQuotes")
    public String getFuelQuoteHistory(@RequestBody Map<String, String> payload) {
        Gson gson = new Gson();
        String name = payload.get("User");
        try {
            List<FuelQuote> results = fuelQuoteService.getQuotes(name);
            String json = gson.toJson(results);
            return json;
        }
        catch (Exception e) {
            System.out.println("unsuccessful");
        }
        return "";
    } 
}
