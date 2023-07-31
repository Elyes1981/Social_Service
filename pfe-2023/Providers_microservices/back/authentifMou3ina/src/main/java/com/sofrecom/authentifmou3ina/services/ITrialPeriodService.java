package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.TrialPeriod;

public interface ITrialPeriodService {

    public TrialPeriod addTrialPeriod(Long id ,TrialPeriod m);


    public void deleteTrialPeriod(Long id);

    public TrialPeriod  updateTrialPeriod(TrialPeriod m);

    public TrialPeriod  findTrialPeriod (Long id);

    public TrialPeriod  findByMou3inaInterviewId (Long id);


}
