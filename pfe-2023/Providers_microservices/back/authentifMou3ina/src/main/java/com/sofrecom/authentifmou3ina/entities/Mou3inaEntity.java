package com.sofrecom.authentifmou3ina.entities;


import java.util.HashSet;
import java.util.Collection;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Mou3inaEntity {
	private static final long serialVersionUID =1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	private String birthday;
	@Column(name = "phone")
	private String phone;
	@Column(name = "documentIdType")
	private String documentIdType;
	@Column(name = "phone2")
	private String phone2;
	@Column(name = "Home_Adress")
	private String home_Adress;
	private float home_Adress_GPS_long;
	private float home_Adress_GPS_latt;
	private String collaborationStatus;
	private String inscriptionStatus;
	private String video;
	private String emailAdress;
	private String vip;
	private String comment;
	@Column(name = "rib")
	private Long rib;
	private int cooptedByID;

	private float gradeAverage;

	@Column(name = "hasASmartPhone")
	private String hasASmartPhone;
	@Column(name = "Photo")
	private String photo;

	@Column(name = "name")
	private String name;
	 //@Column(name = "image", unique = false, nullable = false, length = 100000)
	public byte[] image;
	public byte[] copie;
	private int operational_Id;
	//@Column(name = "Status",nullable = false)
	private String username;
	private String password;

	private String  processInstanceID;

	@Enumerated(EnumType.STRING)
	private DocState docState ;

	private String TokenDevice ;

/*	@Enumerated(EnumType.STRING)
	private EmploymentStatus employmentStatus;*/


	@Column(name = "nbPrestations", nullable = true)

	private Number nbPrestations ;


	@Column(name = "nbFavoris", nullable = true)

	private Number nbfavoris ;

	@Column(name = "FixedPart", nullable = true)
	private float fixedPart ;

	@Column(name = "PourcenN")

	private float N ;

	@Column(name = "PourcenM")
	private float M ;

	@Column(name = "ProviderSalary" , nullable = true)

	private float salary ;

	@OneToMany()
	@JoinColumn(name = "mou3ina_id")
	private Set<AvailibilitiesMou3ina> Availibility;

	@ManyToMany()
	@JoinTable(name = "LangageSpeakingMou3ina", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "idLangageSpeaking") })
	private Collection<LangageSpeaking> langageSpeaking;

	@ManyToOne()
	private Gender gender;

	@ManyToOne()
	private Seniority seniority;

	@ManyToOne()
	private Gouvernorat gouvernorat;

	@ManyToOne()
	private Delegation deligation;

	@ManyToOne()
	private CooptedBy cooptedBy;


	/*@OneToMany()
	@JoinColumn(name = "mou3ina_id")
	private Collection<TrialPeriod> TrialPeriod;*/

	@ManyToOne()
	private Status status;



	/*@ManyToOne()
	private Reclamation reclamation;*/

	//private String Status ;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ServiceTypeMou3ina", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "idService") })
	private Collection<ServiceType> serviceType;



	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "user_roles",
			joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();





	public Mou3inaEntity() {
	super();

	// TODO Auto-generated constructor stub
}




