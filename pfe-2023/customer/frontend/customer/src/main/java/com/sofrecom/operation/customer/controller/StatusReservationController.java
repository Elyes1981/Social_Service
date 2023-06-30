package com.sofrecom.operation.customer.controller;



import com.sofrecom.operation.customer.entities.StatusReservation;
import com.sofrecom.operation.customer.service.IStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StatusReservationController {
    @Autowired
    IStatus iStatus;

    @RequestMapping(value = "/statusReservation", method = RequestMethod.GET)
    public List<StatusReservation> findStatusReservation() {
        return iStatus.findAll();
    }

    @GetMapping(value = "/statusReservation/{id}")
    public StatusReservation findOneStatusReservationById(@PathVariable Long id) {
        return iStatus.findStatus(id);
    }


    @PostMapping(value ="/statusReservation")
    public StatusReservation addStatusReservation(@RequestBody StatusReservation m) {return iStatus.addStatus(m);}


    @PutMapping(value = "/statusReservation/{code}")
    public StatusReservation updateStatusReservation(@PathVariable Long code, @RequestBody StatusReservation p) {
        p.setCode(code);
        return iStatus.updateStatus(p);
    }

    @DeleteMapping(value = "/statusReservation/{code}")
    public void deleteStatusReservation(@PathVariable Long code) {
        iStatus.deleteStatus(code);
    }



}
