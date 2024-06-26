package com.ProfileManagement.springboot;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class UserProfileService {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile manageProfile(UserProfile userProfile) {
        UserProfile P = new UserProfile();
        if (!userProfileRepository.findByUsername(userProfile.getUsername()).isEmpty()) {
            List<UserProfile> ProList = userProfileRepository.findByUsername(userProfile.getUsername());
            P = ProList.get(0);
            updateProfile(P, userProfile);


        } else {
            System.out.println("UserName: " + userProfile.getUsername());
            createProfile(userProfile);

        }
        return P;

    }

    public UserProfile createProfile(UserProfile userProfile) {
        try {
            UserProfile savedProfile = userProfileRepository.save(userProfile);
            logger.info("New Profile Created: {}", savedProfile);
            return savedProfile;
        } catch (Exception e) {
            logger.error("Error creating profile: {}", e.getMessage());
            return null;
        }
    }

    public UserProfile updateProfile(UserProfile existingProfile, UserProfile userProfile) {
        try {
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

            // userProfileRepository.findById(userProfile.getID()).orElseThrow(() -> new
            // IllegalArgumentException("User profile not found"));
        } catch (Exception e) {
            logger.error("Error updating profile: {}", e.getMessage());
            return null;
        }
    }
}
