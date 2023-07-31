package com.sofrecom.operation.customer.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;


@Data
@Entity(name="CustomerReservation")
public class CustomerReservation implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    public Long id;

    @CreationTimestamp
    @Column(name = "operationDate")
    private Timestamp operationDate;

    @Column(name = "desiredDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date desiredDate;

    @Min(1)
    @Column(name = "numberOfMou3ina")
    private Integer numberOfMou3ina;

    private  Double rate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern="HH:mm")
    @Column(name = "desiredHour")
    private Date desiredHour;


    @Column(name = "gradeAverage")
    private Integer gradeAverage;

    @Column(name = "process_instance_id")
    private String  processInstanceID;

    @Column(name = "morning")
    private boolean morning;


    @Column(name = "afternoon")
    private boolean afternoon;

    @Column(name = "evening")
    private boolean evening;



    @Column(name = "totalCost")
    private Double  totalCost;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Mou3inaEntity> providers;


    @Column(name = "paymentStatus")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
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

    @JsonIgnore
    @OneToMany(mappedBy = "customerReservation", cascade = CascadeType.ALL)
    private List<Distance> distances; // List of distance entries for providers and customers

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







    public CustomerReservation() {
        super();
        // TODO Auto-generated constructor stub
        //providers = new ArrayList<>();
    }

    public CustomerReservation(long id, Timestamp operationDate, Date desiredDate, @Min(1) Integer numberOfMou3ina,
                               Double rate, Date desiredHour, Integer gradeAverage, boolean morning, boolean afternoon, boolean evening,
                               PaymentStatus paymentStatus,
                               Collection<ServiceType> serviceTypes, Customer customer, StatusReservation statuscode, boolean isRecurrent,
                               Set<Recurrentreservation> recurrents, Integer frequency,
                               /*Set<CustomerOrderMou3inaList> customerOrderMou3inaLists ,*/List<Mou3inaEntity> providers,Double TotalCost,ReservationStatus status, String processInstanceID) {
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
        this.processInstanceID = processInstanceID;
        //CustomerOrderMou3inaLists = customerOrderMou3inaLists;
        providers = providers;
        this.status=status;
        this.totalCost=TotalCost ;
    }

    public CustomerReservation(Long id, List<Mou3inaEntity> providers) {
        this.id = id;
        providers = providers;
    }




}
