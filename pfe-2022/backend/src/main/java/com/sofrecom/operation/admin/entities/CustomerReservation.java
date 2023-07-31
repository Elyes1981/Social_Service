package com.sofrecom.operation.admin.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity(name="CustomerReservation")
public class CustomerReservation implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    public long id;


    @CreationTimestamp
    @Column(name = "operationDate")
    private Timestamp operationDate;

    @Column(name = "desiredDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date desiredDate;

    @Min(1)
    @Column(name = "numberOfMou3ina")
    private Integer numberOfMou3ina;

    //@ManyToOne

	private  Double rate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern="HH:mm")
    @Column(name = "desiredHour")
    private Date desiredHour;


    @Column(name = "gradeAverage")
    private Integer gradeAverage;

    @Column(name = "morning")
    private boolean morning;

    @Column(name = "afternoon")
    private boolean afternoon;

    @Column(name = "evening")
    private boolean evening;

    @Column(name = "paymentStatus")
    @Size( max =200, message = "PaymentStatus must have characters long")
    private String paymentStatus ="null";

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CustomerReservation_serviceType",
            joinColumns = @JoinColumn(referencedColumnName = "id", name = "id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "idService", name = "idService"))

    private Collection<ServiceType> serviceTypes;

    @ManyToOne()
    @JoinColumn(name="customer")
    private Customer customer;
    
    @ManyToOne()
    @JoinColumn(name="statuscode")
    private StatusReservation statuscode;

    @Column(name = "isRecurrent")
    private boolean isRecurrent;
    @OneToMany(fetch=FetchType.EAGER,mappedBy="CustomerReservation",cascade = CascadeType.ALL)
    private Set<Recurrentreservation> recurrents = new HashSet<Recurrentreservation>();
 
    public Set<Recurrentreservation> getRecurrents() {
        return recurrents;
    }

    public void setRecurrents(Set<Recurrentreservation> recurrents) {
        this.recurrents = recurrents;
    }

    @Column(name = "frequency")
    private Integer frequency;


   
    @OneToMany(mappedBy = "primaryKey.customerReservation",cascade = CascadeType.ALL, orphanRemoval = true)
     @Transient
     @JsonIgnore
     private Set<CustomerOrderMou3inaList> CustomerOrderMou3inaLists = new HashSet<CustomerOrderMou3inaList>();

    public Set<CustomerOrderMou3inaList> getCustomerOrderMou3inaLists() {
        return CustomerOrderMou3inaLists;
    }

    public void setCustomerOrderMou3inaLists(Set<CustomerOrderMou3inaList> CustomerOrderMou3inaLists) {
        this.CustomerOrderMou3inaLists = CustomerOrderMou3inaLists;
    }
    public void addReservation(CustomerOrderMou3inaList CustomerOrderMou3inaList) {
        this.CustomerOrderMou3inaLists.add(CustomerOrderMou3inaList);
    }
    public void addCustomerOrderMou3inaList(CustomerOrderMou3inaList CustomerOrderMou3inaList) {
        this.CustomerOrderMou3inaLists.add(CustomerOrderMou3inaList);
    }



    public void addMou3ina(CustomerOrderMou3inaList customerOrderMou3inaList) {
        this.CustomerOrderMou3inaLists.add(customerOrderMou3inaList);
    }

	
	
	public CustomerReservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerReservation(long id, Timestamp operationDate, Date desiredDate, @Min(1) Integer numberOfMou3ina,
			Double rate, Date desiredHour, Integer gradeAverage, boolean morning, boolean afternoon, boolean evening,
			@Size(max = 200, message = "PaymentStatus must have characters long") String paymentStatus,
			Collection<ServiceType> serviceTypes, Customer customer, StatusReservation statuscode, boolean isRecurrent,
			Set<Recurrentreservation> recurrents, Integer frequency,
			Set<CustomerOrderMou3inaList> customerOrderMou3inaLists) {
		super();
		this.id = id;
		this.operationDate = operationDate;
		this.desiredDate = desiredDate;
		this.numberOfMou3ina = numberOfMou3ina;
		this.rate = rate;
		this.desiredHour = desiredHour;
		this.gradeAverage = gradeAverage;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.paymentStatus = paymentStatus;
		this.serviceTypes = serviceTypes;
		this.customer = customer;
		this.statuscode = statuscode;
		this.isRecurrent = isRecurrent;
		this.recurrents = recurrents;
		this.frequency = frequency;
		CustomerOrderMou3inaLists = customerOrderMou3inaLists;
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

	public Collection<ServiceType> getServiceTypes() {
		return serviceTypes;
	}

	public void setServiceTypes(Collection<ServiceType> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public StatusReservation getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(StatusReservation statuscode) {
		this.statuscode = statuscode;
	}

	public boolean isRecurrent() {
		return isRecurrent;
	}

	public void setRecurrent(boolean isRecurrent) {
		this.isRecurrent = isRecurrent;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}



    

    

   
    




}
