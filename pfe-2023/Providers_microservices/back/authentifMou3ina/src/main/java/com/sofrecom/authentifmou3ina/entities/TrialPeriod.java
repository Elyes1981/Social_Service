package com.sofrecom.authentifmou3ina.entities;

import javax.persistence.*;

@Entity
public class TrialPeriod {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private InterviewState state ;

    @ManyToOne()
    Mou3inaEntity mou3inaInterview ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InterviewState getState() {
        return state;
    }

    public void setState(InterviewState state) {
        this.state = state;
    }

    public Mou3inaEntity getMou3inaInterview() {
        return mou3inaInterview;
    }

    public void setMou3inaInterview(Mou3inaEntity mou3inaInterview) {
        this.mou3inaInterview = mou3inaInterview;
    }

    public TrialPeriod(Long id, InterviewState state, Mou3inaEntity mou3inaInterview) {
        this.id = id;
        this.state = state;
        this.mou3inaInterview = mou3inaInterview;
    }

    public TrialPeriod(){

        super();
    }
}
