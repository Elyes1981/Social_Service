package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Gender;
import com.sofrecom.authentifmou3ina.entities.Interview;
import com.sofrecom.authentifmou3ina.entities.InterviewState;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;

import java.util.List;

public interface InterviewService {

    public Interview addInterview(Long id,Interview m);


    public void deleteInterview(Long id);

    public Interview  updateInterview (Interview m);

    public Interview  findInterview(Long id);



    public List<Interview> findAll();

    public Interview acceptProvider(Long id);

    public Interview rejectProvider(Long id);

    public Interview Evaluate (Long id , InterviewState state);



}
