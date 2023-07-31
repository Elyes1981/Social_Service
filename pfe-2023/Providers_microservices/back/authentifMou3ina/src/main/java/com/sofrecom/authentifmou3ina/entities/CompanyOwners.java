package com.sofrecom.authentifmou3ina.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
public class CompanyOwners {

    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String firstName ;
    private String lastName ;
    private String birthday;
    @Column(name = "cin")
    private String cin;
    @Column(name = "phone")
    private String phone;

    private String address ;

    private String emailAdress;

    @Column(name = "Photo")
    private String photo;

    @Column(name = "device")
    private String device ;

    @ManyToOne
    CleaningServicesCompany company ;

    @ManyToOne()
    private Gender gender;

    @ManyToOne()
    private Gouvernorat gouvernorat;

    @ManyToOne()
    private Delegation deligation;

    @ManyToOne()
    private Status status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "provider_roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "idRole"))
    private Set<Role> roles;

    public CompanyOwners(){
        super();
    }

    public CompanyOwners(Long id, String firstName, String lastName, String birthday, String cin, String phone, String address, String emailAdress, String photo, String device, CleaningServicesCompany compan
                         , Gender gender, Gouvernorat gouvernorat, Delegation deligation, Status status, Set<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.cin = cin;
        this.phone = phone;
        this.address = address;
        this.emailAdress = emailAdress;
        this.photo = photo;
        this.device = device;
        this.company = company;
        this.gender = gender;
        this.gouvernorat = gouvernorat;
        this.deligation = deligation;
        this.status = status;
        this.roles = roles;
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public CleaningServicesCompany getCompany() {
        return company;
    }

    public void setCompany(CleaningServicesCompany company) {
        this.company = company;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
