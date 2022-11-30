package com.sofrecom.uss.operation.controller;

import com.sofrecom.uss.operation.entities.CustomerForOperation;
import com.sofrecom.uss.operation.service.CustomerForOperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerForOperationController {


    @Autowired
    private CustomerForOperationService  customerForOperationService ;


    @PostMapping("/add")
    public ResponseEntity<CustomerForOperation> addNewCustomer(@RequestBody CustomerForOperation customer){
        return ResponseEntity.ok(customerForOperationService.save(customer));
    }
}
