package com.bce.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bce.dto.Employee;
import com.bce.exception.EmployeeExceptionController;
import com.bce.service.EmployeeAddressService;
import com.bce.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeAddressService employeeAddressService;
	
	@GetMapping("/all")
	public List<Employee> getEmpList(){
		return employeeService.empList();
	}
	
	@GetMapping("/allreactive")
	public Flux<Employee> getEmpListReactive(){
		return employeeService.empListReactive();
	}
	
	
	@GetMapping("/findbyid/{empId}")
	// @ExceptionHandler({ EmployeeExceptionController.class })
	public Employee getEmpwithAddress(@PathVariable("empId") String empId){
		return employeeAddressService.getEmployeeWithAddress(empId);
	}
	
	
	@GetMapping("/findbyid/{empId}/threading")
	public Employee getEmpwithAddressMultithreaded(@PathVariable("empId") String empId){
		return employeeAddressService.getEmployeeWithAddressUsinhThread(empId);
	}
	
	@GetMapping("/findbyid/{empId}/reactive")
	public Mono<Employee> getEmpwithAddressReactive(@PathVariable("empId") String empId){
		return employeeAddressService.getEmployeeWithAddressReactive(empId);
	}
}
