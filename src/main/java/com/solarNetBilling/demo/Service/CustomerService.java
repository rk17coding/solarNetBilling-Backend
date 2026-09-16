package com.solarNetBilling.demo.Service;


import com.solarNetBilling.demo.Model.Customer;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;


@Service
public class CustomerService{
	
	List<Customer> customers =new ArrayList<>(Arrays.asList(
			                         new Customer("Rahul Kumar",72485,"9002862012","Domestic","7 Rasik Lal Banerjee",456,500),
			                         new Customer("Subham Rai",72345,"9002845622","Domestic","7 Rasik Lal Banerjee",342,450),
			                         new Customer("Chandan Ojha",74645,"9007456622","Domestic","7 Rasik Lal Banerjee",245,650))); 
	
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
	
	public double getCustomerBillById(int custId) {
		
		 int prevReading = customers.stream()
				        .filter(c->c.getCustomerID() == custId)
				        .findFirst()
				        .get().getPreviousReading();
		 
		 int currReading = customers.stream()
			        .filter(c->c.getCustomerID() == custId)
			        .findFirst()
			        .get().getCurrentReading();
		 
		 return calcBill(prevReading, currReading) ;
	
	}

	
	
	public static double calcBill(int prevReading, int currReading) {
		
		double bill=0;
		
		if(currReading>prevReading) {
			int unitConsumed = currReading - prevReading;
			int remiender = 0;
			
			for(int i=1;i<=7;i++) {
				
				if(i==1) {
					bill = 25*518;
					remiender = unitConsumed - 25;
					}
				if(i==2 && remiender>35) {
					bill = bill + (remiender*569);
				}
				
			}
		}
		else {
			System.out.println("Error in meter reading");
			return 0;
		}
		
		System.out.println("bill is "+bill/100);
		return bill/100;
		
	}
	
}



