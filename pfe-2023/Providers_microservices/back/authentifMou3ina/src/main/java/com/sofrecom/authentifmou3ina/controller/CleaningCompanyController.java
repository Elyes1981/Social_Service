package com.sofrecom.authentifmou3ina.controller;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.services.ICleaningCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CleaningCompanyController {

    @Autowired
    ICleaningCompanyService iCleaningCompanyService;
    @RequestMapping(value = "/CleaningCompanies", method = RequestMethod.GET)
    public List<CleaningServicesCompany> findCleaningServicesCompany() {
        return iCleaningCompanyService.findAll();
    }
    @GetMapping(value = "/CleaningCompany/{id}")
    public CleaningServicesCompany findOneCleaningCompanyById(@PathVariable Long id) {
        return iCleaningCompanyService.findCleaningCompany(id);
    }
    @PostMapping(value = "/CleaningCompany/newCleaningCompany")
    public CleaningServicesCompany addCleaningCompany(@RequestBody CleaningServicesCompany m) {
        return iCleaningCompanyService.addCleaningCompany(m);
    }
    @PutMapping(value = "/CleaningCompanys/CleaningCompany/{id}")
    public CleaningServicesCompany updateCleaningCompany(@PathVariable Long id, @RequestBody CleaningServicesCompany p) {
        p.setId(id);
        return iCleaningCompanyService.updateCleaningCompany(p);
    }

    @DeleteMapping(value = "/deleteCleaningCompany/{id}")
    public void deleteCleaningCompany(@PathVariable Long id) {
        iCleaningCompanyService.deleteCleaningCompany(id);
    }

    @PostMapping(value = "/AddProviderToCompany/{id}")
    public void addMou3inaToCompany(@PathVariable Long id,  @RequestBody Mou3inaEntity mou3ina) {
         iCleaningCompanyService.addMou3inaToCompany(id, mou3ina);
    }

    @GetMapping(value = "/ListProvidersCompany/{id}")
    public List<Mou3inaEntity> getMou3inaByCompanyId(@PathVariable("id") Long companyId) {
        return iCleaningCompanyService.getMou3inaListByCompanyId(companyId);
    }



}
