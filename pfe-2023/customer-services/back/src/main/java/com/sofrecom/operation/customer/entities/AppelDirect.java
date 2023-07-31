package com.sofrecom.operation.customer.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name="AppelDirect")
public class AppelDirect implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    public long id;






    @Column(name = "Provider_id")
    private Long ProviderId;

    @Column(name = "Numero_tel")
    private String NumeroTel;







}
