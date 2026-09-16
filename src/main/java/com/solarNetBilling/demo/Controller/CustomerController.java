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
import com.solarNetBilling.demo.Service.CustomerService;

@RestController
public class CustomerController{
	
	@Autowired
	CustomerService service;
	
	@GetMapping("/customers")
	public List<Customer> getCustomer() {
		return service.getCustomers();
	}
	
	@GetMapping("/customerBill/{custId}")
	public double getCustomerBillById(@PathVariable int custId) {
		return service.getCustomerBillById(custId);
	}
	
	@GetMapping("/customers/{custId}")
	public Customer getCustomerById(@PathVariable int custId) {
		return service.getCustomerById(custId);
	}
	
	@PostMapping("/customers")
	public void addCustomer(@RequestBody Customer customer) {
		service.addCustomer(customer);
	}
	
	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer customer) {
		service.updateCustomer(customer);
	}
	
	@DeleteMapping("/customers/{custId}")
	public void deleteCustomerById(@PathVariable int custId) {
		service.deleteCustomer(custId);
	}
	
}