/* package PricingModule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.FuelQuote.FuelQuoteRepository;
import com.PricingModule.PricingModuleController;
import com.PricingModule.PricingModuleService;

@TestInstance(Lifecycle.PER_CLASS)
@WebMvcTest(PricingModuleController.class)
public class PricingModuleControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricingModuleService pricingModuleService;

    @MockBean
    private FuelQuoteRepository fuelQuoteRepository;

    @Test
    private void getUserLocationTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/form/location")
        .param("User", "aa"))
        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }
}
 */