package com.Login;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Validated
public class Login {

    @NotNull(message = "The username field should not be empty")
    @NotEmpty(message = "The username field should not be empty")
    private String userName;

    @NotNull(message = "The password field should not be empty")
    @NotEmpty(message = "The password field should not be empty")
    private String passWord;

    private Boolean userExists;
    private Boolean correctPass;

    public Login() {
    }

    public Login(String userName, String passWord, Boolean userExists, Boolean correctPass) {
        this.userName = userName;
        this.passWord = passWord;
        this.userExists = userExists;
        this.correctPass = correctPass;
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

    public Boolean isuserExists() {
        return this.userExists;
    }

    public void setuserExists(Boolean userExists) {
        this.userExists = userExists;
    }

    public Boolean iscorrectPass() {
        return this.correctPass;
    }

    public void setcorrectPass(Boolean correctPass) {
        this.correctPass = correctPass;
    }

}
