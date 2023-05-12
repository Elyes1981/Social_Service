package com.sofrecom.authentifmou3ina.controller;

import com.sofrecom.authentifmou3ina.entities.TrialPeriod;
import com.sofrecom.authentifmou3ina.services.ITrialPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TrialPeriodeController {

    @Autowired
    ITrialPeriodService trialPeriodService;

    @GetMapping(value = "/TrialPeriod/{id}")
    public TrialPeriod findById(@PathVariable Long id) {
        return trialPeriodService.findTrialPeriod(id);
    }


    @PostMapping(value = "/TrialPeriod/newTrialPeriod/{id}")
    public TrialPeriod addTrialPeriod(@PathVariable Long id,@RequestBody TrialPeriod m) {
        return trialPeriodService.addTrialPeriod(id,m);


    }

    @PutMapping(value = "/TrialPeriod/TrialPeriod/{id}")
    public TrialPeriod updateTrialPeriod(@PathVariable Long id, @RequestBody TrialPeriod p) {
        p.setId(id);
        return trialPeriodService.updateTrialPeriod(p);
    }

    @DeleteMapping(value = "/deleteTrialPeriod/{id}")
    public void deleteTrialPeriod(@PathVariable Long id) {
        trialPeriodService.deleteTrialPeriod(id);
    }
}
