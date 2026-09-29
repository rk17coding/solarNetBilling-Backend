package com.solarNetBilling.demo.Model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class DownloadBill {
	
	private String customerID;
	private String customerName;
	private String customerContactDetails;
	private String customerEmailId;
	private String customerAddress;
	private String customerType;
	private double previousReading;
	private double currentReading;
	private double unitConsumed;
	private long billNo;
	private double billAmount;
	private LocalDate billDate;
	private double meterRent;
	private double fixedCharge;
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerContactDetails() {
		return customerContactDetails;
	}
	public void setCustomerContactDetails(String customerContactDetails) {
		this.customerContactDetails = customerContactDetails;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
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
	public LocalDate getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}
	public double getMeterRent() {
		return meterRent;
	}
	public void setMeterRent(double meterRent) {
		this.meterRent = meterRent;
	}
	public double getFixedCharge() {
		return fixedCharge;
	}
	public void setFixedCharge(double fixedCharge) {
		this.fixedCharge = fixedCharge;
	}
	@Override
	public String toString() {
		return "DownloadBill [customerID=" + customerID + ", customerName=" + customerName + ", customerContactDetails="
				+ customerContactDetails + ", customerEmailId=" + customerEmailId + ", customerAddress="
				+ customerAddress + ", customerType=" + customerType + ", previousReading=" + previousReading
				+ ", currentReading=" + currentReading + ", unitConsumed=" + unitConsumed + ", billNo=" + billNo
				+ ", billAmount=" + billAmount + ", billDate=" + billDate + ", meterRent=" + meterRent
				+ ", fixedCharge=" + fixedCharge + "]";
	}
	public DownloadBill(String customerID, String customerName, String customerContactDetails, String customerEmailId,
			String customerAddress, String customerType, double previousReading, double currentReading,
			double unitConsumed, long billNo, double billAmount, LocalDate billDate, double meterRent,
			double fixedCharge) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerContactDetails = customerContactDetails;
		this.customerEmailId = customerEmailId;
		this.customerAddress = customerAddress;
		this.customerType = customerType;
		this.previousReading = previousReading;
		this.currentReading = currentReading;
		this.unitConsumed = unitConsumed;
		this.billNo = billNo;
		this.billAmount = billAmount;
		this.billDate = billDate;
		this.meterRent = meterRent;
		this.fixedCharge = fixedCharge;
	}
	public DownloadBill() {}

}