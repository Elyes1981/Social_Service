package com.sofrecom.operation.customer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Mou3inaEntity")

public class Mou3inaEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "mou3ina_id", nullable = false)

	public Long id;

	@Column(name = "firstName")

	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;

	@Column(name = "Home_Adress")

	private String Home_Adress;

	private float Home_Adress_GPS_long;

	private float Home_Adress_GPS_latt;

	//private Set<Customer_Mou3ina_Preferences> customer_Mou3ina_Preferences = new HashSet<Customer_Mou3ina_Preferences>();

	

	


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ServiceTypeMou3ina", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "idService") })
	private Collection<ServiceType> serviceType;



}
