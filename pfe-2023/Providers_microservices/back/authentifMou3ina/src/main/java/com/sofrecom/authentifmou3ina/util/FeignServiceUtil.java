package com.sofrecom.authentifmou3ina.util;


import com.sofrecom.authentifmou3ina.dto.Customer;
import com.sofrecom.authentifmou3ina.entities.AvailibilitiesMou3ina;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name ="customer-services", url="http://localhost:8978")
public interface FeignServiceUtil {

/*    @GetMapping("/find") //RequestMapping
    public String hello();

    @GetMapping(value = "/customers")
    public List<Customer> findAllcustomers() ;

    @GetMapping(value = "/customers/{id}")
    public Customer findoneCustomer(@PathVariable Long id);*/


    @PostMapping(value ="/CustomerReservations/insert")
    public void insertProvidersFromOtherMicroservice();

    @PostMapping(value = "/api/test/disponibilite/{id}")
    public AvailibilitiesMou3ina addAvailibilitiesMou3ina(@PathVariable Long id, @RequestBody AvailibilitiesMou3ina m);




}
