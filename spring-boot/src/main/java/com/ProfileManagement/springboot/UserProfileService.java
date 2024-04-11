package com.ProfileManagement.springboot;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class UserProfileService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository){
        this.userProfileRepository = userProfileRepository;
    }


    public UserProfile updateProfile(UserProfile userProfile){
        try{
            UserProfile savedProfile = userProfileRepository.save(userProfile);
            logger.info("Profile Updated: {}", savedProfile);
            return savedProfile;
        } catch(Exception e){
            logger.error("Error Updating Profile: {}", e.getMessage());

            return null;
        }
    }
    
    public UserProfile getUserProfileById(Long id) {
        // Implement logic to retrieve user profile by ID
        return userProfileRepository.findById(id).orElse(null);
    }

    public List<UserProfile> getAllUserProfiles() {
        // Implement logic to retrieve all user profiles
        return userProfileRepository.findAll();
    }

    public void deleteUserProfile(Long id) {
        // Implement logic to delete a user profile by ID
        try {
            userProfileRepository.deleteById(id);
            logger.info("Profile deleted: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting profile: {}", e.getMessage());
            // Handle exception or log error based on your requirement
        }
    }


}
