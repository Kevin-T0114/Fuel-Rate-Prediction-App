package com.FuelQuote;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.transaction.Transactional;

@Service
public class FuelQuoteService {
    
    private final FuelQuoteRepository fuelQuoteRepository;

    @Autowired
    public FuelQuoteService(FuelQuoteRepository fuelQuoteRepository) {
        this.fuelQuoteRepository = fuelQuoteRepository;
    }
    
    public Long getUserID(String user) {
        return fuelQuoteRepository.findbyUsername(user);
    }

    public String getQuotes(Long id) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        List<FuelQuote> results = fuelQuoteRepository.findByUserID(id);
        String json = gson.toJson(results);
        return json;
    }

    public String getState(String user) {
        return fuelQuoteRepository.findStateByUsername(user);
    }

    public String getAddress(String username) {
        return fuelQuoteRepository.findAddressByUsername(username);
    }

    @Transactional
    public String addQuote(FuelQuote pricingModule) {

        try {
            //Date date = Date.valueOf(pricingModule.getDeliveryDate());
            fuelQuoteRepository.save(pricingModule);
            
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return pricingModule.toString();
    }
}
