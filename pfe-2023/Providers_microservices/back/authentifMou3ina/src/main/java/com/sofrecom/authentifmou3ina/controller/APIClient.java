package com.sofrecom.authentifmou3ina.controller;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "microservice-one", url = "http://localhost:8881")

public interface APIClient {

}
