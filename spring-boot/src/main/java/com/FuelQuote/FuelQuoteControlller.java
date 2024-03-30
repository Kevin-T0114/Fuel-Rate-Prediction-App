package com.FuelQuote;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path="api/quotes")
public class FuelQuoteControlller {
    
    private final FuelQuoteService fuelQuoteService;
    
    public FuelQuoteControlller(FuelQuoteService fuelQuoteService) {
        this.fuelQuoteService = fuelQuoteService;
    }

    @GetMapping
    public FuelQuoteService getFuelQuoteHistory() {
        return fuelQuoteService;
    } 
}
