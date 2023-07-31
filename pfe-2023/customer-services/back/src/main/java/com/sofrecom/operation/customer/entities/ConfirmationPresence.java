package com.sofrecom.operation.customer.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name="ConfirmationPresence")
public class ConfirmationPresence implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    public long id;






    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "confirmation_presence")
    private String confirmationPresence;







}
