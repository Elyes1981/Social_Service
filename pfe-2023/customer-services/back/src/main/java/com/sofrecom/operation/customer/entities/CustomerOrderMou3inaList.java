package com.sofrecom.operation.customer.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CustomerOrderMou3inaList")
public class CustomerOrderMou3inaList implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "OrderDay")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date OrderDay;


    @Column(name = "serviceCost")
    private Double serviceCost ;

    private int Rank;



    @ManyToOne(fetch = FetchType.EAGER)
    private Mou3inaEntity mou3ina;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private CustomerReservation customerReservation;


public Mou3inaEntity getMou3ina() {
    return mou3ina;
}

    public void setMou3ina(Mou3inaEntity mou3ina) {
        this.mou3ina = mou3ina;
    }

    public CustomerReservation getCustomerReservation() {
        return customerReservation;
    }

    public void setCustomerReservation(CustomerReservation customerReservation) {
        this.customerReservation = customerReservation;
    }

/*    public CustomerOrderMou3inaListId getPrimaryKey(CustomerOrderMou3inaList customerResearchResultMou3inaListId) {
        return primaryKey;
    }

    public void setPrimaryKey(CustomerOrderMou3inaListId primaryKey) {this.primaryKey = primaryKey;}*/
    public Date getOrderDay() {
        return OrderDay;
    }

    public void setOrderDay(Date orderDay) {
        OrderDay = orderDay;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public CustomerOrderMou3inaList(long id, Long mId) {

    }

    public CustomerOrderMou3inaList(Date orderDay, int rank) {
        super();
        OrderDay = orderDay;
        Rank = rank;
    }

    public CustomerOrderMou3inaList(Long id, Date orderDay, int rank, Mou3inaEntity mou3ina, CustomerReservation customerReservation, Double serviceCost) {
        this.id=id;
        OrderDay = orderDay;
        Rank = rank;
        this.mou3ina = mou3ina;
        this.customerReservation = customerReservation;
        this.serviceCost=serviceCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }


    public CustomerOrderMou3inaList() {
    }
}
