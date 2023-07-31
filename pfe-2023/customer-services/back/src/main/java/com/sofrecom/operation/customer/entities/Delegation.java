package com.sofrecom.operation.customer.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Delegation implements Serializable {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDeleg ;
	@Column(name = "name",nullable = false)
	private String name ;
	@Column(name = "name_ar")
	private String name_ar ;
	private Float gPS_Latitude ;
	private Float gPS_Longtitude ;
	public Delegation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Delegation(Long idDeleg, String name, Float gPS_Latitude, Float gPS_Longtitude) {
		super();
		this.idDeleg = idDeleg;
		this.name = name;
		this.gPS_Latitude = gPS_Latitude;
		this.gPS_Longtitude = gPS_Longtitude;
	}
	public Long getIdDeleg() {
		return idDeleg;
	}
	public void setIdDeleg(Long idDeleg) {
		this.idDeleg = idDeleg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getName_ar() {
		return name_ar;
	}
	public void setName_ar(String name_ar) {
		this.name_ar = name_ar;
	}




}
