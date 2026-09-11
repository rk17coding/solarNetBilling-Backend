package com.solarNetBilling.demo.Model;

import org.springframework.stereotype.Component;



@Component
public class Customer{
	
	private String customerName;
	private int customerID;
	private String customerContactDetails;
	private String customerType;
	private String address;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerContactDetails() {
		return customerContactDetails;
	}
	public void setCustomerContactDetails(String customerContactDetails) {
		this.customerContactDetails = customerContactDetails;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer(String customerName, int customerID, String customerContactDetails, String customerType,
			String address) {
		super();
		this.customerName = customerName;
		this.customerID = customerID;
		this.customerContactDetails = customerContactDetails;
		this.customerType = customerType;
		this.address = address;
	}
	public Customer() {}
	
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerID=" + customerID + ", customerContactDetails="
				+ customerContactDetails + ", customerType=" + customerType + ", address=" + address + "]";
	}
	
	
	
	
	
}