/* package PricingModule;

import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.FuelQuote.FuelQuote;
import com.FuelQuote.FuelQuoteRepository;
import com.PricingModule.PricingModule;
import com.PricingModule.PricingModuleService;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PricingModuleServiceTest {
    
    @Mock
    private FuelQuoteRepository fuelQuoteRepository;

    private PricingModuleService pricingModuleService;

    @BeforeEach
    void setUp() {
        pricingModuleService = new PricingModuleService(fuelQuoteRepository);
    }

    @Test
    void canGetUserIDByUsername() {
        String user = "aa";
        pricingModuleService.getUser(user);
        verify(fuelQuoteRepository).findbyUsername(user);
    }

    @Test
    void canGetStateByUsername() {
        String user = "aa";
        pricingModuleService.getState(user);
        verify(fuelQuoteRepository).findStateByUsername(user);
    }

    @Test
    void addNewQuoteTest() {
        String gallons = "1.5";
        String ppg = "1.5";
        double due = Double.parseDouble(gallons) * Double.parseDouble(ppg);
        String constructorDue = String.valueOf(due);
        PricingModule pricingModule = new PricingModule(gallons, "12345 Test Address", "2024-4-22", ppg, constructorDue);
        pricingModule.setId(1L);
        pricingModuleService.addQuote(pricingModule);
        ArgumentCaptor<FuelQuote> pricingModulArgumentCaptor = ArgumentCaptor.forClass(FuelQuote.class);
        verify(fuelQuoteRepository).save(pricingModulArgumentCaptor.capture());
        FuelQuote captured = pricingModulArgumentCaptor.getValue();
        Assertions.assertThat(captured).isEqualTo(pricingModulArgumentCaptor);
    }
}
 */