package com.sofrecom.authentifmou3ina.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;

@Entity
public class AvailibilitiesMou3ina {

	private static final long serialVersionUID =1L;
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id")
	private Long id;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date created_at;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	private boolean morning;

	private boolean evening;

	private boolean afternoon;


	@ManyToOne()
	private Mou3inaEntity Mou3inaEntity;



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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}



	public Mou3inaEntity getMou3inaEntity() {
		return Mou3inaEntity;
	}

	public void setMou3inaEntity(Mou3inaEntity mou3inaEntity) {
		Mou3inaEntity = mou3inaEntity;
	}

	public boolean isMorning() {
		return morning;
	}

	public void setMorning(boolean morning) {
		this.morning = morning;
	}

	public boolean isEvening() {
		return evening;
	}

	public void setEvening(boolean evening) {
		this.evening = evening;
	}

	public boolean isAfternoon() {
		return afternoon;
	}

	public void setAfternoon(boolean afternoon) {
		this.afternoon = afternoon;
	}



	public AvailibilitiesMou3ina() {
	}
/*	public AvailibilitiesMou3ina(Long id, Date created_at, LocalDate date, boolean morning, boolean evening, boolean afternoon, Mou3inaEntity mou3inaEntity) {
		this.id = id;
		this.created_at = created_at;
		this.date = date;
		this.morning = morning;
		this.evening = evening;
		this.afternoon = afternoon;
		Mou3inaEntity = mou3inaEntity;
	}*/

	public AvailibilitiesMou3ina(Long id, Date created_at, LocalDate date, boolean morning, boolean evening, boolean afternoon, Mou3inaEntity mou3inaEntity) {
		this.id = id;
		this.created_at = created_at;
		this.date = date;
		this.morning = morning;
		this.evening = evening;
		this.afternoon = afternoon;
		Mou3inaEntity = mou3inaEntity;
	}
}
