package com.sofrecom.operation.customer.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
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


    private String siteLinkedIn ;
    private  String siteInstagram ;
    private String siteTwitter ;

    private String logo ;


    private String firstNameOwner ;

    private String lastNameOwner ;




    @JsonIgnore
    @OneToMany
    private Set<Mou3inaEntity> providers;





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



    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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



    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public CleaningServicesCompany(Long id, String companyName, String adress, String emailAdress, String rib,
                                   String phone,  String siteLinkedIn, String siteInstagram, String siteTwitter, String logo,
                                   Set<Mou3inaEntity> providers,  String firstNameOwner , String lastNameOwner,  double percentage) {
        this.id = id;
        this.companyName = companyName;
        this.adress = adress;
        this.emailAdress = emailAdress;
        this.rib = rib;
        this.phone = phone;
        this.siteLinkedIn = siteLinkedIn;
        this.siteInstagram = siteInstagram;
        this.siteTwitter = siteTwitter;
        this.logo = logo;
        this.providers = providers;
        this.firstNameOwner=firstNameOwner;
        this.lastNameOwner=lastNameOwner;
        this.percentage=percentage;
    }

    public CleaningServicesCompany() {
        super();
        // TODO Auto-generated constructor stub
    }
}
