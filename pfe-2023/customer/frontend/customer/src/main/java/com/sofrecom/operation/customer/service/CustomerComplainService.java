package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.entities.CustomerComplain;


public interface CustomerComplainService {
	
		

	public CustomerComplain addCustomerComplain(CustomerComplain m);

	public void deleteCustomerComplain(Long id);

	public CustomerComplain updateCustomerComplain(CustomerComplain p);

	public CustomerComplain findCustomerComplain(Long id);
	public List<CustomerComplain> findAll();

}
