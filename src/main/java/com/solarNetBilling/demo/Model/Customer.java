package com.solarNetBilling.demo.Model;

import org.springframework.stereotype.Component;

@Component
public class Customer{
	
	private String customerID;
	private String customerName;
	private String customerContactDetails;
	private String customerEmailId;
	private String customerType;
	private String customerAddress;
	private double previousReading;
	private double currentReading;
	
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public double getPreviousReading() {
		return previousReading;
	}
	public void setPreviousReading(double previousReading) {
		this.previousReading = previousReading;
	}
	public double getCurrentReading() {
		return currentReading;
	}
	public void setCurrentReading(double currentReading) {
		this.currentReading = currentReading;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
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
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	
	public Customer() {}
	public Customer(String customerID, String customerName, String customerContactDetails, String customerEmailId,
		String customerType, String customerAddress, double previousReading, double currentReading) {
	super();
	this.customerID = customerID;
	this.customerName = customerName;
	this.customerContactDetails = customerContactDetails;
	this.customerEmailId = customerEmailId;
	this.customerType = customerType;
	this.customerAddress = customerAddress;
	this.previousReading = previousReading;
	this.currentReading = currentReading;
}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerContactDetails="
				+ customerContactDetails + ", customerEmailId=" + customerEmailId + ", customerType=" + customerType
				+ ", customerAddress=" + customerAddress + ", previousReading=" + previousReading + ", currentReading="
				+ currentReading + "]";
	}


	
}