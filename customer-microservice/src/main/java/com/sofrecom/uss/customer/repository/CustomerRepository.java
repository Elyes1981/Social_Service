package com.sofrecom.uss.customer.repository;

import com.sofrecom.uss.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer , Long> {
}
