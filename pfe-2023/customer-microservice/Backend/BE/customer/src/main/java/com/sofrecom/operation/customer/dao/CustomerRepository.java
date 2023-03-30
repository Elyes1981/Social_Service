package com.sofrecom.operation.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sofrecom.operation.customer.entities.Customer;


import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	
	Customer findByFirstName(String firstName);
	
	Customer findByLastName(String lastName);
	
	@Modifying
	@Query("update Customer m set m.photo =:logoPath where m.id =:idcustomer")
	public void updateLogoPath(long idcustomer, String logoPath);

	
	Customer findByUsername(String username);
	Optional<Customer> findByEmailAdress(String emailAdress);
	boolean existsByUsername(String username);
	boolean existsByEmailAdress(String emailAdress);
	public Customer findByResetPasswordToken(String token);
	
	
	
	
	

}
