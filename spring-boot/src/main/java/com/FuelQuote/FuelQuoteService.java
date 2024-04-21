package com.FuelQuote;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
        List<FuelQuote> results = fuelQuoteRepository.findByUserID(id);
        String json = gson.toJson(results);
        return json;
        
    }
}
