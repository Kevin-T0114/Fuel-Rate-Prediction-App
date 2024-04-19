package com.FuelQuote;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class FuelQuoteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;  
    
    public List<FuelQuote> getQuotes(String user) {
        String sql = "SELECT user_id FROM user_profile WHERE username = ?";
        Object[] args = {user};
		Integer idNum = new Integer(0);
		try {
			Integer id = jdbcTemplate.queryForObject(sql, args, Integer.class);
            idNum = id;
        } catch (Exception e) {
            System.err.println("error");
        }
        
        sql = "SELECT * FROM quote WHERE user_id = " + idNum.longValue();
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        List<FuelQuote> quotes = new ArrayList<>();
        list.forEach(m -> {
            java.sql.Date date = (java.sql.Date)m.get("delivery_date");
            LocalDate del_date = date.toLocalDate();
            FuelQuote f = new FuelQuote();
            f.setID((Long)m.get("id"));
            f.setAddress((String)m.get("address"));
            f.setDeliveryDate(del_date);
            f.setGallonsRequested((Float)m.get("gallons_requested"));
            f.setPricePerGallon((Double)m.get("price_per_gallon"));
            f.setTotalPrice((Float)m.get("gallons_requested"), (Double)m.get("price_per_gallon"));
            quotes.add(f);
        });
        return quotes;
    }
}
