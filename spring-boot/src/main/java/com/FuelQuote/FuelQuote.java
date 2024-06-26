package com.FuelQuote;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quote")
public class FuelQuote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "gallons_requested")
    private float gallonsRequested;

    @Column(name = "address")
    private String address;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "price_per_gallon")
    private double pricePerGallon;

    @Column(name = "total")
    private double totalPrice;

    public FuelQuote(){};
    
    public FuelQuote(Long id_, float gallonsRequested_, String address_, Date deliveryDate_, double pricePerGallon_) {
        DecimalFormat df = new DecimalFormat("#.##");
        this.id = id_;
        this.gallonsRequested = gallonsRequested_;
        this.address = address_;
        this.deliveryDate = deliveryDate_;
        this.pricePerGallon = Double.parseDouble(df.format(pricePerGallon_));
        this.totalPrice = Double.parseDouble(df.format(gallonsRequested_*pricePerGallon_));
    }
    
    public void setID(Long id_) {
        id = id_;
    }
    public Long getID() {
        return this.id;
    }
    public void setUserID(Long userId_) {
        userId = userId_;
    }
    public Long getUserID() {
        return this.userId;
    }
    public void setGallonsRequested(float gallonsRequested_) {
        gallonsRequested = gallonsRequested_;
    }
    public float getGallonsRequested() {
        return this.gallonsRequested;
    }
    public void setAddress(String address_) {
        address = address_;
    }
    public String getAddress() {
        return this.address;
    }
    public void setDeliveryDate(Date deliveryDate_) {
        deliveryDate = deliveryDate_;
    }
    public Date getDeliveryDate() {
        return this.deliveryDate;
    }
    public void setPricePerGallon(double pricePerGallon_) {
        DecimalFormat df = new DecimalFormat("##.###");
        pricePerGallon = Double.parseDouble(df.format(pricePerGallon_));
    }
    public double getPricePerGallon() {
        return this.pricePerGallon;
    }
    public void setTotalPrice(float gallonsRequested_, double pricePerGallon_) {
        DecimalFormat df = new DecimalFormat("##.##");
        totalPrice = Double.parseDouble(df.format(gallonsRequested_*pricePerGallon_));
    }
    public double getTotalPrice() {
        return this.totalPrice;
    }
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", Gallons='" + gallonsRequested + '\'' +
                ", Address='" + address + '\'' +
                ", Date='" + deliveryDate + '\'' +
                ", Price='" + pricePerGallon + '\'' +
                ", Due='" + totalPrice + '\'' +
                '}';
    }
}
