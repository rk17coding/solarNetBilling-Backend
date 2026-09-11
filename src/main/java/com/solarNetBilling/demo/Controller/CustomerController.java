package com.solarNetBilling.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solarNetBilling.demo.Model.Customer;
import com.solarNetBilling.demo.Service.CustomerService;

@RestController
public class CustomerController{
	
	@Autowired
	CustomerService service;
	
	@RequestMapping("/customers")
	public List<Customer> getCustomer() {
		return service.getCustomers();
	}
}