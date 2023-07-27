package com.bce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bce.dao.EmployeeDao;
import com.bce.dto.Employee;
import com.bce.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public List<Employee> empList() {
		return employeeDao.getAllEmp();
	}

	@Override
	public Flux<Employee> empListReactive() {
		return employeeDao.getAllEmpReactive();
	}

	@Override
	public Employee getEmployeeById(String empId) {
		return employeeDao.getAllEmp10().stream().filter(emp->emp.getEmpId().equals(empId)).findFirst().get();
	}

	@Override
	public Mono<Employee> getEmployeeReactiveById(String empId) {
		return employeeDao.getAllEmpReactive10().filter(emp->emp.getEmpId().equals(empId)).single();
	}

}
