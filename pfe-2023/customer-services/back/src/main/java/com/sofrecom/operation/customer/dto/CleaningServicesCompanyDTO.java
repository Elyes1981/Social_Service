package com.sofrecom.operation.customer.dto;

import com.sofrecom.operation.customer.entities.Mou3inaEntity;

import java.util.Set;

public class CleaningServicesCompanyDTO {

    private Long id ;

    private String companyName  ;

    private double percentage;

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

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Set<Mou3inaEntity> getProviders() {
        return providers;
    }

    public void setProviders(Set<Mou3inaEntity> providers) {
        this.providers = providers;
    }

    public CleaningServicesCompanyDTO(Long id, String companyName, double percentage, Set<Mou3inaEntity> providers) {
        this.id = id;
        this.companyName = companyName;
        this.percentage = percentage;
        this.providers = providers;
    }

    public CleaningServicesCompanyDTO(){
        super();
    }
}
