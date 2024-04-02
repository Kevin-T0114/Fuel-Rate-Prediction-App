package com.FuelQuote;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FuelQuoteService {
    private LocalDate date1 = LocalDate.of(2003, 6, 5);
    private LocalDate date2 = LocalDate.of(2004, 8, 4);
    private LocalDate date3 = LocalDate.of(2005, 3, 24);
    private FuelQuote firstPurchase = new FuelQuote(1, 6, "12345 Address Ln", date1, 4.0);
    private FuelQuote secondPurchase = new FuelQuote(2, 10, "12345 Address Ln", date2, 5.0);
    private FuelQuote thirdPurchase = new FuelQuote(3, 80, "12345 Address Ln", date3, 6.0);
    public FuelQuoteService() {}

    public List<FuelQuote> getQuotes() {
        return List.of(firstPurchase, secondPurchase, thirdPurchase);
    }
}
