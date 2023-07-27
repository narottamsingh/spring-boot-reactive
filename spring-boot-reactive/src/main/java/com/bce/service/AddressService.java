package com.bce.service;

import com.bce.dto.Address;

import reactor.core.publisher.Mono;

public interface AddressService {

	public Address findByEmp(String empId);
	public Mono<Address> findByEmpReactive(String empId);
}
