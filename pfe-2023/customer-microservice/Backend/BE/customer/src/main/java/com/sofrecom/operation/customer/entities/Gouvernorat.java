package com.sofrecom.operation.customer.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Gouvernorat implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idgouv;
	private String name;
	private String name_ar;
	
	@OneToMany()
	private Collection<Delegation> delegations;

	public Gouvernorat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gouvernorat(Long idgouv, String name, String name_ar, Collection<Delegation> delegations) {
		super();
		this.idgouv = idgouv;
		this.name = name;
		this.name_ar = name_ar;
		this.delegations = delegations;
	}

	public Long getIdgouv() {
		return idgouv;
	}

	public void setIdgouv(Long idgouv) {
		this.idgouv = idgouv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_ar() {
		return name_ar;
	}

	public void setName_ar(String name_ar) {
		this.name_ar = name_ar;
	}

	public Collection<Delegation> getDelegations() {
		return delegations;
	}

	public void setDelegations(Collection<Delegation> delegations) {
		this.delegations = delegations;
	}

	
	
	

}
