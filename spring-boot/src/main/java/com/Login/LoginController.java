package com.Login;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "api/v1/Login")
@Validated
public class LoginController {

    private final LoginService LoginService;

    @Autowired
    public LoginController(LoginService LoginService) {
        this.LoginService = LoginService;
    }

    @PostMapping
    public ResponseEntity<String> checkLogin(@RequestBody @Valid Login login) {
        String msg = LoginService.checkLogin(login);
        return ResponseEntity
                .accepted()
                .body(msg);
    }

    @GetMapping
    public ResponseEntity<Login> getLogin() { // Change from hard-coded values to things grabbed from API
        Login log = new Login();
        log.setuserName("Adam");
        log.setpassWord("Yes");
        log.setuserExists(true);
        log.setcorrectPass(true);
        return ResponseEntity.accepted().body(log);
    }
}
