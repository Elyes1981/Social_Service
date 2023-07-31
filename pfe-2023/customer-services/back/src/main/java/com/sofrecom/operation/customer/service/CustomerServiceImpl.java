package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.dao.CustomerRepository;
import com.sofrecom.operation.customer.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service

public class CustomerServiceImpl implements CustomerService {
	@Autowired
    CustomerRepository customerRepository;

	public Customer addCustomer(Customer m) {


		/*ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();


		String processInstanceId_2 =
				runtimeService.startProcessInstanceByKey("Process_0423qz2").getProcessInstanceId();

		m.setProcessInstanceID2(processInstanceId_2);*/
		return customerRepository.save(m);
	}

	public void deleteCustomer(Long id) {
		if (customerRepository.findById(id).isPresent())
			customerRepository.deleteById(id);
	}

	public Customer updateCustomer(Customer p) {
		return customerRepository.saveAndFlush(p);
	}

	public Customer findCustomer(Long id) {
		return customerRepository.findById(id).get();
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}


	

	public Customer findByFirstName(String firstName) {

		return customerRepository.findByFirstName(firstName);
	}

	public Customer findByLastName(String lastName) {

		return customerRepository.findByLastName(lastName);
	}
	 public void updateResetPasswordToken(String token, String username) throws CustomerNotFoundException {
	        Customer user = customerRepository.findByUsername(username);
	        if (user != null) {
	        	user.setResetPasswordToken(token);
	        	customerRepository.save(user);
	        } else {
	            throw new CustomerNotFoundException("Could not find any customer with the username " + username);
	        }
	    }
	 @Override
		public String forgotPassword(String username) {

			Optional<Customer> userOptional = Optional
					.ofNullable(customerRepository.findByUsername(username));

			if (!userOptional.isPresent()) {
				return "Invalid username id.";
			}

			Customer customer = userOptional.get();
			customer.setResetPasswordToken(generateToken());

			customer = customerRepository.save(customer);

			return customer.getResetPasswordToken();
		}


	 @Override
	 public String  ResetPassword(String token,String password) {
	    	Optional<Customer> userOptional = Optional
	    			.ofNullable(customerRepository.findByResetPasswordToken(token));

	    	if (!userOptional.isPresent()) {
	    		return "Invalid token.";
	    	}

	    	Customer customer = userOptional.get();
	    	//BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
	    	//String encodedPassword=passwordEncoder.encode(password);
	    	//customer.setPassword(encodedPassword);
	    	customer.setResetPasswordToken(null);
	    	customerRepository.save(customer);
	    	return "Password updated successfully";


	    }
	 private String generateToken() {
			StringBuilder token = new StringBuilder();

			return token.append(UUID.randomUUID().toString())
					.append(UUID.randomUUID().toString()).toString();
		}
}
