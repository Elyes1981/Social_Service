package com.sofrecom.uss.operation.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer_for_operation")
public class CustomerForOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id  ;

    @Column(name = "firstName")
    private  String firstName  ;

    @Column(name = "lastName")
    private String lastName  ;


}
