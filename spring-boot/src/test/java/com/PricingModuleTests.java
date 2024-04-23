/* package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
class PricingModuleTests {

	@Disabled
	@Test
	public String PricingTest() {
		PricingModule myPricingModule = new PricingModule();
		String locationTest = myPricingModule.GetLocation();
		assertEquals(locationTest, myPricingModule.GetLocation());
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

		myPricingModule.myQuote.setId((long) 0);
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

		boolean a = ((long) 0 == id);
		boolean b = ("0".equals(gallons));
		boolean c = ("0".equals(address));
		boolean d = ("0".equals(date));
		boolean e = ("0".equals(price));
		boolean f = ("0".equals(due));

		String result = "";
		if (l) {
			result = result + "1";
		} else {
			result = result + "0";
		}
		if (k) {
			result = result + "1";
		} else {
			result = result + "0";
		}
		if (z) {
			result = result + "1";
		} else {
			result = result + "0";
		}
		if (a) {
			result = result + "1";
		} else {
			result = result + "0";
		}
		if (b) {
			result = result + "1";
		} else {
			result = result + "0";
		}
		if (c) {
			result = result + "1";
		} else {
			result = result + "0";
		}
		if (d) {
			result = result + "1";
		} else {
			result = result + "0";
		}
		if (e) {
			result = result + "1";
		} else {
			result = result + "0";
		}
		if (f) {
			result = result + "1";
		} else {
			result = result + "0";
		}
		return result;
	}

	@Disabled
	@Test
	public void testPricing() {
		PricingModule p = new PricingModule();
		PricingModule.Quote q = p.new Quote("1", "street", "1/1", "1", "2");
		assertEquals("1", q.getGallons());
		assertEquals("street", q.getAddress());
		assertEquals("1/1", q.getDate());
		assertEquals("1", q.getPrice());
		assertEquals("2", q.getDue());
		long pog = 123;
		q.setId(pog);
		assertEquals(pog, q.getId());
		q.setGallons("2");
		assertEquals("2", q.getGallons());
		q.setAddress("road");
		assertEquals("road", q.getAddress());
		q.setDate("2/2");
		assertEquals("2/2", q.getDate());
		q.setPrice("5");
		assertEquals("5", q.getPrice());
		q.setDue("0");
		assertEquals("0", q.getDue());
		String g = "2";
		String a = "road";
		String da = "2/2";
		String ps = "5";
		String du = "0";

		String s = "Quote{" +
				"id=" + pog +
				", Gallons='" + g + '\'' +
				", Address='" + a + '\'' +
				", Date='" + da + '\'' +
				", Price='" + ps + '\'' +
				", Due='" + du + '\'' +
				'}';
		assertEquals(s, q.toString());
	}

	//@Test

} */