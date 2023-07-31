package com.sofrecom.operation.admin.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "StatusReservation")

public class StatusReservation implements Serializable {

    @Id
    private long  code;

    @Column(name = "status_en", length = 30, nullable = false)
    private String status_en;

    @Column(name = "status_ar", length = 128, nullable = false)
    private String status_ar;

    @Column(name = "status_fr", length = 128, nullable = false)
    private String status_fr;

    @OneToMany(mappedBy="statuscode", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<CustomerReservation> customerReservation;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getStatus_en() {
        return status_en;
    }

    public void setStatus_en(String status_en) {
        this.status_en = status_en;
    }

    public String getStatus_ar() {
        return status_ar;
    }

    public void setStatus_ar(String status_ar) {
        this.status_ar = status_ar;
    }

    public String getStatus_fr() {
        return status_fr;
    }

    public void setStatus_fr(String status_fr) {
        this.status_fr = status_fr;
    }

    public Set<CustomerReservation> getCustomerReservation() {
        return customerReservation;
    }

    public void setCustomerReservation(Set<CustomerReservation> customerReservation) {
        this.customerReservation = customerReservation;
    }

    public StatusReservation() {
    }

    public StatusReservation(long code, String status_en, String status_ar, String status_fr, Set<CustomerReservation> customerReservation) {
        this.code = code;
        this.status_en = status_en;
        this.status_ar = status_ar;
        this.status_fr = status_fr;
        this.customerReservation = customerReservation;
    }
}
