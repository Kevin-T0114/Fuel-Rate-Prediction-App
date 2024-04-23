package com.FuelQuote;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuelQuoteTest {

    FuelQuote obj = null;
    
    //constructor class variable tests
    @BeforeEach
    void setUp() {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date date = Date.valueOf("2003-06-05");
        obj = new FuelQuote(1L, 6, "12345 Address Ln", date, 4.0);
    }

    @Test
    public void testID() {
        Assertions.assertEquals(1L, obj.getID());
    }

    @Test
    public void testGallonsRequested() {
        Assertions.assertEquals(6, obj.getGallonsRequested());
    }

    @Test
    public void testAddress() {
        Assertions.assertEquals("12345 Address Ln", obj.getAddress());
    }

    @Test
    public void testDeliveryDate() {
        Assertions.assertEquals(Date.valueOf("2003-06-05"), obj.getDeliveryDate());
    }

    @Test
    public void testPricePerGallon() {
        Assertions.assertEquals(4, obj.getPricePerGallon());
    }

    @Test
    public void testTotalPrice() {
        Assertions.assertEquals(24, obj.getTotalPrice());
    }

    @Test
    public void testUserID() {
        obj.setUserID(1L);
        Assertions.assertEquals(1L, obj.getUserID());
    }

    //testing class member changes
    @Test
    public void testIDAfterChange() {
        obj.setID(5L);
        Assertions.assertEquals(5, obj.getID());
    }

    @Test
    public void testUserIDAfterChange() {
        obj.setUserID(5L);
        Assertions.assertEquals(5L, obj.getUserID());
    }

    @Test
    public void testTotalPriceAfterChangingGallonsRequested() {
        obj.setGallonsRequested(13);
        obj.setTotalPrice(obj.getGallonsRequested(), obj.getPricePerGallon());
        Assertions.assertEquals(52, obj.getTotalPrice());
    }

    @Test
    public void testTotalPriceAfterChangingPricePerGallon() {
        obj.setPricePerGallon(13.12);
        obj.setTotalPrice(obj.getGallonsRequested(), obj.getPricePerGallon());
        Assertions.assertEquals(78.72, obj.getTotalPrice());
    }

    @Test
    public void testAddressAfterChange() {
        obj.setAddress("11111 Harlem Rd.");
        Assertions.assertEquals("11111 Harlem Rd.", obj.getAddress());
    }

    @Test
    public void testDeliveryDateAfterChange() {
        obj.setDeliveryDate(Date.valueOf("2010-05-06"));
        Assertions.assertEquals(Date.valueOf("2010-05-06"), obj.getDeliveryDate());
    }

    @Test
    void testToString() {
        Long id = obj.getID();
        String val = "Quote{" +
					"id=" + id +
					", Gallons='" + obj.getGallonsRequested() + '\'' +
					", Address='" + obj.getAddress() + '\'' +
					", Date='" + obj.getDeliveryDate() + '\'' +
					", Price='" + obj.getPricePerGallon() + '\'' +
					", Due='" + obj.getTotalPrice() + '\'' +
					'}';
        Assertions.assertEquals(val, obj.toString());
    }
}
