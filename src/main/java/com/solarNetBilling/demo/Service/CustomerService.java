package com.solarNetBilling.demo.Service;


import com.solarNetBilling.demo.Model.Customer;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;


@Service
public class CustomerService{
	
	List<Customer> customers =new ArrayList<>(Arrays.asList(
			                         new Customer("Rahul Kumar",72485,"9002862012","Domestic","7 Rasik Lal Banerjee"),
			                         new Customer("Subham Rai",72345,"9002845622","Domestic","7 Rasik Lal Banerjee"),
			                         new Customer("Chandan Ojha",74645,"9007456622","Domestic","7 Rasik Lal Banerjee"))); 
	
	public List<Customer> getCustomers(){
		return customers;
	}
    
	//Normal for loop is also applicable
	
	public Customer getCustomerById(int custId) {
		
		return customers.stream()
				        .filter(c->c.getCustomerID() == custId)
				        .findFirst()
				        .get();
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
		
	}

	public void updateCustomer(Customer customer) {
		int index = 0;
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getCustomerID() == customer.getCustomerID()) {
				index = i;
				System.out.println("updated");
			}
		}
		customers.set(index,customer);
		
	}

	public void deleteCustomer(int custId) {
		int index = 0;
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getCustomerID() == custId) {
				index = i;
				System.out.println("updated");
			}
		}
		
		
		customers.remove(index);
	}
	
}