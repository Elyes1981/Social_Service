package com.sofrecom.operation.customer.controller;


import com.sofrecom.operation.customer.entities.Customer;
import com.sofrecom.operation.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@Autowired
	  private JavaMailSender javaMailSender; 
	 /*@Autowired
	  PasswordEncoder encoder;*/
	   public static String generateRandomPassword(int len) {
			String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
	          +"lmnopqrstuvwxyz!@#$%&";
			Random rnd = new Random();
			StringBuilder sb = new StringBuilder(len);
			for (int i = 0; i < len; i++)
				sb.append(chars.charAt(rnd.nextInt(chars.length())));
			return sb.toString();
		}

	@GetMapping(value = "/customers")
	public List<Customer> findAllcustomers() {
		return customerService.findAll();
	}

	@GetMapping(value = "/customers/{id}")
	public Customer findoneCustomer(@PathVariable Long id) {
		return customerService.findCustomer(id);
		
	}

	@PostMapping(value ="/customers")
	public Customer addCustomer(@RequestBody Customer m) {
	//	String pass =  generateRandomPassword(8);
		//encoder.encode(pass);
	//	m.setPassword(pass);
		
	//	SimpleMailMessage msg = new SimpleMailMessage();
	    //  msg.setTo(m.getEmailAdress());

	     // msg.setSubject("Username & Password");
	  //    msg.setText("Hello \n"+m.getFirstName()+" "+m.getLastName()+ " \n this is your username : \n "+m.getUsername().toString()+ "\n and your password :\n"+m.getPassword().toString()+"\n you may change them in your first sign in");

	    //  javaMailSender.send(msg);
		return customerService.addCustomer(m);
		
		
	}

	
	@PutMapping(value ="/customers/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer p) {
	p.setId(id);
		return customerService.updateCustomer(p);
		
	}
	

	@DeleteMapping(value = "/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}



}


