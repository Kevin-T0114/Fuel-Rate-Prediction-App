package com.ProfileManagement.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/profile")

public class ProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/update")
    public UserProfile updateProfile(@RequestBody UserProfile userProfile){
        return userProfileService.updateProfile(userProfile);
    }
}
