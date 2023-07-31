package com.sofrecom.authentifmou3ina.controller;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.Reclamation;
import com.sofrecom.authentifmou3ina.entities.ReclamationStatus;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.repository.ReclamationRepository;
import com.sofrecom.authentifmou3ina.services.ICleaningCompanyService;
import com.sofrecom.authentifmou3ina.services.IReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ReclamationController {
    @Autowired
    IReclamationService ireclamationService;

    @Autowired
    ReclamationRepository reclamationRepository ;

    @Autowired
    ICleaningCompanyService iCleaningCompanyService;

    @Autowired
    Mou3inaRepository mou3inaRepository;
    @RequestMapping(value = "/Reclamations", method = RequestMethod.GET)
    public List<Reclamation> findReclamations() {
        return ireclamationService.findAll();
    }
    @GetMapping(value = "/Reclamation/{id}")
    public Reclamation findOneReclamationById(@PathVariable Long id) {
        return ireclamationService.findRerclamation(id);
    }
    @PostMapping(value = "/Reclamation/newReclamation/{id}")
    public Reclamation addReclamation(@PathVariable Long id,@RequestBody Reclamation m) {
        Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
        m.setReclamationStatus(ReclamationStatus.In_progress);
        m.setProvider(mouina);
        return ireclamationService.addRerclamation(m);
    }
    @PutMapping(value = "/Reclamations/Reclamation/{id}")
    public Reclamation updateReclamation(@PathVariable Long id, @RequestBody Reclamation p) {
        Reclamation reclamation=(Reclamation) reclamationRepository.findById(id).get();
        p.setProvider(reclamation.getProvider());
        p.setReclamationStatus(reclamation.getReclamationStatus());
        p.setIdReclamation(id);
        return ireclamationService.updateRerclamation(p);
    }

    @DeleteMapping(value = "/deleteReclamation/{id}")
    public void deleteReclamation(@PathVariable Long id) {
        ireclamationService.deleteRerclamation(id);
    }

    @GetMapping(value = "/ProviderReclamations/{id}")
    public List<Reclamation> getReclamationsByProvider(@PathVariable Long id) {
        Mou3inaEntity provider=(Mou3inaEntity) mou3inaRepository.findById(id).get();
        return reclamationRepository.findByProvider(provider);
    }

    @GetMapping(value = "/ProvidersCompanyReclamations/{companyId}")
    public List<Reclamation> getReclamationsCompany(@PathVariable Long companyId) {
        List<Reclamation> reclamations = new ArrayList<>();

        Set<Mou3inaEntity> providers = iCleaningCompanyService.getMou3inaListByCompanyId(companyId);
        for (Mou3inaEntity provider : providers) {
            List<Reclamation> providerReclamations = reclamationRepository.findByProvider(provider);
            reclamations.addAll(providerReclamations);
        }

        return reclamations;
    }






}

