package com.Registration;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "api/v1/Registration")
public class RegistrationController {

    private final RegistrationService RegistrationService;

    @Autowired
    public RegistrationController(RegistrationService RegistrationService) {
        this.RegistrationService = RegistrationService;
    }

    @PostMapping
    public ResponseEntity<String> checkRegistration(@RequestBody Registration registration) {
        String msg = RegistrationService.checkRegistration(registration);

        return ResponseEntity.accepted().body(msg);
    }

    @GetMapping
    public ResponseEntity<Registration> getRegistration() {
        Registration reg = new Registration();
        reg.setuserName("Pog");
        reg.setpassWord("Yes");
        reg.setvfyPassword("Yes");
        reg.setuserExists(false);
        return ResponseEntity.accepted().body(reg);
    }
}
