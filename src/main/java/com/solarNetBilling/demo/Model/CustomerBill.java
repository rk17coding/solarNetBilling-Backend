package com.solarNetBilling.demo.Model;

import org.springframework.stereotype.Component;


//@Component is a generic Spring stereotype annotation that marks a class as a Spring-managed bean, meaning
//Spring will auto-detect and register it in the application context during component scanning.

@Component
public class CustomerBill{
	private long customerID;
	private String customerType;
	private double previousReading;
	private double currentReading;
	private double unitConsumed;
	private long billNo;
	private double billAmount;
	
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
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
	public double getUnitConsumed() {
		return unitConsumed;
	}
	public void setUnitConsumed(double unitConsumed) {
		this.unitConsumed = unitConsumed;
	}
	public long getBillNo() {
		return billNo;
	}
	public void setBillNo(long billNo) {
		this.billNo = billNo;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public CustomerBill(long customerID, String customerType, double previousReading, double currentReading,
			double unitConsumed, long billNo, double billAmount) {
		super();
		this.customerID = customerID;
		this.customerType = customerType;
		this.previousReading = previousReading;
		this.currentReading = currentReading;
		this.unitConsumed = unitConsumed;
		this.billNo = billNo;
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "CustomerBill [customerID=" + customerID + ", customerType=" + customerType + ", previousReading="
				+ previousReading + ", currentReading=" + currentReading + ", unitConsumed=" + unitConsumed
				+ ", billNo=" + billNo + ", billAmount=" + billAmount + "]";
	}
	public CustomerBill() {}
		
}