package com.ProfileManagement.springboot;

import java.util.List;

import org.springframework.validation.annotation.Validated;


import com.FuelQuote.FuelQuote;
import com.Registration.Registration;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Validated
@Entity
@Table(name = "user_profile")
public class UserProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_profile_seq")
    @SequenceGenerator(name = "user_profile_seq", sequenceName = "user_profile_sequence", allocationSize = 1)
    @Column(name = "user_id")

    private Long id;

    @NotBlank(message = "Username is required")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Full name is required")
    @Size(max = 50, message = "Full name must be less than or equal to 50 characters")
    private String fullName;

    @NotBlank(message = "Address line 1 is required")
    @Size(max = 100, message = "Address line 1 must be less than or equal to 100 characters")
    private String address1;

    @Size(max = 100, message = "Address line 2 must be less than or equal to 100 characters")
    private String address2;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City must be less than or equal to 100 characters")
    private String city;

    @NotBlank(message = "State is requried")
    private String state;

    @NotBlank(message = "Zipcode is required")
    @Size(min = 5, max = 9, message = "Zipcode must be between 5 and 9 characters")
    private String zipcode;
    private boolean profileCompleted;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quote_id")
    private List<FuelQuote> fuelQuotes;

    // Getters and setters
    public Long getID() {
        return userId;

    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public boolean isProfileCompleted() {
        return profileCompleted;
    }

    // Setters

    public void setID(Long id) {
        this.userId = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setProfileCompleted(boolean profileCompleted) {
        this.profileCompleted = profileCompleted;
    }



}
