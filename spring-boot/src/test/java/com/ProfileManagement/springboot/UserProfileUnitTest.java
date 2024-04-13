package com.ProfileManagement.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserProfileUnitTest {
	@Autowired
	private UserProfileService userProfileService;

	@Test
	public void testUpdateProfile() {
	UserProfile userProfile = new UserProfile();
	userProfile.setFullName("John Wick");
	userProfile.setAddress1("123 Main St");
	userProfile.setAddress2("123 Main St");
	userProfile.setCity("New York");
	userProfile.setState("NY");
	userProfile.setZipcode("10001");
	userProfile.setID(2);
	userProfile.setUsername("Austin");
	userProfile.setProfileCompleted(false);

	UserProfile UpdatedUserProfile = new UserProfile();
	UpdatedUserProfile.setFullName("John Wick");
	UpdatedUserProfile.setAddress1("123 Main St");
	UpdatedUserProfile.setAddress2("123 Main St");
	UpdatedUserProfile.setCity("New York");
	UpdatedUserProfile.setState("NY");
	UpdatedUserProfile.setZipcode("10001");
	UpdatedUserProfile.setID(2);
	UpdatedUserProfile.setUsername("Austin");
	UpdatedUserProfile.setProfileCompleted(false);

	UserProfile updatedProfile = userProfileService.updateProfile(userProfile, UpdatedUserProfile);

	assertEquals(userProfile, userProfile);
	assertEquals(UpdatedUserProfile, UpdatedUserProfile);
	assertEquals("John Wick", userProfile.getFullName());
	assertEquals("123 Main St", userProfile.getAddress1());
	assertEquals("123 Main St", userProfile.getAddress2());
	assertEquals("New York", userProfile.getCity());
	assertEquals("NY", userProfile.getState());
	assertEquals("10001", userProfile.getZipcode());
	assertEquals(2, userProfile.getID());
	assertEquals("Austin", userProfile.getUsername());
	assertEquals(userProfile.isProfileCompleted(), false);
	}

}
