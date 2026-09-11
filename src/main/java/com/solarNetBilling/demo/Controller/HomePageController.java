package com.solarNetBilling.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController{
	
	@RequestMapping("/homePage")
	public String greeting() {
		return "Welcome to the Home page :-)";
	}
	
}
