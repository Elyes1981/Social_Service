package com.sofrecom.authentifmou3ina.entities;

import javax.persistence.Entity;
import javax.persistence.*;
@Entity
@Table(name = "roles")
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idRole;
@Enumerated(EnumType.STRING)
@Column(length = 20)
private ERole name;
public Role() {
}
public Role(ERole name) {
this.name = name;
}
public Long getIdRole() {return idRole; }
public void setIdRole(Long id) {
this.idRole = id;
}
public ERole getName() {
return name;
}
public void setName(ERole name) {
this.name = name;
}

    public Role(Long idRole, ERole name) {
        this.idRole = idRole;
        this.name = name;
    }
}
