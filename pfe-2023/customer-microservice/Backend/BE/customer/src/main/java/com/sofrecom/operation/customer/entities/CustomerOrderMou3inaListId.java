package com.sofrecom.operation.customer.entities;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;


public class CustomerOrderMou3inaListId implements Serializable {


    private static final long serialVersionUID = 1L;
    @Column(name = "primaryKey.customerReservation")
    private long customerReservation;
    @Column(name = "primaryKey.mou3ina")
    private long mou3ina;



    @ManyToOne()
    public long getMou3ina() {
        return mou3ina;
    }

    public void setMou3ina(long mou3ina) {
        this.mou3ina = mou3ina;
    }


    @ManyToOne()
    public long getCustomerReservation() {
        return customerReservation;
    }

    public void setCustomerReservation(long customerReservation) {
        this.customerReservation = customerReservation;
    }
    @Override
    public int hashCode() {
        return Objects.hash(customerReservation, mou3ina);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomerOrderMou3inaListId other = (CustomerOrderMou3inaListId) obj;
        return Objects.equals(customerReservation, other.customerReservation) && Objects.equals(mou3ina, other.mou3ina);
    }

    public CustomerOrderMou3inaListId() {

    }

    public CustomerOrderMou3inaListId( long customerReservation,long mou3ina) {

        this.customerReservation= customerReservation;
        this.mou3ina = mou3ina;
    }



}