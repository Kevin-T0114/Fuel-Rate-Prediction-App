package com.Login;

import org.springframework.stereotype.Service;

@Service
public class LoginService { // Connect to DB to check if Username is in database and if it is the correct
                            // password
    public String checkLogin(Login login) {
        return "Success";
    }

}
