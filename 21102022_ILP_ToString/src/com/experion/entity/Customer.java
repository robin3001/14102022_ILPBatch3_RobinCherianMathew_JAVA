package com.experion.entity;

public class Customer {

	private String customerCode;
	private String customerNames;
	
	public Customer(String customerCode, String customerNames) {
		super();
		this.customerCode = customerCode;
		this.customerNames = customerNames;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerNames() {
		return customerNames;
	}

	public void setCustomerNames(String customerNames) {
		this.customerNames = customerNames;
	}

	@Override
	public String toString() {
		return "Customer [customerCode=" + customerCode + ", customerNames=" + customerNames + "]";
	}
	
	
	
}
