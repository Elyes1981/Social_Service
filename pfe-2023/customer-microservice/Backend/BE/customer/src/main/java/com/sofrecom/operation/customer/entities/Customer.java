package com.sofrecom.operation.customer.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity

@Getter
@Setter
public class Customer  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	@Column(name = "firstName")
	@Size(min = 2, message = "firstName must be >2 characters long.")
	private String firstName;
	@Column(name = "lastName")
	@Size(min = 2, message = "LastName must be >2 characters long.")
	private String lastName;
	@ManyToOne

	private Gender gender;
	@ManyToOne
	private Agent agent;
	
	//coté complain
	@Column(name = "birthDate")
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	//@Past(message = "Date input is invalid for a birth date.")
	private Date birthDate;

	@ManyToOne

	private Status status;

	
	@Column(name = "phone")
	private String phone;

	@ManyToOne
	private Gouvernorat gouvernerat;

	@ManyToOne
	private Delegation delegation;
	@Column(name = "home_Adress")
	@Size(min = 6, message = "Home Adress must be more than 6 characters long.")
	private String home_Adress;
	private Float home_Adress_GPS_long;
	private Float home_Adress_GPS_latt;
	@Column(name = "emailAdress")
	@Email(message = "Enter a valid email address.")
	// @Email(message = "Email is not valid", regexp =
	// "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	private String emailAdress;
	@Column(name = "paymentMean")
	private String paymentMean;

	@Column(name = "creditCardNumber")
	private Long creditCardNumber;

	@Column(name = "cooptedById")
	private Long cooptedById;
	@ManyToOne
	private CooptedByType cooptedByType;

	@Column(name = "creditCardCVV2")
	private Long creditCardCVV2;
	
	
	@OneToOne
	private ResidenceType residenceType;
	@Column(name = "creditCardExpireDate")
	@FutureOrPresent(message = "Date input is invalid for an Expiration Date.")
	private Date creditCardExpireDate;

	@Column(name = "residenceNumberOfrooms")
	@Min(1)
	@Max(10)
	private Long residenceNumberOfrooms;
	@Column(name = "numberOfPersonInRes")
	@Min(1)
	@Max(10)
	private Long numberOfPersonInRes;
	private Long metrage;
	@Column(name = "photo")
	private String photo;
	public byte[] image;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Customer_Mou3ina_Preferences", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "id_mou3ina") })
	private Collection<Mou3inaEntity> mou3inas_preferences;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Customer_Mou3ina_Blacklist", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "id_mou3ina") })
	private Collection<Mou3inaEntity> mou3inas_blacklist;
	
	@Column(name = "reset_password_token")
    private String resetPasswordToken;
/*
	public Customer(@Size(max = 20) String username,
			@Size(min = 2, message = "firstName must be >2 characters long.") String firstName,
			@Size(min = 2, message = "LastName must be >2 characters long.") String lastName, Date birthDate,
			Gouvernorat gouvernerat, Delegation delegation,
			@Email(message = "Enter a valid email address.") String emailAdress) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gouvernerat = gouvernerat;
		this.delegation = delegation;
		this.emailAdress = emailAdress;
	}*/
	
	public Customer() {
		super();
	}


	public Customer(String password,String username,Delegation delegation2, Date birthDate2, String emailAdress2, String firstName2, String lastName2) {
		this.username = username;
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.birthDate = birthDate2;
		this.delegation = delegation2;
		this.emailAdress = emailAdress2;
		this.password=password;
		}

	
	public Customer(String username2, String email, String encode) {
		this.username=username2;
		this.emailAdress=email;
		this.password=encode;
		// TODO Auto-generated constructor stub
	}


	public Customer(Long id, String username, String password, Set<Role> roles,
			@Size(min = 2, message = "firstName must be >2 characters long.") String firstName,
			@Size(min = 2, message = "LastName must be >2 characters long.") String lastName, Gender gender,
			Agent agent,
					Date birthDate, Status status, String phone, Gouvernorat gouvernerat, Delegation delegation,
			@Size(min = 6, message = "Home Adress must be more than 6 characters long.") String home_Adress,
			Float home_Adress_GPS_long, Float home_Adress_GPS_latt,
			@Email(message = "Enter a valid email address.") String emailAdress, String paymentMean,
			Long creditCardNumber, Long cooptedById, CooptedByType cooptedByType, Long creditCardCVV2,
			ResidenceType residenceType,
			@FutureOrPresent(message = "Date input is invalid for an Expiration Date.") Date creditCardExpireDate,
			@Min(1) @Max(10) Long residenceNumberOfrooms, @Min(1) @Max(10) Long numberOfPersonInRes, Long metrage,
			String photo, byte[] image, Collection<Mou3inaEntity> mou3inas_preferences,
			Collection<Mou3inaEntity> mou3inas_blacklist
	) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		//this.agent = agent;
		this.birthDate = birthDate;
		this.status = status;
		this.phone = phone;
		this.gouvernerat = gouvernerat;
		this.delegation = delegation;
		this.home_Adress = home_Adress;
		this.home_Adress_GPS_long = home_Adress_GPS_long;
		this.home_Adress_GPS_latt = home_Adress_GPS_latt;
		this.emailAdress = emailAdress;
		this.paymentMean = paymentMean;
		this.creditCardNumber = creditCardNumber;
		this.cooptedById = cooptedById;
		this.cooptedByType = cooptedByType;
		this.creditCardCVV2 = creditCardCVV2;
		this.residenceType = residenceType;
		this.creditCardExpireDate = creditCardExpireDate;
		this.residenceNumberOfrooms = residenceNumberOfrooms;
		this.numberOfPersonInRes = numberOfPersonInRes;
		this.metrage = metrage;
		this.photo = photo;
		this.image = image;
		this.mou3inas_preferences = mou3inas_preferences;
		this.mou3inas_blacklist = mou3inas_blacklist;
	}



}