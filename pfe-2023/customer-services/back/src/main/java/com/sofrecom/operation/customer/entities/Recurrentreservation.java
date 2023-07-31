package com.sofrecom.operation.customer.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@Table(name = "Recurrentreservation")
public class Recurrentreservation  implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long recurrentId;

    @Column(name = "duration")
    private int duration;

    @Column(name = "Morning")
    private boolean Morning;

    @Column(name = "Afternoon")
    private boolean afternoon;

    @Column(name = "Evening")
    private boolean evening;

    @Column(name = "recurrentday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date recurrentday;

    @ManyToOne(cascade=CascadeType.ALL ,fetch=FetchType.EAGER)
    @JoinColumn(name="id",referencedColumnName = "id")
    @JsonIgnore
    private CustomerReservation CustomerReservation;

    public Recurrentreservation(long recurrentId, int duration, boolean morning, boolean afternoon, boolean evening,
                                Date recurrentday, com.sofrecom.operation.customer.entities.CustomerReservation customerReservation) {
        super();
        this.recurrentId = recurrentId;
        this.duration = duration;
        Morning = morning;
        this.afternoon = afternoon;
        this.evening = evening;
        this.recurrentday = recurrentday;
        CustomerReservation = customerReservation;
    }

    public Recurrentreservation() {
        super();
        // TODO Auto-generated constructor stub
    }

    public long getRecurrentId() {
        return recurrentId;
    }

    public void setRecurrentId(long recurrentId) {
        this.recurrentId = recurrentId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isMorning() {
        return Morning;
    }

    public void setMorning(boolean morning) {
        Morning = morning;
    }

    public boolean isAfternoon() {
        return afternoon;
    }

    public void setAfternoon(boolean afternoon) {
        this.afternoon = afternoon;
    }

    public boolean isEvening() {
        return evening;
    }

    public void setEvening(boolean evening) {
        this.evening = evening;
    }

    public Date getRecurrentday() {
        return recurrentday;
    }

    public void setRecurrentday(Date recurrentday) {
        this.recurrentday = recurrentday;
    }

    public CustomerReservation getCustomerReservation() {
        return CustomerReservation;
    }

    public void setCustomerReservation(CustomerReservation customerReservation) {
        CustomerReservation = customerReservation;
    }




}

