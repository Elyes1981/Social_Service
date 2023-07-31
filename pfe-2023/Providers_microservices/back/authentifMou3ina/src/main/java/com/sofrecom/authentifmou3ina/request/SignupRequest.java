package com.sofrecom.authentifmou3ina.request;
import com.sofrecom.authentifmou3ina.entities.*;
import java.util.Collection;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;



public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
  @Column(name = "firstName")
  private String firstName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	
	private Long id;
	@ManyToMany()
	@JoinTable(name = "LangageSpeakingMou3ina", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "idLangageSpeaking") })
	private Collection<LangageSpeaking> langageSpeaking;
	@Column(name = "lastName")

	private String lastName;


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

	
	@Column(name = "phone")
	//
	private String phone;
	@Column(name = "documentIdType")
	//
	private String documentIdType;
	@Column(name = "phone2")
	//
	private String phone2;
	@Column(name = "Home_Adress")
	//
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

	@Column(name = "image", unique = false, nullable = false, length = 100000)
	public byte[] image;
	public byte[] copie;

	private int operational_Id;
	@Column(name = "Status",nullable = false)

	@ManyToOne()
	private Status status;

	private String  processInstanceID;
	
	/*@ManyToOne()

	private Reclamation reclamation;*/

	private String Status ;

	@OneToMany()
	@JoinColumn(name = "mou3ina_id")
	private Set<AvailibilitiesMou3ina> Availibility;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ServiceTypeMou3ina", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "idService") })
	private Collection<ServiceType> serviceType;

	

	public SignupRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	/*public String getCollaborationStatus() {
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
*/
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

	/*public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}*/

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

	public String getProcessInstanceID() {
		return processInstanceID;
	}

	public void setProcessInstanceID(String processInstanceID) {
		this.processInstanceID = processInstanceID;
	}

	/*public Reclamation getReclamation() {
                return reclamation;
            }

            public void setReclamation(Reclamation reclamation) {
                this.reclamation = reclamation;
            }
        */
	public Collection<ServiceType> getServiceType() {
		return serviceType;
	}

	public void setServiceType(Collection<ServiceType> serviceType) {
		this.serviceType = serviceType;
	}


	public Set<AvailibilitiesMou3ina> getAvailibility() {
		return Availibility;
	}

	public void setAvailibility(Set<AvailibilitiesMou3ina> availibility) {
		Availibility = availibility;
	}
}
