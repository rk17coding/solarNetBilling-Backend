package com.solarNetBilling.demo.Model;

import org.springframework.stereotype.Component;



@Component
public class Customer{
	
	private String customerName;
	private int customerID;
	private String customerContactDetails;
	private String customerType;
	private String address;
	private int previousReading;
	private int currentReading;
	
	
	
	
	
	public int getPreviousReading() {
		return previousReading;
	}
	public void setPreviousReading(int previousReading) {
		this.previousReading = previousReading;
	}
	public int getCurrentReading() {
		return currentReading;
	}
	public void setCurrentReading(int currentReading) {
		this.currentReading = currentReading;
	}
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
			String address, int previousReading, int currentReading) {
		super();
		this.customerName = customerName;
		this.customerID = customerID;
		this.customerContactDetails = customerContactDetails;
		this.customerType = customerType;
		this.address = address;
		this.previousReading = previousReading;
		this.currentReading = currentReading;
	}
	public Customer() {}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerID=" + customerID + ", customerContactDetails="
				+ customerContactDetails + ", customerType=" + customerType + ", address=" + address
				+ ", previousReading=" + previousReading + ", currentReading=" + currentReading + "]";
	}
	
}