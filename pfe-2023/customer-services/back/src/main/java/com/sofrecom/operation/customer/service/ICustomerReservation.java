package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.dto.Mou3inaEntityDTO;
import com.sofrecom.operation.customer.entities.CustomerReservation;
import com.sofrecom.operation.customer.entities.Mou3inaEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;


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

    public List<Mou3inaEntityDTO> getProviders();

    public List<Mou3inaEntity> findAvailableProviders(CustomerReservation reservation);

    public CustomerReservation ConfirmReservation(Long id);

    public List<Object[]> findReservationYear(long year) ;
        public void CancelReservation(Long id) ;
    public Long countRatNeutre(Long year) ;

    public Double Revenu() ;

    public Map<Object, Long> findreservationsCustomerYear(Long id, Integer year) ;

    public List<Integer> findStatusReservations(long idcustomer) ;


        public List<CustomerReservation> search(String month, Integer year, Long idcustomer) ;


        public List<Integer> findStatusReservationsByTime(Long idcustomer) ;

        public Long countRatBonne(Long year) ;

        public void SubmitReservation(Long id);

    public List<Mou3inaEntity> filter(Long id ,CustomerReservation reservation );




}
