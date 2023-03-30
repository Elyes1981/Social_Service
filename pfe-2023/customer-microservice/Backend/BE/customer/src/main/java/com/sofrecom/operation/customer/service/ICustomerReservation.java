package com.sofrecom.operation.customer.service;
import java.util.Date;
import java.util.List;
import com.sofrecom.operation.customer.entities.CustomerReservation;



public interface ICustomerReservation {


    public CustomerReservation add(CustomerReservation m);

    public void delete(Long id);

    public CustomerReservation  update (CustomerReservation m);

    public CustomerReservation  find (Long id);

    public List<CustomerReservation> getsome(Date date);

   // public List<CustomerReservation> getservicetype(String servicetype);

    public List<CustomerReservation> getstatus(String statuscode);

    public List<CustomerReservation> getgrade(int grade);

    public List<CustomerReservation> getnumbermo3ina(int nb);
    public List<CustomerReservation> findAll();

}
