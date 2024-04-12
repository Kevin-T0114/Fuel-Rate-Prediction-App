package com.ProfileManagement.springboot;

import org.springframework.stereotype.Service;

import com.Registration.Registration;
import com.Registration.RegistrationRepository;
import com.Registration.RegistrationService;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);
    private final UserProfileRepository userProfileRepository;
    private final RegistrationRepository registrationRepository;


    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository, RegistrationRepository registrationRepository) {
        this.userProfileRepository = userProfileRepository;
        this.registrationRepository = registrationRepository;
    }
    @PostConstruct
    public void init(){
        populateUserProfilesFromRegistrations();
    }
    
    public void populateUserProfilesFromRegistrations(){
        List<Registration> Registered = registrationRepository.findAll();
        for(Registration registration : Registered){
            UserProfile userProfile = new UserProfile();
            userProfile.setUsername(registration.getuserName());
            logger.info("New Username Registered: {}", userProfile);
            userProfileRepository.save(userProfile);
        }

    }

    public UserProfile manageProfile(UserProfile userProfile) {
        UserProfile P = new UserProfile();
        if (!userProfileRepository.findAll().isEmpty()) {
            UserProfile Dummy = createProfile(userProfile);
            List<UserProfile> ProList = userProfileRepository.findAll();
            P = ProList.get(0);
            System.out.println(P.getCity());
        } else {
            List<UserProfile> ProList = userProfileRepository.findByCity("Houston");
            P = ProList.get(0);
            UserProfile Dummy = updateProfile(P, userProfile);
            System.out.println(P.getCity());

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
