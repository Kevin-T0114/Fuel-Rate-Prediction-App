package com.PricingModule;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FuelQuote.FuelQuoteRepository;

import jakarta.transaction.Transactional;

@Service
public class PricingModuleService {

    private final FuelQuoteRepository fuelQuoteRepository;

    @Autowired
    public PricingModuleService(FuelQuoteRepository fuelQuoteRepository) {
        this.fuelQuoteRepository = fuelQuoteRepository;
    }

    public String getState(String user) {
        return fuelQuoteRepository.findStateByUsername(user);
    }

    public Long getUser(String userPayload) {
        return fuelQuoteRepository.findbyUsername(userPayload);
    }

    @Transactional
    public String addQuote(PricingModule pricingModule) {

        try {
            Date date = Date.valueOf(pricingModule.getDate());
            float gallons = Float.parseFloat(pricingModule.getGallons());
            double price = Double.parseDouble(pricingModule.getPrice());
            double total = Double.parseDouble(pricingModule.getDue());
            fuelQuoteRepository.quoteInsertion(date, gallons, price, total, pricingModule.getAddress(), pricingModule.getId());
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return pricingModule.toString();
    }
}
