package com.sofrecom.uss.customer.client;

import com.sofrecom.uss.customer.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "operation")
public interface OperationClient {

    @PostMapping("/customer/add")
    Customer addNewCustomer(Customer customer) ;
}
