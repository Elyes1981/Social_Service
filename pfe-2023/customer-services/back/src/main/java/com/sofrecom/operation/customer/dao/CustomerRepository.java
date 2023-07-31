package com.sofrecom.operation.customer.dao;

import com.sofrecom.operation.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	
	Customer findByFirstName(String firstName);
	
	Customer findByLastName(String lastName);
	
	@Modifying
	@Query("update Customer m set m.photo =:logoPath where m.id =:idcustomer")
	public void updateLogoPath(long idcustomer, String logoPath);

	@Query("SELECT u FROM Customer u WHERE u.delegation.idDeleg =:e")
	List<Customer> findByDeligation(long e);
	
	Customer findByUsername(String username);
	Optional<Customer> findByEmailAdress(String emailAdress);
	boolean existsByUsername(String username);
	boolean existsByEmailAdress(String emailAdress);
	public Customer findByResetPasswordToken(String token);
	
	
	
	
	

}
