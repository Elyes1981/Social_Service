package com.sofrecom.operation.customer.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class CustomerReservationDTO {

    public long id;

    private Timestamp operationDate;


    private Date desiredDate;


    private Integer numberOfMou3ina;

    private  Double rate;

    private Date desiredHour;


    private Integer gradeAverage;

    private String  processInstanceID;


    private boolean morning;


    private boolean afternoon;


    private boolean evening;

    private String paymentStatus ;

    private Integer frequency;

    private List<Mou3inaEntityDTO> providers ;

/*    public CustomerReservationDTO(long id, Timestamp operationDate, Date desiredDate, Integer numberOfMou3ina,
                                  Double rate, Date desiredHour, Integer gradeAverage, String processInstanceID, boolean morning,
                                  boolean afternoon, boolean evening, String paymentStatus, Integer frequency, List<Mou3inaEntityDTO> providers) {
        this.id = id;
        this.operationDate = operationDate;
        this.desiredDate = desiredDate;
        this.numberOfMou3ina = numberOfMou3ina;
        this.rate = rate;
        this.desiredHour = desiredHour;
        this.gradeAverage = gradeAverage;
        this.processInstanceID = processInstanceID;
        this.morning = morning;
        this.afternoon = afternoon;
        this.evening = evening;
        this.paymentStatus = paymentStatus;
        this.frequency = frequency;
        this.providers = providers;
    }*/

    public CustomerReservationDTO() {
        super();
        // Constructeur par défaut
    }


    public CustomerReservationDTO(long id, Timestamp operationDate, Date desiredDate, Integer numberOfMou3ina,
                                  Double rate, Date desiredHour, Integer gradeAverage, String processInstanceID, boolean morning,
                                  boolean afternoon, boolean evening, String paymentStatus, Integer frequency, List<Mou3inaEntityDTO> providers) {
        this.id = id;
        this.operationDate = operationDate;
        this.desiredDate = desiredDate;
        this.numberOfMou3ina = numberOfMou3ina;
        this.rate = rate;
        this.desiredHour = desiredHour;
        this.gradeAverage = gradeAverage;
        this.processInstanceID = processInstanceID;
        this.morning = morning;
        this.afternoon = afternoon;
        this.evening = evening;
        this.paymentStatus = paymentStatus;
        this.frequency = frequency;
        this.providers = providers;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Timestamp operationDate) {
        this.operationDate = operationDate;
    }

    public Date getDesiredDate() {
        return desiredDate;
    }

    public void setDesiredDate(Date desiredDate) {
        this.desiredDate = desiredDate;
    }

    public Integer getNumberOfMou3ina() {
        return numberOfMou3ina;
    }

    public void setNumberOfMou3ina(Integer numberOfMou3ina) {
        this.numberOfMou3ina = numberOfMou3ina;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getDesiredHour() {
        return desiredHour;
    }

    public void setDesiredHour(Date desiredHour) {
        this.desiredHour = desiredHour;
    }

    public Integer getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(Integer gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    public String getProcessInstanceID() {
        return processInstanceID;
    }

    public void setProcessInstanceID(String processInstanceID) {
        this.processInstanceID = processInstanceID;
    }

    public boolean isMorning() {
        return morning;
    }

    public void setMorning(boolean morning) {
        this.morning = morning;
    }

    public boolean isAfternoon() {
        return afternoon;
    }

    public void setAfternoon(boolean afternoon) {
        this.afternoon = afternoon;
    }

    public boolean isEvening() {
        return evening;
    }

    public void setEvening(boolean evening) {
        this.evening = evening;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public List<Mou3inaEntityDTO> getProviders() {
        return providers;
    }

    public static void setProviders(List<Mou3inaEntityDTO> providers) {
        providers = providers;
    }
}
