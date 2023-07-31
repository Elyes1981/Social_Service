package com.sofrecom.uss.customer.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id  ;

    @Column
    private String firstName  ;

    @Column
    private String lastName  ;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dob  ;

}
