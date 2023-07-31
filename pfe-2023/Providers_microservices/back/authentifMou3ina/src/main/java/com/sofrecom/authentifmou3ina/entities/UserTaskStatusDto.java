package com.sofrecom.authentifmou3ina.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserTaskStatusDto {


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
}
