package com.FuelQuote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FuelQuoteRepository extends JpaRepository<FuelQuote, Long>{
    
    @Query("SELECT q from quote q WHERE q.quote_id")
    public List<FuelQuote> getAllQuotes() {

    }
} 
