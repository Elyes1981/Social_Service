package com.sofrecom.operation.customer.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Distance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double distance;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Mou3inaEntity provider;


    @ManyToOne
    @JoinColumn(name = "customer_reservation_id")
    private CustomerReservation customerReservation;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerReservation getCustomerReservation() {
        return customerReservation;
    }

    public void setCustomerReservation(CustomerReservation customerReservation) {
        this.customerReservation = customerReservation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Mou3inaEntity getProvider() {
        return provider;
    }

    public void setProvider(Mou3inaEntity provider) {
        this.provider = provider;
    }


    public Distance(Long id, Double distance, Mou3inaEntity provider, CustomerReservation customerReservation, Customer customer) {
        this.id = id;
        this.distance = distance;
        this.provider = provider;
        this.customerReservation = customerReservation;
        this.customer = customer;
    }

    public Distance(){
        super();
    }

}
