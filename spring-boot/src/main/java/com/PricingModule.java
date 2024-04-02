package com;

import java.util.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//change name of file
@CrossOrigin(origins = "http://localhost:3000/form")
@RestController
@RequestMapping("/api/form")

public class PricingModule {
	@CrossOrigin(origins = "http://localhost:3000/form")
	@GetMapping("/location")
	public String GetLocation() {
		String location = "Texas";
		return location;
	}

	@CrossOrigin(origins = "http://localhost:3000/form")
	@GetMapping("/price")
	public float MakePrice() {
		// pulltheprice
		float price = 37;
		return price;
	}

	@CrossOrigin(origins = "http://localhost:3000/form")
	@PostMapping("/result")
	public String getQuotes(@RequestBody Map<String, String> payLoad) {
		if (((String) payLoad.get("Gallons")).equals("") || ((String) payLoad.get("Address")).equals("")
				|| ((String) payLoad.get("Date")).equals("") || ((String) payLoad.get("Price")).equals("")
				|| ((String) payLoad.get("Due")).equals("")) {
			return "fields not filled";
		}
		Quote newQuote = new Quote((String) payLoad.get("Gallons"), (String) payLoad.get("Address"),
				(String) payLoad.get("Date"), (String) payLoad.get("Price"), (String) payLoad.get("Due"));
		return newQuote.toString();
	}

	public Quote myQuote = new Quote();

	public class Quote {

		private Long id;
		private String Gallons;
		private String Address;
		private String Date;
		private String Price;
		private String Due;

		public Quote(String Gallons, String Address, String Date, String Price, String Due) {
			this.Gallons = Gallons;
			this.Address = Address;
			this.Date = Date;
			this.Price = Price;
			this.Due = Due;
		}

		public Quote() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getGallons() {
			return Gallons;
		}

		public void setGallons(String Gallons) {
			this.Gallons = Gallons;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String Address) {
			this.Address = Address;
		}

		public String getDate() {
			return Date;
		}

		public void setDate(String Date) {
			this.Date = Date;
		}

		public String getPrice() {
			return Price;
		}

		public void setPrice(String Price) {
			this.Price = Price;
		}

		public String getDue() {
			return Due;
		}

		public void setDue(String Due) {
			this.Due = Due;
		}

		public String toString() {
			return "Quote{" +
					"id=" + id +
					", Gallons='" + Gallons + '\'' +
					", Address='" + Address + '\'' +
					", Date='" + Date + '\'' +
					", Price='" + Price + '\'' +
					", Due='" + Due + '\'' +
					'}';
		}
	}

}
