package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.dao.Mou3inaRepository;
import com.sofrecom.operation.customer.dao.RecurentReservationRepository;
import com.sofrecom.operation.customer.entities.*;
import com.sofrecom.operation.customer.service.Imou3inaService;
import com.sofrecom.operation.customer.service.recurentReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/recurent")
public class RecurrentReservationController {


    @Autowired
    recurentReservationService recurentS;

    @GetMapping()
    public List<Recurrentreservation> findAllRecurrent() {
        return recurentS.findAll();
    }


    @GetMapping(value = "{id}")
    public Recurrentreservation findRecurrentById(@PathVariable Long id) {
        return recurentS.findRecurrent(id);
    }


    @GetMapping(value = "/recurent/{id}")
    public Recurrentreservation findOneRecurentById(@PathVariable Long id) {
        return recurentS.findRecurrent(id);
    }



    @PostMapping( )
    public Recurrentreservation addRecurrent(@RequestBody Recurrentreservation r) {



        return recurentS.addRecurrent(r);
    }



    @DeleteMapping(value = "/deleterecurent/{id}")
    public void deleterecurentS(@PathVariable Long id) {
        recurentS.deleteRecurrent(id);
    }


}
