package com.FuelQuote;

import java.sql.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@TestInstance(Lifecycle.PER_CLASS)
@WebMvcTest(FuelQuoteControlller.class)
public class FuelQuoteControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private FuelQuoteService fuelQuoteService;

    @Test
    public void getFuelQuoteHistoryTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/quotes/getQuotes")
        .param("User", "aa"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getFuelQuoteHistoryWithoutPathParamTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/quotes/getQuotes"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void getLocationTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/quotes/location"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getPriceTest() throws Exception {
        Object obj = new Object() {
            public final String GallonsRequested = "1.5";
            public final String User = "aa";
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(obj);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/quotes/price")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    }

    @Test
    public void getQuotesTest() throws Exception {
        Object obj = new Object() {
            public final String Date = "2005-6-1";
            public final String Gallons = "1.5";
            public final String Price = "2.3";
            public final String Due = "3.45";
            public final String User = "aa";
            public final String Address = "1234 Address Ln.";
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(obj);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/quotes/result")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    }

    @Test
    public void getUserTest() throws Exception {
        Object obj = new Object() {
            public final String User = "aa";
        };
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(obj);
            this.mockMvc.perform(MockMvcRequestBuilders.post("/api/quotes/user")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
            
    }

}
