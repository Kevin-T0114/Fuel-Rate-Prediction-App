package com.FuelQuote;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FuelQuoteTest {
    
    //constructor class variable tests
    @Test
    public void testID() {
        FuelQuote obj = new FuelQuote(1L, 6, "12345 Address Ln", LocalDate.of(2003, 6, 5), 4.0);
        Assertions.assertEquals(1L, obj.getID());
    }

    @Test
    public void testGallonsRequested() {
        FuelQuote obj = new FuelQuote(1L, 6, "12345 Address Ln", LocalDate.of(2003, 6, 5), 4.0);
        Assertions.assertEquals(6, obj.getGallonsRequested());
    }

    @Test
    public void testAddress() {
        FuelQuote obj = new FuelQuote(1L, 6, "12345 Address Ln", LocalDate.of(2003, 6, 5), 4.0);
        Assertions.assertEquals("12345 Address Ln", obj.getAddress());
    }

    @Test
    public void testDeliveryDate() {
        FuelQuote obj = new FuelQuote(1L, 6, "12345 Address Ln", LocalDate.of(2003, 6, 5), 4.0);
        Assertions.assertEquals(LocalDate.of(2003, 6, 5), obj.getDeliveryDate());
    }

    @Test
    public void testPricePerGallon() {
        FuelQuote obj = new FuelQuote(1L, 6, "12345 Address Ln", LocalDate.of(2003, 6, 5), 4.0);
        Assertions.assertEquals(4, obj.getPricePerGallon());
    }

    @Test
    public void testTotalPrice() {
        FuelQuote obj = new FuelQuote(1L, 6, "12345 Address Ln", LocalDate.of(2003, 6, 5), 4.0);
        Assertions.assertEquals(24, obj.getTotalPrice());
    }

    //testing class member changes
    @Test
    public void testIDAfterChange() {
        FuelQuote obj = new FuelQuote(1L, 6, "12345 Address Ln", LocalDate.of(2003, 6, 5), 4.0);
        obj.setID(5L);
        Assertions.assertEquals(5, obj.getID());
    }

    /* @Test
    public void testTotalPriceAfterChangingGallonsRequested() {
        FuelQuote obj = new FuelQuote(1L, 6, "12345 Address Ln", LocalDate.of(2003, 6, 5), 4.0);
        obj.setGallonsRequested(13);
        obj.setTotalPrice(obj.getGallonsRequested(), obj.getPricePerGallon());
        Assertions.assertEquals(52, obj.getTotalPrice());
    }

    @Test
    public void testTotalPriceAfterChangingPricePerGallon() {
        FuelQuote obj = new FuelQuote(1L, 6, "12345 Address Ln", LocalDate.of(2003, 6, 5), 4.0);
        obj.setPricePerGallon(13.12);
        obj.setTotalPrice(obj.getGallonsRequested(), obj.getPricePerGallon());
        Assertions.assertEquals(78.72, obj.getTotalPrice());
    } */

    @Test
    public void testAddressAfterChange() {
        FuelQuote obj = new FuelQuote(1L, 6, "12345 Address Ln", LocalDate.of(2003, 6, 5), 4.0);
        obj.setAddress("11111 Harlem Rd.");
        Assertions.assertEquals("11111 Harlem Rd.", obj.getAddress());
    }

    @Test
    public void testDeliveryDateAfterChange() {
        FuelQuote obj = new FuelQuote(1L, 6, "12345 Address Ln", LocalDate.of(2003, 6, 5), 4.0);
        obj.setDeliveryDate(LocalDate.of(2010, 5, 6));
        Assertions.assertEquals(LocalDate.of(2010, 5, 6), obj.getDeliveryDate());
    }

    
}
