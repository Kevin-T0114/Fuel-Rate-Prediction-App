package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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
		//pulltheprice
		float price = 37;
		return price;
	}

}
