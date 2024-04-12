package com.Registration;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "api/v1/{id}")
@Validated
public class RegistrationController {

    private final RegistrationService RegistrationService;

    @Autowired
    public RegistrationController(RegistrationService RegistrationService) {
        this.RegistrationService = RegistrationService;
    }

    @PostMapping
    public ResponseEntity<Boolean[]> handleAccount(@RequestBody @Valid Registration registration,
            @PathVariable String id) {
        Boolean s[] = { false, false };
        if (id.equals("Login")) {
            // System.out.println("hello banana");
            s[0] = RegistrationService.checkUsername(registration.getuserName());
            s[1] = RegistrationService.checkPassword(registration);
        } else if (id.equals("Registration")) {
            // System.out.println("hello hey");
            s[0] = RegistrationService.addNewAccount(registration);
        }
        // System.out.println(s + " HOLY MOLY");
        return ResponseEntity.accepted().body(s);
    }
}
