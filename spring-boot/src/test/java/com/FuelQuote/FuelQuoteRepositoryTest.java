package com.FuelQuote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ProfileManagement.springboot.UserProfile;
import com.ProfileManagement.springboot.UserProfileRepository;
import com.Registration.Registration;
import com.Registration.RegistrationRepository;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FuelQuoteRepositoryTest {
    
    @Autowired
    private FuelQuoteRepository fuelQuoteRepository;
    
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @BeforeAll
    void objectConstruction() {
        Registration registration = new Registration("aa", "aa");
        registrationRepository.save(registration);

        UserProfile userProfile = new UserProfile();
        userProfile.setAddress1("11111 Harlem Rd.");
        userProfile.setAddress2("");
        userProfile.setCity("Richmond");
        userProfile.setFullName("aa");
        userProfile.setID(1L);
        userProfile.setProfileCompleted(true);
        userProfile.setState("AL");
        userProfile.setUsername(registration.getuserName());
        userProfile.setZipcode("77407");
        userProfileRepository.save(userProfile);

        FuelQuote firstQuote = new FuelQuote(1L, 1.5F, "AL", LocalDate.of(2003, 6, 5), 37.0); 
        fuelQuoteRepository.save(firstQuote);

        FuelQuote secondQuote = new FuelQuote(1L, 1.5F, "AL", LocalDate.of(2003, 6, 7), 37.0); 
        fuelQuoteRepository.save(secondQuote);
    }

    @AfterAll
     void removeEntry() {
        fuelQuoteRepository.deleteAll();
        userProfileRepository.deleteAll();;
        registrationRepository.deleteAll();
    }

    @Test
    void getByUsernameTestWhenUsernameInDB() {
        String username = "aa";
        Long expected = fuelQuoteRepository.findbyUsername(username);
        Assertions.assertTrue(expected == 1L);     
    }

    void getQuotesByIDInDB() {
        Long id = 1L;
        List<FuelQuote> expected = fuelQuoteRepository.findByUserID(id);
        List<FuelQuote> items = new ArrayList<>();
        FuelQuote firstQuote = new FuelQuote(1L, 1.5F, "AL", LocalDate.of(2003, 6, 5), 37.0); 
        FuelQuote secondQuote = new FuelQuote(1L, 1.5F, "AL", LocalDate.of(2003, 6, 7), 37.0); 
        items.add(firstQuote);
        items.add(secondQuote);
        Assertions.assertTrue(expected == items);
    }
}
