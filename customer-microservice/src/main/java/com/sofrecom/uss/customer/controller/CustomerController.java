package com.sofrecom.uss.customer.controller;

import com.sofrecom.uss.customer.entities.Customer;
import com.sofrecom.uss.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;



    @PostMapping("/add")
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.saveNew(customer));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>>  findAllCustomers() {
        return  ResponseEntity.ok(customerService.findAllCustomers()) ;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(customerService.findCustomerById(id))  ;
    }


    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Customer  customer){
        customerService.updateCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/delete")
    public ResponseEntity  delete(@RequestBody  Customer  customer) {
        customerService.deleteCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }




}
