package com.sofrecom.operation.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class ServiceType {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long idService;
	  @Column(name = "label_fr")
		private String label_fr ;
	 @Column(name = "label_ar")
		private String label_ar ;
 @Column(name = "code",nullable = false)
	private Long code ;
 @Column(name = "label",nullable = false)
	private String label ;
public ServiceType(Long idService, String label_fr, String label_ar, Long code, String label) {
	super();
	this.idService = idService;
	this.label_fr = label_fr;
	this.label_ar = label_ar;
	this.code = code;
	this.label = label;
}
public ServiceType() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getIdService() {
	return idService;
}
public void setIdService(Long idService) {
	this.idService = idService;
}
public String getLabel_fr() {
	return label_fr;
}
public void setLabel_fr(String label_fr) {
	this.label_fr = label_fr;
}
public String getLabel_ar() {
	return label_ar;
}
public void setLabel_ar(String label_ar) {
	this.label_ar = label_ar;
}
public Long getCode() {
	return code;
}
public void setCode(Long code) {
	this.code = code;
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
	
	
	}