package com.sofrecom.operation.admin.service;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sofrecom.operation.admin.entities.Agent;
import com.sofrecom.operation.admin.entities.CooptedByType;
import com.sofrecom.operation.admin.entities.Customer;
import com.sofrecom.operation.admin.entities.Delegation;
import com.sofrecom.operation.admin.entities.Gender;
import com.sofrecom.operation.admin.entities.Gouvernorat;
import com.sofrecom.operation.admin.entities.Mou3inaEntity;
import com.sofrecom.operation.admin.entities.ResidenceType;
import com.sofrecom.operation.admin.entities.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	
	
	@JsonIgnore
	private String password;
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
	@JoinTable(name = "Customer_Mou3ina_Preferences", joinColumns = { @JoinColumn(name = "id_mou3ina") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	private Collection<Mou3inaEntity> mou3inas_preferences;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Customer_Mou3ina_Blacklist", joinColumns = { @JoinColumn(name = "id_mou3ina") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	private Collection<Mou3inaEntity> mou3inas_blacklist;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public static UserDetailsImpl build(Customer user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());
		return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(), 
				user.getPassword(),
				user.getFirstName(),
				user.getLastName(),
				user.getGender(),
				user.getAgent(),
				user.getBirthDate(),
				user.getStatus(),
				user.getPhone(),
				user.getGouvernerat(),
				user.getDelegation(),
				user.getHome_Adress(),
				user.getHome_Adress_GPS_long(),
				user.getHome_Adress_GPS_latt(),
				user.getEmailAdress(),
				user.getPaymentMean(),
				user.getCreditCardNumber(),
				user.getCooptedById(),
				user.getCooptedByType(),
				user.getCreditCardCVV2(),
				user.getResidenceType(),
				user.getCreditCardExpireDate(),
				user.getResidenceNumberOfrooms(),
				user.getNumberOfPersonInRes(),
				user.getMetrage(),
				user.getPhoto(),
				user.getImage(),
				user.getMou3inas_preferences(),
				user.getMou3inas_blacklist(),
				
				
				authorities);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public Long getId() {
		return id;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
	
	public UserDetailsImpl(Long id, String username, String password,
			@Size(min = 2, message = "firstName must be >2 characters long.") String firstName,
			@Size(min = 2, message = "LastName must be >2 characters long.") String lastName, Gender gender,
			Agent agent, Date birthDate, Status status, String phone, Gouvernorat gouvernerat, Delegation delegation,
			@Size(min = 6, message = "Home Adress must be more than 6 characters long.") String home_Adress,
			Float home_Adress_GPS_long, Float home_Adress_GPS_latt,
			@Email(message = "Enter a valid email address.") String emailAdress, String paymentMean,
			Long creditCardNumber, Long cooptedById, CooptedByType cooptedByType, Long creditCardCVV2,
			ResidenceType residenceType,
			@FutureOrPresent(message = "Date input is invalid for an Expiration Date.") Date creditCardExpireDate,
			@Min(1) @Max(10) Long residenceNumberOfrooms, @Min(1) @Max(10) Long numberOfPersonInRes, Long metrage,
			String photo, byte[] image, Collection<Mou3inaEntity> mou3inas_preferences,
			Collection<Mou3inaEntity> mou3inas_blacklist, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.agent = agent;
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
		this.authorities = authorities;
	}
	
	
}