package com.sofrecom.authentifmou3ina.entities;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReclamation;

    @Column(name = "message")
    String message;
    @Enumerated(EnumType.STRING)
    private ReclamationStatus reclamationStatus;

    @Column(name = "status")
    String status;

    @ManyToOne
    Mou3inaEntity provider ;
    public Reclamation() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Reclamation(Long idReclamation, Mou3inaEntity provider,  String message, ReclamationStatus reclamationStatus , String status) {
        super();
        this.idReclamation = idReclamation;
        this.provider=provider;
        this.message = message;
        this.reclamationStatus = reclamationStatus;
        this.status=status;
    }
    public Long getIdReclamation() {
        return idReclamation;
    }
    public void setIdReclamation(Long idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public ReclamationStatus getReclamationStatus() {
        return reclamationStatus;
    }

    public void setReclamationStatus(ReclamationStatus reclamationStatus) {
        this.reclamationStatus = reclamationStatus;
    }

    public Mou3inaEntity getProvider() {
        return provider;
    }

    public void setProvider(Mou3inaEntity provider) {
        this.provider = provider;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}