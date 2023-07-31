package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.entities.CustomerOrderMou3inaList;
import com.sofrecom.operation.customer.entities.CustomerReservation;

import java.util.Date;
import java.util.List;

public interface ICustomerOrderMou3inaListService {

    public CustomerOrderMou3inaList add(CustomerOrderMou3inaList m);

    public Double calculateTotalServiceCostByCustomerReservation(CustomerReservation customerReservation);

    public List<CustomerOrderMou3inaList> getsome(Date date);
}