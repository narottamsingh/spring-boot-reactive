package com.bce.service;

import java.util.List;

import com.bce.dto.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

	public List<Employee> empList();
	public Flux<Employee> empListReactive();
	
	public Employee getEmployeeById(String empId);
	public Mono<Employee> getEmployeeReactiveById(String empId);
	
}
