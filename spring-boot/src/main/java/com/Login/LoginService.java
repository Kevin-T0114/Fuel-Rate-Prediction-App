package com.Login;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService { // Connect to DB to check if Username is in database and if it is the correct
                            // password
    private final LoginValidator validator;

    public String checkLogin(Login login) {
        var violations = validator.validate(login);
        if (!violations.isEmpty()) {
            return violations.stream().collect(Collectors.joining("\n"));
        }
        return "Success";
    }

}
