package com.sofrecom.operation.customer.controller;


import com.sofrecom.operation.customer.dao.CleaningCompanyRepository;
import com.sofrecom.operation.customer.dao.CustomerOrderMou3inaListRepository;
import com.sofrecom.operation.customer.entities.CustomerOrderMou3inaList;
import com.sofrecom.operation.customer.entities.Mou3inaEntity;
import com.sofrecom.operation.customer.service.CustomerOrderMou3inaListService;
import com.sofrecom.operation.customer.service.ICleaningCompanyServices;
import com.sofrecom.operation.customer.util.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerOrderMou3inaListController {


    @Autowired
    FeignServiceUtil feignServiceUtil;
    @Autowired
    CustomerOrderMou3inaListService customerOrderMou3inaListService;

    @Autowired
    CustomerOrderMou3inaListRepository customerOrderMou3inaListRepository ;

    @Autowired
    CleaningCompanyRepository cleaningCompanyRepository ;

    @Autowired
    ICleaningCompanyServices iCleaningCompanyServices ;

    @PostMapping("/addOrderMou3ina")
    public CustomerOrderMou3inaList addOrderMou3ina(@RequestBody CustomerOrderMou3inaList customerOrderMou3inaList) {
        customerOrderMou3inaListService.add(customerOrderMou3inaList);
        return  customerOrderMou3inaList;


    }

    @GetMapping("/company/{companyId}/orders")
    public List<CustomerOrderMou3inaList> getCompanyOrders(@PathVariable Long companyId) {
        List<CustomerOrderMou3inaList> customerOrderMou3inaLists = new ArrayList<>();
        Set<Mou3inaEntity> providers = feignServiceUtil.getMou3inaByCompanyId(companyId);
        for (Mou3inaEntity provider : providers) {
            List<CustomerOrderMou3inaList> orders = customerOrderMou3inaListRepository.findByMou3ina(provider);
            customerOrderMou3inaLists.addAll(orders);
        }
        return customerOrderMou3inaLists;
    }

    @RequestMapping(value = "/CustomerOrderMou3inaList/date/{one_date}",method = RequestMethod.GET)
    public List<CustomerOrderMou3inaList> findToday(@PathVariable(value = "one_date")  @DateTimeFormat(pattern = "dd-MM-yyyy") Date fromDate) {

        return customerOrderMou3inaListService.getsome(fromDate);
    }

    @RequestMapping(value = "/CustomerOrderMou3inaList/hour/{one_date}",method = RequestMethod.GET)
    public List<CustomerOrderMou3inaList> getHour(@PathVariable(value = "one_date")  @DateTimeFormat(pattern = "HH:mm") Date hour) {

        return customerOrderMou3inaListRepository.getHour(hour);
    }


    @RequestMapping(value = "/CustomerOrderMou3inaList/status/{status}",method = RequestMethod.GET)
    public List<CustomerOrderMou3inaList> getstatus(@PathVariable(value = "status") String status) {

        return customerOrderMou3inaListRepository.getstatus(status);
    }


    @PostMapping(value = "/AddProviderToCompany/{id}")
    public void addMou3inaToCompany(@PathVariable Long id,  @RequestBody Mou3inaEntity mou3ina) {
        iCleaningCompanyServices.addMou3inaToCompany(id, mou3ina);
    }

    @GetMapping(value = "/ListProvidersCompany/{id}")
    public Set<Mou3inaEntity> getMou3inaByCompanyId(@PathVariable("id") Long companyId) {
        return feignServiceUtil.getMou3inaByCompanyId(companyId);
    }


}
