package com.solarNetBilling.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.solarNetBilling.demo.Model.Customer;
import com.solarNetBilling.demo.Service.CustomerServiceImpl;

@RestController
public class CustomerController{
	
	@Autowired
	CustomerServiceImpl service;
	
	@GetMapping("/customers")
	public List<Customer> getCustomer() {
		return service.getAllCustomers();
	}
	
//	@GetMapping("/customerBill/{custId}")
//	public Customer getCustomerBillById(@PathVariable String custId) {
//		return service.getCustomerById(custId);
//	}
	
	@GetMapping("/customers/{custId}")
	public Customer getCustomerById(@PathVariable String custId) {
		return service.getCustomerById(custId);
	}
	
	@PostMapping("/customers")
	public void addCustomer(@RequestBody Customer customer) {
		service.createCustomer(customer);
	}
	
	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer customer) {
		String result = service.updateCustomer(customer);
		System.out.println("Inside customerontroller updateCustomer:result:" + result);
	}
	
	@DeleteMapping("/customers/{custId}")
	public void deleteCustomerById(@PathVariable long custId) {
		System.out.println("Inside customer controller:"+custId);
		String result = service.deleteCustomer(custId);
		System.out.println("Inside customer controller:result:" + result);
	}
	
}