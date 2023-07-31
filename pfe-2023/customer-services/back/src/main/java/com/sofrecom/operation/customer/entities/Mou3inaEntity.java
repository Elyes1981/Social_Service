package com.sofrecom.operation.customer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Mou3inaEntity")
public class Mou3inaEntity implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "mou3ina_id", nullable = false)

	public Long id;

	@Column(name = "firstName")

	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;

	private String phone;

	private String documentIdType;

	private String phone2;

	@ManyToOne()
	private Gouvernorat gouvernorat;

	@ManyToOne
	private Delegation deligation;

	private String home_Adress;
	private float home_Adress_GPS_long;
	private float home_Adress_GPS_latt;
	private String collaborationStatus;
	private String inscriptionStatus;
	private String video;
	private String emailAdress;

	private float gradeAverage;


	private String hasASmartPhone;

	private String photo;


	private String name;
	public byte[] image;
	public byte[] copie;

	@Transient
	private Double distance ;



	private Number nbServicesDone;

	@Column(name = "ServicesDone")
	private Integer servicesDone;


	private Number nbfavoris;


	@Column(name = "commissionPercentage")
	private Double  commissionPercentage;


	private float salary;


	private double morningCost;


	private double eveningCost;


	private double afternoonCost;

	private String device;

	@Enumerated(EnumType.STRING)
	private EmploymentStatus employmentStatus;



	//private Set<Customer_Mou3ina_Preferences> customer_Mou3ina_Preferences = new HashSet<Customer_Mou3ina_Preferences>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ServiceTypeMou3ina", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "idService") })
	private Collection<ServiceType> serviceType;

	@OneToMany()
	@JoinColumn(name = "mou3ina_id")
	@JsonIgnore
	private Set<AvailibilitiesMou3ina> Availibility;

	//@JsonIgnore
	@ManyToOne
	CleaningServicesCompany company ;


	/*public Mou3inaEntity(Long id, String firstName, String lastName, String phone, String documentIdType, String phone2, String home_Adress, float home_Adress_GPS_long, float home_Adress_GPS_latt, String collaborationStatus, String inscriptionStatus, String video, String emailAdress, float gradeAverage, String hasASmartPhone, String photo, String name, byte[] image, byte[] copie, Number nbServicesDone, Number nbfavoris, float salary, double morningCost, double eveningCost, double afternoonCost, String device ,Collection<ServiceType> serviceType ) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.documentIdType = documentIdType;
		this.phone2 = phone2;
		this.home_Adress = home_Adress;
		this.home_Adress_GPS_long = home_Adress_GPS_long;
		this.home_Adress_GPS_latt = home_Adress_GPS_latt;
		this.collaborationStatus = collaborationStatus;
		this.inscriptionStatus = inscriptionStatus;
		this.video = video;
		this.emailAdress = emailAdress;
		this.gradeAverage = gradeAverage;
		this.hasASmartPhone = hasASmartPhone;
		this.photo = photo;
		this.name = name;
		this.image = image;
		this.copie = copie;
		this.nbServicesDone = nbServicesDone;
		this.nbfavoris = nbfavoris;
		this.salary = salary;
		this.morningCost = morningCost;
		this.eveningCost = eveningCost;
		this.afternoonCost = afternoonCost;
		this.device = device;
		this.serviceType=serviceType;
	}
*/

	public Mou3inaEntity(Long id, String firstName, String lastName, String phone, String documentIdType, String phone2, Gouvernorat gouvernorat, Delegation deligation, String home_Adress, float home_Adress_GPS_long, float home_Adress_GPS_latt, String collaborationStatus, String inscriptionStatus, String video, String emailAdress, float gradeAverage, String hasASmartPhone, String photo, String name, byte[] image, byte[] copie, Number nbServicesDone, Integer servicesDone, Number nbfavoris, Double commissionPercentage, float salary, double morningCost, double eveningCost, double afternoonCost, String device, Collection<ServiceType> serviceType, Set<AvailibilitiesMou3ina> availibility, CleaningServicesCompany company , EmploymentStatus employmentStatus) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.documentIdType = documentIdType;
		this.phone2 = phone2;
		this.gouvernorat = gouvernorat;
		this.deligation = deligation;
		this.home_Adress = home_Adress;
		this.home_Adress_GPS_long = home_Adress_GPS_long;
		this.home_Adress_GPS_latt = home_Adress_GPS_latt;
		this.collaborationStatus = collaborationStatus;
		this.inscriptionStatus = inscriptionStatus;
		this.video = video;
		this.emailAdress = emailAdress;
		this.gradeAverage = gradeAverage;
		this.hasASmartPhone = hasASmartPhone;
		this.photo = photo;
		this.name = name;
		this.image = image;
		this.copie = copie;
		this.nbServicesDone = nbServicesDone;
		this.servicesDone = servicesDone;
		this.nbfavoris = nbfavoris;
		this.commissionPercentage = commissionPercentage;
		this.salary = salary;
		this.morningCost = morningCost;
		this.eveningCost = eveningCost;
		this.afternoonCost = afternoonCost;
		this.device = device;
		this.serviceType = serviceType;
		Availibility = availibility;
		this.company = company;
		this.employmentStatus=employmentStatus;
	}
}
