//package com.solarNetBilling.demo.Service;
//
//
//import com.solarNetBilling.demo.Model.Customer;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//
//@Service
//public class CustomerService{
//	
//	List<Customer> customers =new ArrayList<>(Arrays.asList(
//			new Customer("7301313326", "Vinod Kumar", "6210594598", "vinodkumar7396@outlook.com", "Domestic", "402, Prince Anwar Shah Road, Jalpaiguri", 2751.66, 2934.12),
//			new Customer("8475904631", "Prakash Joshi", "8257506970", "prakashjoshi6803@gmail.com", "Domestic", "434, Basirhat Road, Durgapur", 2860.29, 2907.14),
//			new Customer("9550184987", "Mamata Mitra", "7988106842", "mamatamitra562@outlook.com", "Domestic", "119, Barasat Trunk Road, Howrah", 1991.38, 2089.92))); 
//	
//	public List<Customer> getCustomers(){
//		return customers;
//	}
//    
//	//Normal for loop is also applicable
//	
//	public Customer getCustomerById(String custId) {
//		
//		return customers.stream()
//				        .filter(c->c.getCustomerID() == custId)
//				        .findFirst()
//				        .get();
//	}
//
//	public void addCustomer(Customer customer) {
//		customers.add(customer);
//		
//	}
//
//	public void updateCustomer(Customer customer) {
//		int index = 0;
//		for(int i=0;i<customers.size();i++) {
//			if(customers.get(i).getCustomerID() == customer.getCustomerID()) {
//				index = i;
//				System.out.println("updated");
//			}
//		}
//		customers.set(index,customer);
//		
//	}
//
//	public void deleteCustomer(String custId) {
//		int index = 0;
//		for(int i=0;i<customers.size();i++) {
//			if(customers.get(i).getCustomerID() == custId) {
//				index = i;
//				System.out.println("Deleted");
//			}
//		}
//		
//		
//		customers.remove(index);
//	}
//	
//	public double getCustomerBillById(String custId) {
//	    // 1. Find the customer once, safely using .equals()
//	    Customer customer = customers.stream()
//	            .filter(c -> c.getCustomerID().equals(custId))
//	            .findFirst()
//	            .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + custId));
//
//	    // 2. Extract the readings and calculate the bill
//	    double prevReading = customer.getPreviousReading();
//	    double currReading = customer.getCurrentReading();
//
//	    return calcBill(prevReading, currReading);
//	}
//
//
//	
//	
//	public static double calcBill(double prevReading, double currReading) {
//		
//		double bill=0;
//		
//		if(currReading>prevReading) {
//			double unitConsumed = currReading - prevReading;
//			double remiender = 0;
//			
//			for(int i=1;i<=7;i++) {
//				
//				if(i==1) {
//					bill = 25*518;
//					remiender = unitConsumed - 25;
//					}
//				if(i==2 && remiender>35) {
//					bill = bill + (remiender*569);
//				}
//				
//			}
//		}
//		else {
//			System.out.println("Error in meter reading");
//			return 0;
//		}
//		
//		System.out.println("bill is "+bill/100);
//		return bill/100;
//		
//	}
//
//	
//}
//
//
//
