package com.sofrecom.operation.customer.controller;


import com.sofrecom.operation.customer.dao.Mou3inaRepository;
import com.sofrecom.operation.customer.entities.Mou3inaEntity;
import com.sofrecom.operation.customer.service.Imou3inaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Mou3inaRestController {
    @Autowired
    Imou3inaService mou3inaService;
    @Autowired Mou3inaRepository mou3inaRepository;
    public static final String DIRECTORY =  "C://Users/a.mosbah/Downloads/operation-admin-fe-master/operation-admin-fe-master/src/assets/img";

    @GetMapping(value = "/Mou3inas")
    public ResponseEntity<Object> findMou3iness() {
        return (ResponseEntity<Object>) mou3inaService.findAll();
    }


    @GetMapping(value = "/Mou3ina/{id}")
    public Mou3inaEntity findOneMou3inaById(@PathVariable Long id) {
        return mou3inaService.findMou3ina(id);
    }

    @PutMapping(value = "/Mou3inas/Mou3ina/{id}")
    public Mou3inaEntity updateMou3ina(@PathVariable Long id, @RequestBody Mou3inaEntity p) {
        p.setId(id);
        return mou3inaService.updateMou3ina(p);
    }

    @PostMapping(value = "/Mou3ina/newMou3ina")
    public Mou3inaEntity addMou3ina(@RequestBody Mou3inaEntity m) {
        return mou3inaService.addMou3ina(m);
    }



    @DeleteMapping(value = "/deleteMou3inas/{id}")
    public void deleteMou3ina(@PathVariable Long id) {
        mou3inaService.deleteMou3ina(id);
    }


    @GetMapping(value = "/Mou3inas/search")
    public List<Mou3inaEntity> findByServicesTypes(
            @RequestParam List<String> ids) {
        return mou3inaService.findByServicesTypes(ids);
    }


}
