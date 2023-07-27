package com.bce.service;

import com.bce.dto.Employee;

import reactor.core.publisher.Mono;

public interface EmployeeAddressService {
	Employee getEmployeeWithAddress(String empId);
	Mono<Employee> getEmployeeWithAddressReactive(String empId);
	Employee getEmployeeWithAddressUsinhThread(String empId);
}