public Mou3inaEntity(Long id, String firstName, Collection<LangageSpeaking> langageSpeaking, String lastName,
		String birthday, Gender gender,Seniority seniority, Gouvernorat gouvernorat, Delegation deligation,
		CooptedBy cooptedBy, String phone, String documentIdType, String phone2, String home_Adress,
		float home_Adress_GPS_long, float home_Adress_GPS_latt, String collaborationStatus, String inscriptionStatus,
		String video, String emailAdress, String vip, String comment,/*Set<AvailibilitiesMou3ina> Availibility ,*/ Long rib, int cooptedByID, float gradeAverage,
		String hasASmartPhone, String photo, String name, byte[] image, byte[] copie,int operational_Id, Status status, Collection<ServiceType> serviceType,String processInstanceID, DocState docState,String TokenDevice,float fixedPart , float M , float N , Number nbfavoris , Number nbPrestations, float salary ,/*EmploymentStatus employmentStatus ,*/ String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.langageSpeaking = langageSpeaking;
		this.lastName = lastName;
		this.birthday = birthday;
		this.gender = gender;
		this.seniority = seniority;
		this.gouvernorat = gouvernorat;
		this.deligation = deligation;
		this.cooptedBy = cooptedBy;
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
		this.vip = vip;
		this.comment = comment;
		//this.Availibility = Availibility;
		this.rib = rib;
		this.cooptedByID = cooptedByID;
		this.gradeAverage = gradeAverage;
		this.hasASmartPhone = hasASmartPhone;
		this.photo = photo;
		this.name = name;
		this.image = image;
		this.copie = copie;
		this.operational_Id = operational_Id;
		this.status = status;
		//this.reclamation = reclamation;
		this.serviceType = serviceType;
		this.processInstanceID= processInstanceID;
		this.docState= docState;
		nbPrestations=nbPrestations;
		this.TokenDevice = TokenDevice;
		this.fixedPart = fixedPart ;
		this.M=M;
		this.N=N;
		this.nbfavoris= nbfavoris ;
		this.salary=salary;
		//this.employmentStatus=employmentStatus;
		this.username = username;
		this.password = password;

}




	public void setAvailibility(Set<AvailibilitiesMou3ina> availibility) {
		Availibility = availibility;
	}

public Set<AvailibilitiesMou3ina> getAvailibility() {
		return Availibility;
	}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}



public String getFirstName() {
	return firstName;
}



public void setFirstName(String firstName) {
	this.firstName = firstName;
}



public Collection<LangageSpeaking> getLangageSpeaking() {
	return langageSpeaking;
}



public void setLangageSpeaking(Collection<LangageSpeaking> langageSpeaking) {
	this.langageSpeaking = langageSpeaking;
}



public String getLastName() {
	return lastName;
}



public void setLastName(String lastName) {
	this.lastName = lastName;
}



public String getBirthday() {
	return birthday;
}



public void setBirthday(String birthday) {
	this.birthday = birthday;
}



public Gender getGender() {
	return gender;
}



public void setGender(Gender gender) {
	this.gender = gender;
}



public Seniority getSeniority() {
	return seniority;
}



public void setSeniority(Seniority seniority) {
	this.seniority = seniority;
}



public Gouvernorat getGouvernorat() {
	return gouvernorat;
}



public void setGouvernorat(Gouvernorat gouvernorat) {
	this.gouvernorat = gouvernorat;
}



public Delegation getDeligation() {
	return deligation;
}



public void setDeligation(Delegation deligation) {
	this.deligation = deligation;
}



public CooptedBy getCooptedBy() {
	return cooptedBy;
}



public void setCooptedBy(CooptedBy cooptedBy) {
	this.cooptedBy = cooptedBy;
}



public String getPhone() {
	return phone;
}



public void setPhone(String phone) {
	this.phone = phone;
}



public String getDocumentIdType() {
	return documentIdType;
}



public void setDocumentIdType(String documentIdType) {
	this.documentIdType = documentIdType;
}



public String getPhone2() {
	return phone2;
}



public void setPhone2(String phone2) {
	this.phone2 = phone2;
}



public String getHome_Adress() {
	return home_Adress;
}



public void setHome_Adress(String home_Adress) {
	this.home_Adress = home_Adress;
}



public float getHome_Adress_GPS_long() {
	return home_Adress_GPS_long;
}



public void setHome_Adress_GPS_long(float home_Adress_GPS_long) {
	this.home_Adress_GPS_long = home_Adress_GPS_long;
}



public float getHome_Adress_GPS_latt() {
	return home_Adress_GPS_latt;
}



public void setHome_Adress_GPS_latt(float home_Adress_GPS_latt) {
	this.home_Adress_GPS_latt = home_Adress_GPS_latt;
}




public String getCollaborationStatus() {
	return collaborationStatus;
}



public void setCollaborationStatus(String collaborationStatus) {
	this.collaborationStatus = collaborationStatus;
}





