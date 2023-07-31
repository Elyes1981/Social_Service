package com.sofrecom.authentifmou3ina.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class LangageSpeaking implements Serializable  {
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Long idLangageSpeaking ;
 @Column(name = "code",nullable = false)   
	private String code ;
 @Column(name = "label",nullable = false) 
	private String label ;
 @Column(name = "label_fr") 
	private String label_fr ;
   @Column(name = "label_ar") 
  	private String label_ar ;

	public LangageSpeaking(Long idLangageSpeaking, String code, String label) {
		super();
		this.idLangageSpeaking = idLangageSpeaking;
		this.code = code;
		this.label = label;
	}
	public LangageSpeaking() {
		super();
		
	}
	public Long getIdLangageSpeaking() {
		return idLangageSpeaking;
	}
	public void setIdLangageSpeaking(Long idLangageSpeaking) {
		this.idLangageSpeaking = idLangageSpeaking;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
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
	
	
}