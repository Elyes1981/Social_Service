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

    private String rib ;

    private String phone ;

    private String username;

    private String password;

    @OneToMany
    private Set<Mou3inaEntity> providers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "user_roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



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

    public CleaningServicesCompany(Long id, String companyName, String adress, String emailAdress, String rib, String phone,Set<Mou3inaEntity> providers , String username, String password) {
        this.id = id;
        this.companyName = companyName;
        this.adress = adress;
        this.emailAdress = emailAdress;
        this.rib = rib;
        this.phone = phone;
        providers = providers;
        this.username = username;
        this.password = password;

    }

    public CleaningServicesCompany() {
        super();
        // TODO Auto-generated constructor stub
    }
}
