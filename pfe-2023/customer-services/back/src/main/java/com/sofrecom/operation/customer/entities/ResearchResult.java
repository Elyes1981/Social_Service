package com.sofrecom.operation.customer.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;


@Data
@Entity
public class ResearchResult {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private Long id_mou3ina;
	@Column
	private String firstname_Mou3ina;
	@Column
	private String lastname_Mou3ina;
	@Column
	private String homeadress_Mou3ina;
	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "ResearchResult_serviceType",
	            joinColumns = @JoinColumn(referencedColumnName = "id", name = "id"),
	            inverseJoinColumns = @JoinColumn(referencedColumnName = "idService", name = "idService"))
	 private Collection<ServiceType> serviceTypes;

	public ResearchResult(Long id, Long id_mou3ina, String firstname_Mou3ina, String lastname_Mou3ina,
			String homeadress_Mou3ina, Collection<ServiceType> serviceTypes) {
		super();
		this.id = id;
		this.id_mou3ina = id_mou3ina;
		this.firstname_Mou3ina = firstname_Mou3ina;
		this.lastname_Mou3ina = lastname_Mou3ina;
		this.homeadress_Mou3ina = homeadress_Mou3ina;
		this.serviceTypes = serviceTypes;
	}
	public ResearchResult() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_mou3ina() {
		return id_mou3ina;
	}
	public void setId_mou3ina(Long id_mou3ina) {
		this.id_mou3ina = id_mou3ina;
	}
	public String getFirstname_Mou3ina() {
		return firstname_Mou3ina;
	}
	public void setFirstname_Mou3ina(String firstname_Mou3ina) {
		this.firstname_Mou3ina = firstname_Mou3ina;
	}
	public String getLastname_Mou3ina() {
		return lastname_Mou3ina;
	}
	public void setLastname_Mou3ina(String lastname_Mou3ina) {
		this.lastname_Mou3ina = lastname_Mou3ina;
	}
	public String getHomeadress_Mou3ina() {
		return homeadress_Mou3ina;
	}
	public void setHomeadress_Mou3ina(String homeadress_Mou3ina) {
		this.homeadress_Mou3ina = homeadress_Mou3ina;
	}
	public Collection<ServiceType> getServiceTypes() {
		return serviceTypes;
	}
	public void setServiceTypes(Collection<ServiceType> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	 
	 
	
	
	


}
