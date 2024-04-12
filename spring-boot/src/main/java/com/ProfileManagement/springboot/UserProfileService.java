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

    public UserProfile createProfile(UserProfile userProfile) {
        try {
            UserProfile savedProfile = userProfileRepository.save(userProfile);
            logger.info("New Profile Created: {}", savedProfile);
            return savedProfile;
        } catch(Exception e) {
            logger.error("Error creating profile: {}", e.getMessage());
            return null;
        }
    }

    public UserProfile updateProfile(UserProfile userProfile){
        try {
            if(userProfile.getID() != null){
                UserProfile existingProfile = userProfileRepository.findById(userProfile.getID()).orElseThrow(() -> new IllegalArgumentException("User profile not found"));
                existingProfile.setFullName(userProfile.getFullName());
                existingProfile.setAddress1(userProfile.getAddress1());
                existingProfile.setAddress2(userProfile.getAddress2());
                existingProfile.setCity(userProfile.getCity());
                existingProfile.setState(userProfile.getState());
                existingProfile.setZipcode(userProfile.getZipcode());
                existingProfile.setProfileCompleted(userProfile.isProfileCompleted());
                UserProfile savedProfile = userProfileRepository.save(existingProfile);
                logger.info("Profile Updated: {}", savedProfile);
                return savedProfile;
            } 
            else {
                throw new IllegalArgumentException("ID MUST NOT BE NULL");
            }
        } catch(Exception e) {
            logger.error("Error updating profile: {}", e.getMessage());
            return null;
        }
    }

    // public UserProfile updateProfile(UserProfile userProfile){
    //     try{
    //         Long id = userProfile.getID();
    //         if(id != null){
    //             //If the profile exists, update it with new data
    //             UserProfile existingProfile = userProfileRepository.findById(userProfile.getID()).orElseThrow(() -> new IllegalArgumentException("User profile not found"));
    //             existingProfile.setFullName(userProfile.getFullName());
    //             existingProfile.setAddress1(userProfile.getAddress1());
    //             existingProfile.setAddress2(userProfile.getAddress2());
    //             existingProfile.setCity(userProfile.getCity());
    //             existingProfile.setState(userProfile.getState());
    //             existingProfile.setZipcode(userProfile.getZipcode());
    //             existingProfile.setProfileCompleted(userProfile.isProfileCompleted());

    //             UserProfile savedProfile = userProfileRepository.save(existingProfile);
    //             logger.info("Profile Updated: {}", savedProfile);
    //             return savedProfile;
    //         } 
    //         else{
    //             //If profile does not exist then make one
    //             UserProfile savedProfile = userProfileRepository.save(userProfile);
    //             logger.info("New Profile Created: {}", savedProfile);
    //             return savedProfile;
    //         }
    //     } catch(Exception e){
    //         logger.error("Error Updating Profile Because there is no ID: {}", e.getMessage());

    //         return null;
    //     }
    // }

    

    public UserProfile getUserProfileById(Long ID) {
        return userProfileRepository.findById((ID)).orElse(null);
    }

    public List<UserProfile> getAllUserProfiles() {

        return userProfileRepository.findAll();
    }

    public void deleteUserProfile(Long ID) {
        try {
            userProfileRepository.deleteById(ID);
            logger.info("Profile deleted: {}", ID);
        } catch (Exception e) {
            logger.error("Error deleting profile: {}", e.getMessage());
        }
    }


}
