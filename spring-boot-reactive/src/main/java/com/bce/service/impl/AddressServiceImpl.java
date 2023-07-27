package com.bce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bce.dao.AddressDao;
import com.bce.dto.Address;
import com.bce.service.AddressService;

import reactor.core.publisher.Mono;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDao addressDao;
	
	

	@Override
	public Address findByEmp(String empID) {
		return addressDao.getAllAddress().stream().filter(address->address.getEmpId().equals(empID)).findFirst().get();
	}

	@Override
	public Mono<Address> findByEmpReactive(String empID) {
		return  addressDao.getAllAddressReactive().filter(address->address.getEmpId().equals(empID)).take(1).single();
	}

}
