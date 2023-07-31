package com.sofrecom.operation.customer.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Weekend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne()
    private Mou3inaEntity Mou3inaEntity;

    public Weekend(Long id, Mou3inaEntity mou3inaEntity, LocalDate date) {
        super();
        this.id = id;
        Mou3inaEntity = mou3inaEntity;
        this.date = date;
    }

    public Mou3inaEntity getMou3inaEntity() {
        return Mou3inaEntity;
    }

    public void setMou3inaEntity(Mou3inaEntity mou3inaEntity) {
        Mou3inaEntity = mou3inaEntity;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_at;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Weekend() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Weekend other = (Weekend) obj;
        return Objects.equals(date, other.date);
    }

}
