package com.PricingModule;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/form")
public class PricingModuleController {

    private final PricingModuleService pricingModuleService;

    private String user = "";

    @Autowired
    public PricingModuleController(PricingModuleService pricingModuleService) {
        this.pricingModuleService = pricingModuleService;
    }

    //i think this is good
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/location")
    public String getLocation() {
        String location = pricingModuleService.getState(user);
        return location;
    }

    //i think this is good
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/price")
    public float makePrice() {
        String location = getLocation();
        if (location =="TX") {
			//do the tx calc 
		} else {
			//do the other calc
		}
        float price = 37;
        return price;
    }

    //i think this is good
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user")
    public String getUser(@RequestBody Map<String,String> payLoad) {

        this.user = (String) payLoad.get("User");
        return ((String) payLoad.get("User"));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/result")
    public String getQuotes(@RequestBody Map<String, String> payLoad) {
        
        if (((String) payLoad.get("Gallons")).equals("") || ((String) payLoad.get("Address")).equals("")
				|| ((String) payLoad.get("Date")).equals("") || ((String) payLoad.get("Price")).equals("")
				|| ((String) payLoad.get("Due")).equals("")) {
			return "fields not filled";
		}
        
        PricingModule pricingModule = new PricingModule((String) payLoad.get("Gallons"), (String) payLoad.get("Address"),
        (String) payLoad.get("Date"), (String) payLoad.get("Price"), (String) payLoad.get("Due"));
        user = (String) payLoad.get("User");
        Long id = pricingModuleService.getUser(user);
        pricingModule.setId(id);

        return pricingModuleService.addQuote(pricingModule);
    }

}
