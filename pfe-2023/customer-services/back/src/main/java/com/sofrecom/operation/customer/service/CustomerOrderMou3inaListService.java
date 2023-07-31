package com.sofrecom.operation.customer.service;


import com.sofrecom.operation.customer.dao.CustomerOrderMou3inaListRepository;
import com.sofrecom.operation.customer.entities.CustomerOrderMou3inaList;
import com.sofrecom.operation.customer.entities.CustomerReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerOrderMou3inaListService implements  ICustomerOrderMou3inaListService{

    @Autowired
    CustomerOrderMou3inaListRepository  customerOrderMou3inaListRepository;
    @Override
    public CustomerOrderMou3inaList add(CustomerOrderMou3inaList m) {
        return customerOrderMou3inaListRepository.save(m);
    }

    public Double calculateTotalServiceCostByCustomerReservation(CustomerReservation customerReservation) {
        return customerOrderMou3inaListRepository.calculateTotalServiceCostByCustomerReservation(customerReservation.getId());
    }

    @Override
    public List<CustomerOrderMou3inaList> getsome(Date date) {
        return (List<CustomerOrderMou3inaList>) customerOrderMou3inaListRepository.getsome(date);
    }
}
