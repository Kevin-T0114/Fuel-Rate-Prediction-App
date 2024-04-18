package com.FuelQuote;
import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class FuelQuoteService {
    private JdbcTemplate jdbcTemplate;  

    public List<FuelQuote> getQuotes(String user) {
        String sql = "SELECT user_id FROM user_profile WHERE username = '" + user + "'";
        Integer idNum = new Integer(0);
        idNum = jdbcTemplate.queryForObject(sql, Integer.class);
    
        sql = "SELECT * FROM quotes WHERE user_id = " + idNum;
        List<FuelQuote> recieve = jdbcTemplate.queryForList(sql, FuelQuote.class);
        return recieve;
    }
}
