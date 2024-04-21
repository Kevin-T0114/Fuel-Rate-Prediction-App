package com.FuelQuote;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class FuelQuoteServiceTest {

    @Mock
    private FuelQuoteRepository fuelQuoteRepository;
    private FuelQuoteService fuelQuoteService;

    @BeforeEach
    void setUp() {
        fuelQuoteService = new FuelQuoteService(fuelQuoteRepository);
    }
    
    @Test
    void canGetByUsername() {
        String user = "aa";
        fuelQuoteService.getUserID(user);
        verify(fuelQuoteRepository).findbyUsername(user);
    }

    @Test
    void canGetQuotesForUser() {
        String user = "aa";
        Long id = 1L;
        fuelQuoteService.getUserID(user);
        fuelQuoteService.getQuotes(id);
        verify(fuelQuoteRepository).findByUserID(id);
    }
}
