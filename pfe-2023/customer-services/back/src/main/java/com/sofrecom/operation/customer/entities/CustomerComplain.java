package com.sofrecom.operation.customer.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class CustomerComplain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
    @Column(name = "complainDate")
    private Timestamp complainDate;
	
	@Column(name = "autre" )
    private String autre;
	
	@ManyToOne
	@JoinColumn(name="customer")
	private Customer customer;

	@ManyToOne
	private SousTypes sousTypes;
	@ManyToOne
	
	private ComplainType complainType;
	public CustomerComplain(Long id, Timestamp complainDate, String autre, Customer customer, SousTypes sousTypes,
			ComplainType complainType) {
		super();
		this.id = id;
		this.complainDate = complainDate;
		this.autre = autre;
		this.customer = customer;
		this.sousTypes = sousTypes;
		this.complainType = complainType;
	}
	public CustomerComplain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getComplainDate() {
		return complainDate;
	}
	public void setComplainDate(Timestamp complainDate) {
		this.complainDate = complainDate;
	}
	public String getAutre() {
		return autre;
	}
	public void setAutre(String autre) {
		this.autre = autre;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public SousTypes getSousTypes() {
		return sousTypes;
	}
	public void setSousTypes(SousTypes sousTypes) {
		this.sousTypes = sousTypes;
	}
	public ComplainType getComplainType() {
		return complainType;
	}
	public void setComplainType(ComplainType complainType) {
		this.complainType = complainType;
	}
	
	
}
