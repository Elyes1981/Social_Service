package com.sofrecom.operation.customer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class SousTypes {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsous;
	
	private String label;
	
	private String label_fr;

	private String label_ar;
	
}
