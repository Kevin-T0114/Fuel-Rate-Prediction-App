package com.example.springboot.Registration;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Registration {

    @NotNull(message = "The username field should not be empty")
    @NotEmpty(message = "The username field should not be empty")
    private String userName;

    @NotNull(message = "The password field should not be empty")
    @NotEmpty(message = "The password field should not be empty")
    private String passWord;

    @NotNull(message = "The password verification field should not be empty")
    @NotEmpty(message = "The password verification field should not be empty")
    private String vfyPassword;

    private Boolean userExists;

    public Registration() {
    }

    public Registration(String userName, String passWord, String vfyPassword, Boolean userExists) {
        this.userName = userName;
        this.passWord = passWord;
        this.vfyPassword = vfyPassword;
        this.userExists = userExists;
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

    public String getvfyPassword() {
        return this.vfyPassword;
    }

    public void setvfyPassword(String vfyPassword) {
        this.vfyPassword = vfyPassword;
    }

    public Boolean isuserExists() {
        return this.userExists;
    }

    public void setuserExists(Boolean userExists) {
        this.userExists = userExists;
    }

}
