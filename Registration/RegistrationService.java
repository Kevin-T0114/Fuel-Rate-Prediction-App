package com.Registration;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationService { // figure out what to return

    private final RegistrationValidator validator;

    public String checkRegistration(Registration registration) {
        var violations = validator.validate(registration);
        if (!violations.isEmpty()) {
            return violations.stream().collect(Collectors.joining("\n"));
        }
        return "Success!";
    }

}
