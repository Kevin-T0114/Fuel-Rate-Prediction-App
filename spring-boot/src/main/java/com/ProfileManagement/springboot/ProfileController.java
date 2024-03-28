package com.ProfileManagement.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping(path="/api/profile")

public class ProfileController {
    
    private final UserProfileService userProfileService;

    @Autowired
    public ProfileController(UserProfileService userProfileService){
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public String hello() {
        return userProfileService.hello();
    }
    

    @PostMapping("/update")
    public UserProfile updateProfile(@RequestBody UserProfile userProfile){
        System.out.println("Recieved request to update profile: " + userProfile);
        return userProfileService.updateProfile(userProfile);
    }
    
}
