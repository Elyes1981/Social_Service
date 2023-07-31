package com.sofrecom.operation.customer.service;


import java.util.List;

import com.sofrecom.operation.customer.entities.Customer;


public interface CustomerService {
	public Customer addCustomer(Customer m);
	public void deleteCustomer(Long id) ;
	public Customer updateCustomer(Customer p) ;
	public Customer findCustomer(Long id) ;
	public List<Customer> findAll();
	//Filtrage par propriété
	
	public Customer findByFirstName(String firstName);
	public Customer findByLastName(String lastName);
	String forgotPassword(String username);
	String ResetPassword(String token, String password);};
