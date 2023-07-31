package com.sofrecom.uss.customer.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    DiscoveryClient  discoveryClient  ;


    @GetMapping("/services")
    public ResponseEntity<?> services() {
        return new ResponseEntity<Object>(discoveryClient.getServices(),HttpStatus.OK) ;
    }

    @GetMapping("/check")
    public ResponseEntity<?> check(){
        return new ResponseEntity<Object>(discoveryClient.getInstances("operation"),HttpStatus.OK) ;
    }



}
