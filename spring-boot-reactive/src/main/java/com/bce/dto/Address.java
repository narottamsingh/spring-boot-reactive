package com.bce.dto;

public class Address {

	private String empId;
	private String addressId;
	private String address;

	
	
	
	public Address(String empId, String addressId, String address) {
		super();
		this.empId = empId;
		this.addressId = addressId;
		this.address = address;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
