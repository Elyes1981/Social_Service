package com.sofrecom.operation.customer.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

//import com.sofrecom.operation.customer.entities.CustomerOrderMou3inaListId;
import org.springframework.format.annotation.DateTimeFormat;

@Entity

@Table(name = "CustomerOrderMou3inaList")

@AssociationOverrides({
@AssociationOverride(name = "primaryKey.customerReservation", joinColumns = @JoinColumn(name = "id")),
@AssociationOverride(name = "primaryKey.mou3ina", joinColumns = @JoinColumn(name = "id")) })

public class CustomerOrderMou3inaList implements Serializable {

    @EmbeddedId
    private com.sofrecom.operation.customer.entities.CustomerOrderMou3inaListId primaryKey =new CustomerOrderMou3inaListId();

    @Column(name = "OrderDay")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date OrderDay;

    private int Rank;


    public CustomerOrderMou3inaList(Date orderDay, int rank) {
        super();
        OrderDay = orderDay;
        Rank = rank;
    }
    @ManyToOne(fetch= FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="primaryKey.mou3ina",insertable = false, updatable = false)
    @MapsId("id")
    private Mou3inaEntity mou3ina;


    @ManyToOne(fetch= FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="primaryKey.customerReservation",insertable = false, updatable = false)
    private CustomerReservation customerReservation;

/*
    public CustomerOrderMou3inaList(CustomerOrderMou3inaListId primaryKey, Date orderDay, int rank) {
        this.primaryKey =  new CustomerOrderMou3inaListId(getCustomerReservation(), getMou3ina());
        OrderDay = orderDay;
        Rank = rank;
    }
*/
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

    public CustomerOrderMou3inaListId getPrimaryKey(CustomerOrderMou3inaList customerResearchResultMou3inaListId) {
        return primaryKey;
    }

    public void setPrimaryKey(CustomerOrderMou3inaListId primaryKey) {this.primaryKey = primaryKey;}
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

    public CustomerOrderMou3inaList(CustomerOrderMou3inaListId primaryKey, Date orderDay, int rank, Mou3inaEntity mou3ina, CustomerReservation customerReservation) {
        this.primaryKey = new CustomerOrderMou3inaListId(customerReservation.getId(), mou3ina.getId());
        OrderDay = orderDay;
        Rank = rank;
        this.mou3ina = mou3ina;
        this.customerReservation = customerReservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrderMou3inaList that = (CustomerOrderMou3inaList) o;
        return Rank == that.Rank && Objects.equals(primaryKey, that.primaryKey) && Objects.equals(OrderDay, that.OrderDay) && Objects.equals(mou3ina, that.mou3ina) && Objects.equals(customerReservation, that.customerReservation);
    }

    public CustomerOrderMou3inaList() {
    }
}
