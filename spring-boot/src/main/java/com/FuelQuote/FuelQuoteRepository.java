package com.FuelQuote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface FuelQuoteRepository extends JpaRepository<FuelQuote, Long>{
    
    //public List<FuelQuote> getQuoteById();
} 
