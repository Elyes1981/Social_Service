package com.sofrecom.authentifmou3ina.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
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
	
	private Long idGouvert ;
	@Column(name = "name",nullable = false)  
	private String name ;
	@Column(name = "name_ar")  
	private String name_ar ;
	
	@OneToMany()
	private Collection<Delegation> deligations;


	public Gouvernorat() {
		super();
		
	}
	public Gouvernorat(Long idGouvert, String name, Collection<Delegation> deligations) {
		super();
		this.idGouvert = idGouvert;
		this.name = name;
		this.deligations = deligations;
	}
	public Long getIdGouvert() {
		return idGouvert;
	}
	public void setIdGouvert(Long idGouvert) {
		this.idGouvert = idGouvert;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Collection<Delegation> getDeligations() {
		return deligations;
	}
	public void setDeligations(Collection<Delegation> deligations) {
		this.deligations = deligations;
	}
	public String getName_ar() {
		return name_ar;
	}
	public void setName_ar(String name_ar) {
		this.name_ar = name_ar;
	}


	
}
