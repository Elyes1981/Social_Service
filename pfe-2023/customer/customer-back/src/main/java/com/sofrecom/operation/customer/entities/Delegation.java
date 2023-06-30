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
public class Delegation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddele;
	private String name;
	private String name_ar;
	private Float gPS_Latitude;
	private Float gPS_Longtitude;
	public Delegation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Delegation(Long iddele, String name, String name_ar, Float gPS_Latitude, Float gPS_Longtitude) {
		super();
		this.iddele = iddele;
		this.name = name;
		this.name_ar = name_ar;
		this.gPS_Latitude = gPS_Latitude;
		this.gPS_Longtitude = gPS_Longtitude;
	}
	public Long getIddele() {
		return iddele;
	}
	public void setIddele(Long iddele) {
		this.iddele = iddele;
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
	public Float getgPS_Latitude() {
		return gPS_Latitude;
	}
	public void setgPS_Latitude(Float gPS_Latitude) {
		this.gPS_Latitude = gPS_Latitude;
	}
	public Float getgPS_Longtitude() {
		return gPS_Longtitude;
	}
	public void setgPS_Longtitude(Float gPS_Longtitude) {
		this.gPS_Longtitude = gPS_Longtitude;
	}
	
	

	
	
}
