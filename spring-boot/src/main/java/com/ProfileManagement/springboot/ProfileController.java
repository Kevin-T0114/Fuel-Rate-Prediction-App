package com.ProfileManagement.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.annotation.Validated;




@RestController
@RequestMapping(path="/api/profile")
@Validated

public class ProfileController {
    
    private final UserProfileService userProfileService;

    @Autowired
    public ProfileController(UserProfileService userProfileService){
        this.userProfileService = userProfileService;
    }

    // @PostMapping("/update")
    // public ResponseEntity<UserProfile> updateProfile(@Valid @RequestBody UserProfile userProfile){
    //     if(userProfile.getID() != null){
    //         UserProfile existingUserProfile = userProfileService.getUserProfileById(userProfile.getID());
    //         //If there is a profile that currently already exists, then update it
    //         if(existingUserProfile != null){
    //             UserProfile updatedProfile = userProfileService.updateProfile(existingUserProfile);
    //             System.out.println("Recieved request to update profile: " + userProfile);
    //             return ResponseEntity.ok(updatedProfile);
    //         }
    //     }

    //     //If User does not have ID then make a new one
    //     UserProfile newProfile = userProfileService.createProfile(userProfile);
    //     return ResponseEntity.ok(newProfile);
        
        
    

    
    @PostMapping("/update")
    public UserProfile updateProfile(@Valid @RequestBody UserProfile userProfile){
        if(userProfile.getID() == null){
            System.out.println("Recieved request to create profile: ");
            return userProfileService.createProfile(userProfile);
        }
        else{
            System.out.println("Received request to update profile: " + userProfile);
            return userProfileService.updateProfile(userProfile);
        }
        
    }
        
   
    
    // @PostMapping("/update")
    // public ResponseEntity<UserProfile> updatedProfile(@PathVariable Long ID, @Valid @RequestBody UserProfile userProfile) {
    //     if(userProfile.getID() != null){
    //         UserProfile existingUserProfile = userProfileService.getUserProfileById(ID);
    //         if(existingUserProfile == null){
    //             return null;
    //         }

    //         existingUserProfile.setFullName(userProfile.getFullName());
    //         existingUserProfile.setAddress1(userProfile.getAddress1());
    //         existingUserProfile.setAddress2(userProfile.getAddress2());
    //         existingUserProfile.setCity(userProfile.getCity());
    //         existingUserProfile.setState(userProfile.getState());
    //         existingUserProfile.setZipcode(userProfile.getZipcode());
    //         existingUserProfile.setProfileCompleted(userProfile.isProfileCompleted());
    //         UserProfile updatedProfile = userProfileService.updateProfile(existingUserProfile);

    //         System.out.println("Recieved request to update profile: " + userProfile);
    //         return ResponseEntity.ok(updatedProfile);
    //     }
    //     else{
    //         UserProfile newProfile = userProfileService.createProfile(userProfile);
    //         return ResponseEntity.ok(newProfile);
    //     } 
       
    

    // }
}
    



