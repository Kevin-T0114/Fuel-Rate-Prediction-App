package com.Registration;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "api/v1/Registration")
@Validated
public class RegistrationController {

    private final RegistrationService RegistrationService;

    @Autowired
    public RegistrationController(RegistrationService RegistrationService) {
        this.RegistrationService = RegistrationService;
    }

    @PostMapping
    public ResponseEntity<Boolean> addNewAccount(@RequestBody @Valid Registration registration) {
        Boolean s = RegistrationService.addNewAccount(registration);
        return ResponseEntity.accepted().body(s);
    }
}
