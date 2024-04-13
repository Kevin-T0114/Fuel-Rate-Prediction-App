package com.ProfileManagement.springboot;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ProfileManagement.springboot.UserProfile;
import com.ProfileManagement.springboot.UserProfileRepository;
import com.ProfileManagement.springboot.UserProfileService;

public class UserProfileServiceTest {

    @Mock
    private UserProfileRepository userProfileRepository;
    @InjectMocks
    private UserProfileService userProfileService;

    private AutoCloseable autoCloseable;
    

    @BeforeEach
    void setup(){
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void teardown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void CanManageProfile(){
        UserProfile existingProfile = new UserProfile();
        existingProfile.setUsername("existingUser");
        List<UserProfile> userProfileList = new ArrayList<>();
        userProfileList.add(existingProfile);

        when(userProfileRepository.findByUsername("existingUser")).thenReturn(userProfileList);
        
        UserProfile updatedProfile = new UserProfile();
        updatedProfile.setUsername("existingUser");

        UserProfile result = userProfileService.manageProfile(updatedProfile);

        verify(userProfileRepository, times(2)).findByUsername("existingUser");
        //verify(userProfileRepository, times(2)).save(updatedProfile);

        assert result != null;
        assert result.getUsername().equals("existingUser");
    }

    @Test
    void CanCreateProfile(){

        UserProfile newProfile = new UserProfile();
        newProfile.setUsername("newUser");
    
        when(userProfileRepository.findByUsername("newUser")).thenReturn(new ArrayList<>());

        UserProfile result = userProfileService.manageProfile(newProfile);

        verify(userProfileRepository, times(1)).findByUsername("newUser");
        verify(userProfileRepository, times(1)).save(newProfile);
        
        assert result != null;
        //assert result.getUsername().equals("newUser");

    }
  
}
