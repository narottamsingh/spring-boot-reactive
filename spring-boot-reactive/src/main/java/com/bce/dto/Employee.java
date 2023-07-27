package com.bce.dto;

import java.io.Serializable;


public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9165582666988470206L;

	private String empId;
	private String empName;
	
	private Address address;

	
	public Address getAddress() {
		return address;
	}




	public void setAddress(Address address) {
		this.address = address;
	}




	public String getEmpId() {
		return empId;
	}




	public void setEmpId(String empId) {
		this.empId = empId;
	}




	public String getEmpName() {
		return empName;
	}




	public void setEmpName(String empName) {
		this.empName = empName;
	}




	public Employee(String empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

}
