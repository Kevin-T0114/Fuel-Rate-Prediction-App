package com.FuelQuote;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class FuelQuote {
    private int id;
    private int gallonsRequested;
    private String address;
    private LocalDate deliveryDate;
    private double pricePerGallon;
    private double totalPrice;
    
    public FuelQuote(int id_, int gallonsRequested_, String address_, LocalDate deliveryDate_, double pricePerGallon_) {
        DecimalFormat df = new DecimalFormat("#.##");
        this.id = id_;
        this.gallonsRequested = gallonsRequested_;
        this.address = address_;
        this.deliveryDate = deliveryDate_;
        this.pricePerGallon = Double.parseDouble(df.format(pricePerGallon_));
        this.totalPrice = Double.parseDouble(df.format(gallonsRequested_*pricePerGallon_));
    }
    public void setID(int id_) {
        id = id_;
    }
    public int getID() {
        return this.id;
    }
    public void setGallonsRequested(int gallonsRequested_) {
        gallonsRequested = gallonsRequested_;
    }
    public int getGallonsRequested() {
        return this.gallonsRequested;
    }
    public void setAddress(String address_) {
        address = address_;
    }
    public String getAddress() {
        return this.address;
    }
    public void setDeliveryDate(LocalDate deliveryDate_) {
        deliveryDate = deliveryDate_;
    }
    public LocalDate getDeliveryDate() {
        return this.deliveryDate;
    }
    public void setPricePerGallon(double pricePerGallon_) {
        pricePerGallon = pricePerGallon_;
    }
    public double getPricePerGallon() {
        return this.pricePerGallon;
    }
    public void setTotalPrice(int gallonsRequested_, double pricePerGallon_) {
        totalPrice = gallonsRequested_*pricePerGallon_;
    }
    public double getTotalPrice() {
        return this.totalPrice;
    }
}