public String getInscriptionStatus() {
	return inscriptionStatus;
}



public void setInscriptionStatus(String inscriptionStatus) {
	this.inscriptionStatus = inscriptionStatus;
}




public String getVideo() {
	return video;
}



public void setVideo(String video) {
	this.video = video;
}



public String getEmailAdress() {
	return emailAdress;
}



public void setEmailAdress(String emailAdress) {
	this.emailAdress = emailAdress;
}




public String getVip() {
	return vip;
}



public void setVip(String vip) {
	this.vip = vip;
}




public String getComment() {
	return comment;
}



public void setComment(String comment) {
	this.comment = comment;
}



public Long getRib() {
	return rib;
}



public void setRib(Long rib) {
	this.rib = rib;
}



public int getCooptedByID() {
	return cooptedByID;
}



public void setCooptedByID(int cooptedByID) {
	this.cooptedByID = cooptedByID;
}



public float getGradeAverage() {
	return gradeAverage;
}



public void setGradeAverage(float gradeAverage) {
	this.gradeAverage = gradeAverage;
}



public String getHasASmartPhone() {
	return hasASmartPhone;
}



public void setHasASmartPhone(String hasASmartPhone) {
	this.hasASmartPhone = hasASmartPhone;
}



public String getPhoto() {
	return photo;
}



public void setPhoto(String photo) {
	this.photo = photo;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public byte[] getImage() {
	return image;
}



public void setImage(byte[] image) {
	this.image = image;
}




public byte[] getCopie() {
	return copie;
}



public void setCopie(byte[] copie) {
	this.copie = copie;
}



public int getOperational_Id() {
	return operational_Id;
}



public void setOperational_Id(int operational_Id) {
	this.operational_Id = operational_Id;
}




public Status getStatus() {
	return status;
}



public void setStatus(Status status) {
	this.status = status;
}



/*public Reclamation getReclamation() {
	return reclamation;
}



public void setReclamation(Reclamation reclamation) {
	this.reclamation = reclamation;
}*/



public Collection<ServiceType> getServiceType() {
	return serviceType;
}



public void setServiceType(Collection<ServiceType> serviceType) {
	this.serviceType = serviceType;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public Set<Role> getRoles() {
	return roles;
}



public void setRoles(Set<Role> roles) {
	this.roles = roles;
}

	public String getProcessInstanceID() {
		return processInstanceID;
	}

	public void setProcessInstanceID(String processInstanceID) {
		this.processInstanceID = processInstanceID;
	}

	public DocState getDocState() {
		return docState;
	}

	public void setDocState(DocState docState) {
		this.docState = docState;
	}

	public String getTokenDevice() {
		return TokenDevice;
	}

	public void setTokenDevice(String tokenDevice) {
		TokenDevice = tokenDevice;
	}

	public Number getNbPrestations() {
		return nbPrestations;
	}

	public void setNbPrestations(Number nbPrestations) {
		this.nbPrestations = nbPrestations;
	}

	public Number getNbfavoris() {
		return nbfavoris;
	}

	public void setNbfavoris(Number nbfavoris) {
		this.nbfavoris = nbfavoris;
	}

	public float getFixedPart() {
		return fixedPart;
	}

	public void setFixedPart(float fixedPart) {
			this.fixedPart = fixedPart;
	}

	public float getN() {
		return N;
	}

	public void setN(float n) {
		this.N=n;
	}

	public float getM() {
		return M;
	}

	public void setM(float m) {
		this.M=m;
	}

	public float getSalary() {
		return salary;
	}

	public void CalculSalary() {
		float salary = (float) (getFixedPart() + (getN() * getNbfavoris().doubleValue() * getFixedPart()) + ((getNbPrestations().doubleValue()/ 31) * getM() * getFixedPart()));
		setSalary(salary);

	}
	public void setSalary(float salary) {
			this.salary = salary;
		}


/*	public EmploymentStatus getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(EmploymentStatus employmentStatus) {
		this.employmentStatus = employmentStatus;
	}*/
}
