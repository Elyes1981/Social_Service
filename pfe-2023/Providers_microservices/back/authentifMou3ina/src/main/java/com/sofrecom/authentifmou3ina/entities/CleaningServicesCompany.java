package com.sofrecom.authentifmou3ina.entities;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CleaningServicesCompany {

    private static final long serialVersionUID =1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id ;
    private String companyName  ;
    private String adress ;
    private String emailAdress;

    private double percentage;
    private String rib ;

    private String phone ;

    private  Long rne ;//(Registro Nacional de Empresas)

    private String siteLinkedIn ;
    private  String siteInstagram ;
    private String siteTwitter ;

    private String logo ;

    private  String description ;

    private String firstNameOwner ;

    private String lastNameOwner ;

    private String companyID ;

    @ElementCollection
    @CollectionTable(name = "payment_means", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "payment_mean")
    @Enumerated(EnumType.STRING)
    private Set<MeanPayment> meansPayment;
    private String username;

    private String password;

    @OneToMany
    private Set<Mou3inaEntity> providers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "company_roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "idRole"))
    private Set<Role> roles;

    @OneToMany()
    private Set<CompanyOwners> companyOwners;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Set<Mou3inaEntity> getProviders() {
        return providers;
    }

    public void setProviders(Set<Mou3inaEntity> providers) {
        this.providers = providers;
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

    public Long getRne() {
        return rne;
    }

    public void setRne(Long RNE) {
        this.rne = RNE;
    }

    public String getSiteLinkedIn() {
        return siteLinkedIn;
    }

    public void setSiteLinkedIn(String siteLinkedIn) {
        this.siteLinkedIn = siteLinkedIn;
    }

    public String getSiteInstagram() {
        return siteInstagram;
    }

    public void setSiteInstagram(String siteInstagram) {
        this.siteInstagram = siteInstagram;
    }

    public String getSiteTwitter() {
        return siteTwitter;
    }

    public void setSiteTwitter(String siteTwitter) {
        this.siteTwitter = siteTwitter;
    }

    public Set<CompanyOwners> getCompanyOwners() {
        return companyOwners;
    }

    public void setCompanyOwners(Set<CompanyOwners> companyOwners) {
        this.companyOwners = companyOwners;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstNameOwner() {
        return firstNameOwner;
    }

    public void setFirstNameOwner(String firstNameOwner) {
        this.firstNameOwner = firstNameOwner;
    }

    public String getLastNameOwner() {
        return lastNameOwner;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public void setLastNameOwner(String lastNameOwner) {
        this.lastNameOwner = lastNameOwner;
    }
    /*    public CleaningServicesCompany(Long id, String companyName, String adress, String emailAdress, String rib, String phone, Set<Mou3inaEntity> providers , Set<Role> roles, Long RNE, String username, String password) {
        this.id = id;
        this.companyName = companyName;
        this.adress = adress;
        this.emailAdress = emailAdress;
        this.rib = rib;
        this.phone = phone;
        providers = providers;
        roles=roles;
        this.rne=RNE;
        this.username = username;
        this.password = password;

    }*/

    public Set<MeanPayment> getMeansPayment() {
        return meansPayment;
    }

    public void setMeansPayment(Set<MeanPayment> meansPayment) {
        this.meansPayment = meansPayment;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public CleaningServicesCompany(Long id, String companyName, String adress, String emailAdress, String rib,
                                   String phone, Long rne, String siteLinkedIn, String siteInstagram, String siteTwitter, String logo, String description,
                                   Set<Mou3inaEntity> providers, Set<Role> roles, Set<CompanyOwners> companyOwners, String firstNameOwner , String lastNameOwner, Set<MeanPayment> meanPayment,double percentage, String companyID , String username, String password ) {
        this.id = id;
        this.companyName = companyName;
        this.adress = adress;
        this.emailAdress = emailAdress;
        this.rib = rib;
        this.phone = phone;
        this.rne = rne;
        this.siteLinkedIn = siteLinkedIn;
        this.siteInstagram = siteInstagram;
        this.siteTwitter = siteTwitter;
        this.logo = logo;
        this.description = description;
        this.username = username;
        this.password = password;
        this.providers = providers;
        this.firstNameOwner=firstNameOwner;
        this.lastNameOwner=lastNameOwner;
        this.meansPayment=meansPayment;
        this.percentage=percentage;
        this.companyID=companyID;
        this.roles = roles;
        this.companyOwners = companyOwners;
    }

    public CleaningServicesCompany() {
        super();
        // TODO Auto-generated constructor stub
    }
}
