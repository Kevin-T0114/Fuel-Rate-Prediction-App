package com.ProfileManagement.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ProfileManagement.springboot.ProfileController;
import com.ProfileManagement.springboot.UserProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProfileController.class)
public class UserProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserProfileService service;

    @Test
    public void testControllerConnection() throws Exception {
        Object obj = new Object() {
            public final String userProfile = "s";
            public final Boolean profileCompleted = true;
            public final String fullName = "POIGGERS";
            public final String address1 = "asdasdasdas";
            public final String address2 = "hdasjdaskjhdaskjdas";
            public final String city = "HOUST";
            public final String state = "TX";
            public final String zipcode = "445454";
            public final String username = "pog";
        };
        ObjectMapper map = new ObjectMapper();
        String json = map.writeValueAsString(obj);

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/profile/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}