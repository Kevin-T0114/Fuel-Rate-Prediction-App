package com.ProfileManagement.springboot;

import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    public UserProfile updateProfile(UserProfile userProfile){
        //Implement Logic
        // This method should interact with the database or any other storage mechanism
        //For right now i plan on just returning the given profile as is.
        
        return userProfile;
    }
    
    public String hello(){
        return("Hello it worked");
    }
}
