package com.sofrecom.operation.customer.util;


import com.sofrecom.operation.customer.dto.CleaningServicesCompanyDTO;
import com.sofrecom.operation.customer.dto.Mou3inaEntityDTO;
import com.sofrecom.operation.customer.entities.Mou3inaEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@FeignClient(value = "providers-services" , url="localhost:8088")
public interface FeignServiceUtil {


    @RequestMapping(value = "/hello" , method = RequestMethod.GET) //RequestMapping
    public  String hello();


    @RequestMapping(value = "/CleaningCompanies" , method = RequestMethod.GET) //RequestMapping
    List<CleaningServicesCompanyDTO> findCleaningServicesCompany();

    @RequestMapping(value = "/Mou3inas" , method = RequestMethod.GET) //RequestMapping
    List<Mou3inaEntityDTO> findMou3iness();

    @RequestMapping(value = "/tet" , method = RequestMethod.GET) //RequestMapping
    String test();

    @GetMapping("/companyPercentage/{providerId}")
    public double getCompanyPercentageByProviderId(@PathVariable Long providerId);

    @PutMapping("/AddOrder/{id}")
    public ResponseEntity<String> incrementServicesDone(@PathVariable Long id);

    @GetMapping(value = "/ListProvidersCompany/{id}")
    public Set<Mou3inaEntity> getMou3inaByCompanyId(@PathVariable("id") Long companyId) ;


    }
