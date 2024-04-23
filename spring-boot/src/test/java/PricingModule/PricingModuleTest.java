/* package PricingModule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.PricingModule.PricingModule;

@TestInstance(Lifecycle.PER_CLASS)
public class PricingModuleTest {

    PricingModule pricingModule = null;

    @BeforeEach
    void setUp() {
        String gallons = "1.5";
        String ppg = "1.5";
        double due = Double.parseDouble(gallons) * Double.parseDouble(ppg);
        String constructorDue = String.valueOf(due);
        pricingModule = new PricingModule(gallons, "12345 Test Address", "2024-4-23", ppg, constructorDue);   
        pricingModule.setId(1L);
    }

    @Test
    void testConstructor() {
        PricingModule object = new PricingModule();
        Assertions.assertNotNull(object);
    }

    //setters
    @Test
    void testSetGallons() {
        pricingModule.setGallons("3.0");
        Assertions.assertEquals("3.0", pricingModule.getGallons());
    }

    @Test
    void testSetAddress() {
        pricingModule.setAddress("12345 Set Address");
        Assertions.assertEquals("12345 Set Address", pricingModule.getAddress());
    }

    @Test
    void testSetDate() {
        pricingModule.setDate("2024-4-22");
        Assertions.assertEquals("2024-4-22", pricingModule.getDate());
    }

    @Test
    void testSetPricePerGallon() {
        pricingModule.setPrice("2.3");
        Assertions.assertEquals("2.3", pricingModule.getPrice());
    }

    @Test
    void testSetDue() {
        pricingModule.setPrice("2.3");
        pricingModule.setGallons("3.0");
        double due = Double.parseDouble(pricingModule.getPrice()) * Double.parseDouble(pricingModule.getGallons());
        pricingModule.setDue(String.valueOf(due));
        Assertions.assertEquals(String.valueOf(due), pricingModule.getDue());
    }

    @Test
    void testSetID() {
        pricingModule.setId(2L);
        Assertions.assertEquals(2L, pricingModule.getId());
    }

    //getters
    @Test
    void testGetGallons() {
        Assertions.assertEquals("1.5", pricingModule.getGallons());
    }

    @Test
    void testGetAddress() {
        Assertions.assertEquals("12345 Test Address", pricingModule.getAddress());
    }

    @Test
    void testGetDate() {
        Assertions.assertEquals("2024-4-23", pricingModule.getDate());
    }

    @Test
    void testGetPricePerGallon() {
        Assertions.assertEquals("1.5", pricingModule.getPrice());
    }

    @Test
    void testGetDue() {
        Assertions.assertEquals("2.25", pricingModule.getDue());
    }

    @Test
    void testGetID() {
        Assertions.assertEquals(1L, pricingModule.getId());
    }

    @Test
    void testToString() {
        Long id = pricingModule.getId();
        String Gallons = pricingModule.getGallons();
        String Address = pricingModule.getAddress();
        String Date = pricingModule.getDate();
        String Price = pricingModule.getPrice();
        String Due = pricingModule.getDue();
        String val = "Quote{" +
					"id=" + id +
					", Gallons='" + Gallons + '\'' +
					", Address='" + Address + '\'' +
					", Date='" + Date + '\'' +
					", Price='" + Price + '\'' +
					", Due='" + Due + '\'' +
					'}';
        Assertions.assertEquals(val, pricingModule.toString());
    }
    
}
 */