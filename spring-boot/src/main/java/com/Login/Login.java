package com.Login;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Validated
public class Login {

    @Id
    @NotNull(message = "The username field should not be empty")
    @NotEmpty(message = "The username field should not be empty")
    private String userName;

    @NotNull(message = "The password field should not be empty")
    @NotEmpty(message = "The password field should not be empty")
    private String passWord;

    public Login() {
    }

    public Login(String userName, String passWord) {
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
