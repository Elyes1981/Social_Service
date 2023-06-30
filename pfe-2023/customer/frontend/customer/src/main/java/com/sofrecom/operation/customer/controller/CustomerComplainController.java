package com.sofrecom.operation.customer.controller;


import com.sofrecom.operation.customer.dao.CustomerComplainRepository;
import com.sofrecom.operation.customer.entities.CustomerComplain;
import com.sofrecom.operation.customer.service.CustomerComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerComplainController {
	@Autowired
	CustomerComplainService customerComplainService;
	@Autowired
    CustomerComplainRepository customerComplainRepository;
	@GetMapping(value = "/customercomplains")
	public List<CustomerComplain> findAllCustomerComplain() {
		return customerComplainService.findAll();
	}

    @RequestMapping(value = "/customercomplains/customercomplain/{id}", method = RequestMethod.GET)
	public List<CustomerComplain> fincomplainsByCustomer(@PathVariable Long id) {
		return customerComplainRepository.findByCustomer( id);
	}

	@GetMapping(value = "/customercomplains/{id}")
	public CustomerComplain findoneCustomerComplain(@PathVariable Long id) {
		return customerComplainService.findCustomerComplain(id);
	}
	
	@PostMapping(value ="/customercomplains")
	public CustomerComplain addCustomerComplain(@RequestBody CustomerComplain m) {
		return customerComplainService.addCustomerComplain(m);
	}

	
	@PutMapping(value ="/customercomplains/{id}")
	public CustomerComplain updateCustomerComplain(@PathVariable Long id, @RequestBody CustomerComplain p) {
	p.setId(id);
		return customerComplainService.updateCustomerComplain(p);
		
	}

	@DeleteMapping(value = "/customercomplains/{id}")
	public void deleteCustomerComplain(@PathVariable Long id) {
		customerComplainService.deleteCustomerComplain(id);
	}



}

  
