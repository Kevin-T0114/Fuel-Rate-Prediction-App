package com.ProfileManagement.springboot;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Validated
public class UserProfile {

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

    // Getters and setters
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
