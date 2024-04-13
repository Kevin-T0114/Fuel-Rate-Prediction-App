package com.ProfileManagement.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping(path = "/api/profile")
@Validated

public class ProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public ProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping("/update")
    public UserProfile updateProfile(@Valid @RequestBody UserProfile userProfile) {
        System.out.println("Recieved request to update/create profile: ");
        return userProfileService.manageProfile(userProfile);
    }
}
