package com.sofrecom.operation.admin.service;

import com.sofrecom.operation.admin.dao.CustomerReservationRepository;
import com.sofrecom.operation.admin.entities.CustomerReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CustomerReservationservice implements ICustomerReservation {


    @Autowired
    CustomerReservationRepository customerReservationRepository;

    @Override
    public CustomerReservation add(CustomerReservation c) {
        customerReservationRepository.save(c);
        return c;
    }

    @Override
    public void delete(Long id) {
        if(customerReservationRepository.findById(id).isPresent())
            customerReservationRepository.deleteById(id);
    }

    @Override
    public CustomerReservation update(CustomerReservation c) {
        return customerReservationRepository.saveAndFlush(c);
    }

    @Override
    public CustomerReservation find(Long id) {
        return (CustomerReservation) customerReservationRepository.findById(id).get();
        }

    @Override
    public List<CustomerReservation> getsome(Date date) {
        return (List<CustomerReservation>) customerReservationRepository.getsome(date);
    }
    /*
    @Override
    public List<CustomerReservation> getservicetype(String servicetype) {
        return (List<CustomerReservation>) customerReservationRepository.getservicetype(servicetype);
    }
    */

    @Override
    public List<CustomerReservation> getstatus(String status) {
        return (List<CustomerReservation>) customerReservationRepository.getstatus(status);
    }
    @Override
    public List<CustomerReservation> getgrade(int grade) {
        return (List<CustomerReservation>) customerReservationRepository.getgrade(grade);
    }
    @Override
    public List<CustomerReservation> getnumbermo3ina(int nb) {
        return (List<CustomerReservation>) customerReservationRepository.getnumbermo3ina(nb);
    }
    @Override
    public List<CustomerReservation> findAll() {
        return customerReservationRepository.findAll();
    }

}
