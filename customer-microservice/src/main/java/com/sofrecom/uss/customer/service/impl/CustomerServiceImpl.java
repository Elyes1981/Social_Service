package com.sofrecom.uss.customer.service.impl;

import com.sofrecom.uss.customer.client.OperationClient;
import com.sofrecom.uss.customer.entities.Customer;
import com.sofrecom.uss.customer.repository.CustomerRepository;
import com.sofrecom.uss.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl  implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository  ;

    @Autowired
    private OperationClient operationClient  ;




    @Override
    @Cacheable(value = "customer", key = "#id")
    public Customer findCustomerById(Long id)  throws ChangeSetPersister.NotFoundException{
        return  customerRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    @Cacheable(value="customer")
    public List<Customer> findAllCustomers() {

            return customerRepository.findAll() ;
    }

    @Override
    @CachePut(value = "customer", key = "#customer.id")
    @Transactional
    public Customer saveNew(Customer customer) {
          customer = customerRepository.save(customer) ;
          operationClient.addNewCustomer(customer);
          return customer ;
        }

    @Override
    @CachePut(value = "customer", key = "#customer.id")
    public Customer updateCustomer(Customer customer) {
        return  customerRepository.save(customer);
    }

    @Override
    @CacheEvict(value = "customer" , key = "#customer.id")
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);

    }
}
