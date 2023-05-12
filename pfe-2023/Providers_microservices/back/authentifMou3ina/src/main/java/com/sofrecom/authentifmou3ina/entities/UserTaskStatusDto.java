package com.sofrecom.authentifmou3ina.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserTaskStatusDto {

    private String IdUserTask ;

    private String userTaskName;

    private String profileName;

    private String candidateUser;

    private boolean authorized;

    private String startTime;

    private String endTime;


    private String rejectReasonMotif;

    private String rejectReasonComment;
    @JsonIgnore
    private String deleteReason;

    private Boolean decision;
    private String reasonComment;

    public String getUserTaskName() {
        return userTaskName;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getCandidateUser() {
        return candidateUser;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getRejectReasonMotif() {
        return rejectReasonMotif;
    }

    public String getRejectReasonComment() {
        return rejectReasonComment;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public Boolean getDecision() {
        return decision;
    }

    public String getReasonComment() {
        return reasonComment;
    }

    public void setUserTaskName(String userTaskName) {
        this.userTaskName = userTaskName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setCandidateUser(String candidateUser) {
        this.candidateUser = candidateUser;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setRejectReasonMotif(String rejectReasonMotif) {
        this.rejectReasonMotif = rejectReasonMotif;
    }

    public void setRejectReasonComment(String rejectReasonComment) {
        this.rejectReasonComment = rejectReasonComment;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }

    public void setDecision(Boolean decision) {
        this.decision = decision;
    }

    public void setReasonComment(String reasonComment) {
        this.reasonComment = reasonComment;
    }

    public String getIdUserTask() {
        return IdUserTask;
    }

    public void setIdUserTask(String idUserTask) {
        IdUserTask = idUserTask;
    }

    public UserTaskStatusDto(String userTaskName, String profileName, String candidateUser, boolean authorized, String startTime, String endTime, String rejectReasonMotif, String rejectReasonComment, String deleteReason, Boolean decision, String reasonComment , String IdUserTask) {
        this.userTaskName = userTaskName;
        this.profileName = profileName;
        this.candidateUser = candidateUser;
        this.authorized = authorized;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rejectReasonMotif = rejectReasonMotif;
        this.rejectReasonComment = rejectReasonComment;
        this.deleteReason = deleteReason;
        this.decision = decision;
        this.reasonComment = reasonComment;
        this.IdUserTask= IdUserTask ;
    }

    public UserTaskStatusDto(){
        super();
    }
}
