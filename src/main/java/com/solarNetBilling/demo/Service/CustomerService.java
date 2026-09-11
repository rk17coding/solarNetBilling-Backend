package com.solarNetBilling.demo.Service;


import com.solarNetBilling.demo.Model.Customer;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class CustomerService{
	
	List<Customer> customers =Arrays.asList(
			                         new Customer("Rahul Kumar",72485,"9002862012","Domestic","7 Rasik Lal Banerjee"),
			                         new Customer("Subham Rai",72345,"9002845622","Domestic","7 Rasik Lal Banerjee"),
			                         new Customer("Chandan Ojha",74645,"9007456622","Domestic","7 Rasik Lal Banerjee")); 
	
	public List<Customer> getCustomers(){
		return customers;
	}
	
}