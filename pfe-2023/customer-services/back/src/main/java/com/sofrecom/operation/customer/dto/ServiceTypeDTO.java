package com.sofrecom.operation.customer.dto;

public class ServiceTypeDTO {


    private Long idService;

    private String label_fr ;

    private String label_ar ;

    private Long code ;

    private String label ;

    public ServiceTypeDTO(Long idService, String label_fr, String label_ar, Long code, String label) {
        this.idService = idService;
        this.label_fr = label_fr;
        this.label_ar = label_ar;
        this.code = code;
        this.label = label;
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    public String getLabel_fr() {
        return label_fr;
    }

    public void setLabel_fr(String label_fr) {
        this.label_fr = label_fr;
    }

    public String getLabel_ar() {
        return label_ar;
    }

    public void setLabel_ar(String label_ar) {
        this.label_ar = label_ar;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
