package com.Registration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RegistrationService registrationService;

    @Test
    public void testLogin() throws Exception {
        Object obj = new Object() {
            public final String userName = "Adam";
            public final String passWord = "Yes";
        };
        ObjectMapper objMapper = new ObjectMapper();
        String json = objMapper.writeValueAsString(obj);

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/Login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andReturn();

    }

    @Test
    public void testRegistration() throws Exception {
        Object obj = new Object() {
            public final String userName = "Adam";
            public final String passWord = "Yes";
        };
        ObjectMapper objMapper = new ObjectMapper();
        String json = objMapper.writeValueAsString(obj);

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/Registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andReturn();

    }
}
