package com.FuelQuote;

import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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

    @Test
    void canGetStateByUsername() {
        String user = "aa";
        fuelQuoteService.getState(user);
        verify(fuelQuoteRepository).findStateByUsername(user);
    }

    @Test
    void canGetAddressByUsername() {
        String user = "aa";
        fuelQuoteService.getAddress(user);
        verify(fuelQuoteRepository).findAddressByUsername(user);
    }

    @Test
    void addNewQuote() {
        FuelQuote newQuote = new FuelQuote(1L,1.6F,"12345 Test Dr.", Date.valueOf("2003-4-5"),3.4);
        fuelQuoteService.addQuote(newQuote);
        ArgumentCaptor<FuelQuote> newQuoteArgumentCaptor = ArgumentCaptor.forClass(FuelQuote.class);
        verify(fuelQuoteRepository).save(newQuoteArgumentCaptor.capture());
        FuelQuote captured = newQuoteArgumentCaptor.getValue();
        Assertions.assertThat(captured).isEqualTo(newQuote);
    }
}
