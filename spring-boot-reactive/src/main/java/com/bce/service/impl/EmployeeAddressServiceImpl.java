package com.bce.service.impl;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bce.dto.Address;
import com.bce.dto.Employee;
import com.bce.service.AddressService;
import com.bce.service.EmployeeAddressService;
import com.bce.service.EmployeeService;

import reactor.core.publisher.Mono;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	AddressService addressService;

	@Override
	public Employee getEmployeeWithAddress(String empId) {
		// here we have IO blocking - will merge response one after one
		Employee employee = employeeService.getEmployeeById(empId);
		Address address = addressService.findByEmp(empId);
		employee.setAddress(address);
		return employee;
	}

	@Override
	public Employee getEmployeeWithAddressUsinhThread(String empId) {
		// both call parallel
		CompletableFuture<Employee> emFuture = CompletableFuture
				.supplyAsync(() -> employeeService.getEmployeeById(empId));
		CompletableFuture<Address> addressFuture = CompletableFuture.supplyAsync(() -> addressService.findByEmp(empId));

		CompletableFuture<Void> bothFutureMerge = CompletableFuture.allOf(emFuture, addressFuture);
		// waiting for join the response
		bothFutureMerge.join();
		Employee emp = emFuture.join();
		Address address = addressFuture.join();
		emp.setAddress(address);
		return emp;
	}

	@Override
	public Mono<Employee> getEmployeeWithAddressReactive(String empId) {
		
		//return employeeService.getEmployeeReactiveById(empId).concatWith(address->addressService.findByEmpReactive(empId));
		
		
		return employeeService.getEmployeeReactiveById(empId).zipWith(addressService.findByEmpReactive(empId))
				.map(tuple->{
					Employee emp=tuple.getT1();
					emp.setAddress(tuple.getT2());
					return emp;
				});
	}

}
