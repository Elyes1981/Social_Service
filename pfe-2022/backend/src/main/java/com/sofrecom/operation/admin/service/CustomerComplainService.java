package com.sofrecom.operation.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sofrecom.operation.admin.entities.CustomerComplain;


public interface CustomerComplainService {
	
		

	public CustomerComplain addCustomerComplain(CustomerComplain m);

	public void deleteCustomerComplain(Long id);

	public CustomerComplain updateCustomerComplain(CustomerComplain p);

	public CustomerComplain findCustomerComplain(Long id);
	public List<CustomerComplain> findAll();

}
