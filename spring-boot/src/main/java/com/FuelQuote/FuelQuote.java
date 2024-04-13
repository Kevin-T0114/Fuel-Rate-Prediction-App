package com.FuelQuote;
import java.text.DecimalFormat;
import java.time.LocalDate;

import com.ProfileManagement.springboot.UserProfile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private LocalDate deliveryDate;

    @Column(name = "price_per_gallon")
    private double pricePerGallon;

    @Column(name = "total")
    private double totalPrice;

    @ManyToOne
    private UserProfile userProfile;
    
    public FuelQuote(Long id_, float gallonsRequested_, String address_, LocalDate deliveryDate_, double pricePerGallon_) {
        DecimalFormat df = new DecimalFormat("#.##");
        this.id = id_;
        this.gallonsRequested = gallonsRequested_;
        this.address = address_;
        this.deliveryDate = deliveryDate_;
        this.pricePerGallon = Double.parseDouble(df.format(pricePerGallon_));
        this.totalPrice = Double.parseDouble(df.format(gallonsRequested_*pricePerGallon_));
    }
    public void setID(Long  id_) {
        id = id_;
    }
    public Long getID() {
        return this.id;
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
    public UserProfile getUserProfile() {
        return this.userProfile;
    }
}
