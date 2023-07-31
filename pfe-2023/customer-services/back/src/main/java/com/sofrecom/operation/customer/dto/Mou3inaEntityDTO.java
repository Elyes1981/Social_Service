package com.sofrecom.operation.customer.dto;

import com.sofrecom.operation.customer.entities.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Collection;
import java.util.Set;

public class Mou3inaEntityDTO {



    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String documentIdType;

    private String phone2;

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


    private Double  commissionPercentage;


    private Number nbServicesDone;

    private Integer servicesDone;


    private Number nbfavoris;



    private float salary;


    private double morningCost;


    private double eveningCost;


    private double afternoonCost;


    private String device;

    private Collection<ServiceType> serviceType;

    private Set<AvailibilitiesMou3ina> Availibility;

    private Gouvernorat gouvernorat;

    private Delegation deligation;


    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus;

    //private Double distance ;


    @ManyToOne
    CleaningServicesCompany company ;

    public Mou3inaEntityDTO() {
        super();


    }

    public Mou3inaEntityDTO(Long id, String firstName, String lastName, String phone, String documentIdType, String phone2,
                            String home_Adress, float home_Adress_GPS_long, float home_Adress_GPS_latt, String collaborationStatus,
                            String inscriptionStatus, String video, String emailAdress, float gradeAverage, String hasASmartPhone, String photo,
                            String name, byte[] image, byte[] copie, Number nbServicesDone, Number nbfavoris, float salary,Double  commissionPercentage, double morningCost,
                            double eveningCost, double afternoonCost, String device,  Collection<ServiceType> serviceType , Set<AvailibilitiesMou3ina> Availibility, CleaningServicesCompany company ,Gouvernorat gouvernorat, Delegation deligation , Integer servicesDone, EmploymentStatus employmentStatus) {
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
        this.commissionPercentage=commissionPercentage;
        this.morningCost = morningCost;
        this.eveningCost = eveningCost;
        this.afternoonCost = afternoonCost;
        this.device = device;
        this.serviceType=serviceType;
        this.Availibility=Availibility;
        this.company=company ;
        this.gouvernorat= gouvernorat;
        this.deligation= deligation;
        //this.distance= distance ;
        this.servicesDone=servicesDone;
        this.employmentStatus=employmentStatus;
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


    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
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

    public Number getNbServicesDone() {
        return nbServicesDone;
    }

    public void setNbServicesDone(Number nbServicesDone) {
        this.nbServicesDone = nbServicesDone;
    }

    public Number getNbfavoris() {
        return nbfavoris;
    }

    public void setNbfavoris(Number nbfavoris) {
        this.nbfavoris = nbfavoris;
    }

//    public Double getDistance() {
//        return distance;
//    }
//
//    public void setDistance(Double distance) {
//        this.distance = distance;
//    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public double getMorningCost() {
        return morningCost;
    }

    public void setMorningCost(double morningCost) {
        this.morningCost = morningCost;
    }

    public double getEveningCost() {
        return eveningCost;
    }

    public void setEveningCost(double eveningCost) {
        this.eveningCost = eveningCost;
    }

    public double getAfternoonCost() {
        return afternoonCost;
    }

    public void setAfternoonCost(double afternoonCost) {
        this.afternoonCost = afternoonCost;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

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

    public CleaningServicesCompany getCompany() {
        return company;
    }

    public void setCompany(CleaningServicesCompany company) {
        this.company = company;
    }

    public Double getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(Double commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
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

    public Integer getServicesDone() {
        return servicesDone;
    }

    public void setServicesDone(Integer servicesDone) {
        servicesDone = servicesDone;
    }
}
