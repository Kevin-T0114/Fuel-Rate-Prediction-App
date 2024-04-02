package com.ProfileManagement.springboot;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserProfileService {
    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);
    public UserProfile updateProfile(UserProfile userProfile){
        //Implement Logic
        // This method should interact with the database or any other storage mechanism
        //For right now i plan on just returning the given profile as is.

        logger.info("Updating profile: {}", userProfile.toString());


        logger.info("Profile updated: {}", userProfile.toString());
        
        return userProfile;
    }

}
