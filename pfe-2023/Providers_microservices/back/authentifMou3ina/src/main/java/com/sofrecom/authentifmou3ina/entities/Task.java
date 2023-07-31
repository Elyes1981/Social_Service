package com.sofrecom.authentifmou3ina.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task  {
    //private static final long serialVersionUID =1L;

    private	String idMou3ina;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private	Long id;

    private  String title ;
    private	  String note ;
    private	  int isCompleted;
    private  String date ;
    private  String startTime ;
    private  String endTime  ;
    private  int color ;
    private  int remind;
    private  String repeat ;
    public Task() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Task(String idMou3ina, Long id, String title, String note, int isCompleted, String date, String startTime,
                String endTime, int color, int remind, String repeat) {
        super();
        this.idMou3ina = idMou3ina;
        this.id = id;
        this.title = title;
        this.note = note;
        this.isCompleted = isCompleted;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.color = color;
        this.remind = remind;
        this.repeat = repeat;
    }
    public String getIdMou3ina() {
        return idMou3ina;
    }
    public void setIdMou3ina(String idMou3ina) {
        this.idMou3ina = idMou3ina;
    }
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
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public int getIsCompleted() {
        return isCompleted;
    }
    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public int getRemind() {
        return remind;
    }
    public void setRemind(int remind) {
        this.remind = remind;
    }
    public String getRepeat() {
        return repeat;
    }
    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }


}
