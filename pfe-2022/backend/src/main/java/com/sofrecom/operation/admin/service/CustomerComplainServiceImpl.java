package com.sofrecom.operation.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.operation.admin.dao.CustomerComplainRepository;
import com.sofrecom.operation.admin.entities.CustomerComplain;



@Service
public class CustomerComplainServiceImpl implements CustomerComplainService {
	@Autowired
	
	CustomerComplainRepository customerComplainRepository;

	public CustomerComplain addCustomerComplain(CustomerComplain m) {
		return customerComplainRepository.save(m);
	}

	public void deleteCustomerComplain(Long id) {
		if (customerComplainRepository.findById(id).isPresent())
			customerComplainRepository.deleteById(id);
	}

	public CustomerComplain updateCustomerComplain(CustomerComplain p) {
		return customerComplainRepository.saveAndFlush(p);
	}
	
	public CustomerComplain findCustomerComplain(Long id) {
		return customerComplainRepository.findById(id).get();
	}

	public List<CustomerComplain> findAll() {
		return customerComplainRepository.findAll();
	}

	
	
	
	
	
}
