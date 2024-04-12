package com.ProfileManagement.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserProfileServiceTest {
	@Autowired
	private UserProfileService userProfileService;

	// @Test
	// public void testUpdateProfile() {
	// UserProfile userProfile = new UserProfile();
	// userProfile.setFullName("John Wick");
	// userProfile.setAddress1("123 Main St");
	// userProfile.setAddress2("123 Main St");
	// userProfile.setCity("New York");
	// userProfile.setState("NY");
	// userProfile.setZipcode("10001");
	// userProfile.setProfileCompleted(false);

	// UserProfile updatedProfile = userProfileService.updateProfile(userProfile);

	// assertEquals((userProfile), updatedProfile);
	// assertEquals("John Wick", userProfile.getFullName());
	// assertEquals("123 Main St", userProfile.getAddress1());
	// assertEquals("123 Main St", userProfile.getAddress2());
	// assertEquals("New York", userProfile.getCity());
	// assertEquals("NY", userProfile.getState());
	// assertEquals("10001", userProfile.getZipcode());
	// assertEquals(userProfile.isProfileCompleted(), false);
	// }

}
