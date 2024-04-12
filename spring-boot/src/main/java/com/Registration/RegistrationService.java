package com.Registration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService { // figure out what to return

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public Boolean addNewAccount(Registration registration) {
        Optional<Registration> reg = registrationRepository.findById(registration.getuserName());
        if (reg.isPresent()) {
            return false; // return false if username is already in database
        }
        registrationRepository.save(registration);
        return true; // return true if username is not in database
    }

}
