package com.example.springboot;
import java.util.*; 
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PricingModuleTests {

	@Test
	public String PricingTest() {
		PricingModule myPricingModule = new PricingModule();
		String locationTest = myPricingModule.GetLocation();
		float priceTest = myPricingModule.MakePrice();

		boolean l = ("Texas".equals(locationTest));
		boolean k = (37 == priceTest);
		
		Map<String, String> myMap = new HashMap<>();
		myMap.put("Gallons", "0");
		myMap.put("Address", "1");
		myMap.put("Date", "2");
		myMap.put("Price", "3");
		myMap.put("Due", "4");

		String getQuoteTest = myPricingModule.getQuotes(myMap);

		boolean z = ("Quote{id=null, Gallons='0', Address='1', Date='2', Price='3', Due='4'}".equals(getQuoteTest));

		myPricingModule.myQuote.setId((long)0);
		myPricingModule.myQuote.setGallons("0");
		myPricingModule.myQuote.setAddress("0");
		myPricingModule.myQuote.setDate("0");
		myPricingModule.myQuote.setPrice("0");
		myPricingModule.myQuote.setDue("0");

		long id = myPricingModule.myQuote.getId();
		String gallons = myPricingModule.myQuote.getGallons();
		String address = myPricingModule.myQuote.getAddress();
		String date = myPricingModule.myQuote.getDate();
		String price = myPricingModule.myQuote.getPrice();
		String due = myPricingModule.myQuote.getDue();

		boolean a = ((long)0 == id);
		boolean b = ("0".equals(gallons));
		boolean c = ("0".equals(address));
		boolean d = ("0".equals(date));
		boolean e = ("0".equals(price));
		boolean f = ("0".equals(due));

		String result = "";
		if (l) {result = result + "1";} else {result = result + "0";}
		if (k) {result = result + "1";} else {result = result + "0";}
		if (z) {result = result + "1";} else {result = result + "0";}
		if (a) {result = result + "1";} else {result = result + "0";}
		if (b) {result = result + "1";} else {result = result + "0";}
		if (c) {result = result + "1";} else {result = result + "0";}
		if (d) {result = result + "1";} else {result = result + "0";}
		if (e) {result = result + "1";} else {result = result + "0";}
		if (f) {result = result + "1";} else {result = result + "0";}
		return result;
	}

}
