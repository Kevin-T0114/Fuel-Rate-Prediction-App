package com.FuelQuote;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/quotes")
public class FuelQuoteControlller {
    
    private final FuelQuoteService fuelQuoteService;
    
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
}
