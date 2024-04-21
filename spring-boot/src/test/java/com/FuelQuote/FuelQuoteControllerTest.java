package com.FuelQuote;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

}
