package com.sofrecom.authentifmou3ina.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Interview {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    //@Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date DateInterview;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern="HH:mm")
    @Column(name = "desiredHour")
    private Date desiredHour;

    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.STRING)
    private InterviewState state;

    @ManyToOne()
    Mou3inaEntity mou3inaInterview ;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateInterview() {
        return DateInterview;
    }

    public void setDateInterview(Date dateInterview) {
        DateInterview = dateInterview;
    }

    public Date getDesiredHour() {
        return desiredHour;
    }

    public void setDesiredHour(Date desiredHour) {
        this.desiredHour = desiredHour;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Mou3inaEntity getMou3inaInterview() {
        return mou3inaInterview;
    }

    public InterviewState getState() {
        return state;
    }


    public void setState(InterviewState state) {
        this.state = state;
    }

    public void setMou3inaInterview(Mou3inaEntity mou3inaInterview) {
        this.mou3inaInterview = mou3inaInterview;
    }

    public Interview(Long id, Date dateInterview,Date desiredHour, String comment, Mou3inaEntity mou3inaInterview, InterviewState state) {
        this.id = id;
        DateInterview = dateInterview;
        desiredHour = desiredHour ;
        this.comment = comment;
        this.mou3inaInterview = mou3inaInterview;
        this.state= state;
    }

    public Interview(){

        super();
    }
}
