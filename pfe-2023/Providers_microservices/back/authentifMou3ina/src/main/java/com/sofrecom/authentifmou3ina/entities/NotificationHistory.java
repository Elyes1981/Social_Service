package com.sofrecom.authentifmou3ina.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NotificationHistory {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String title;
    private String body;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

    private Date createdAt;
    private String Token ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }


    public NotificationHistory(Long id, String title, String body, Date createdAt, String token) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        Token = token;
    }

    public NotificationHistory(){

        super();
    }
}
