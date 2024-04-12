package com.Registration;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "account")
@Validated
public class Registration {

    @Id
    @NotNull(message = "The username field should not be empty")
    @NotEmpty(message = "The username field should not be empty")
    @Column(name = "username", nullable = false, columnDefinition = "TEXT", updatable = false)
    private String userName;

    @NotNull(message = "The password field should not be empty")
    @NotEmpty(message = "The password field should not be empty")
    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String passWord;

    public Registration() {
    }

    public Registration(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getuserName() {
        return this.userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getpassWord() {
        return this.passWord;
    }

    public void setpassWord(String passWord) {
        this.passWord = passWord;
    }

}
