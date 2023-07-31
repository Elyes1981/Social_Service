package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.dao.CustomerComplainRepository;
import com.sofrecom.operation.customer.entities.CustomerComplain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
