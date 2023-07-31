package com.sofrecom.authentifmou3ina.controller;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.repository.CleaningCompanyRepository;
import com.sofrecom.authentifmou3ina.services.ICleaningCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CleaningCompanyController {

    public static final String DIRECTORYPhoto ="C://DATA/provider_services_front/operation/src/assets/companiesLogo/" + "";


    @Autowired
    ICleaningCompanyService iCleaningCompanyService;


    @Autowired
    CleaningCompanyRepository cleaningCompanyRepository;
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
    public Set<Mou3inaEntity> getMou3inaByCompanyId(@PathVariable("id") Long companyId) {
        return iCleaningCompanyService.getMou3inaListByCompanyId(companyId);
    }


    @GetMapping(value = "/ListOwnersCompany/{id}")
    public ResponseEntity<Object> getOwnersByCompanyId(@PathVariable("id") Long companyId) {
        return iCleaningCompanyService.getOwnersListByCompanyId(companyId);
    }

    @PostMapping(value = "/uploadLogo/{id}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public ResponseEntity<List<String>> uploadFile(@PathVariable("id") Long id,  @RequestParam("logo") List<MultipartFile> logo) throws IOException, InterruptedException{
        List<String> filenames = new ArrayList<>();
        for(MultipartFile file : logo) {
            byte[] fileContent = file.getBytes();
            Path path = Paths.get(DIRECTORYPhoto + id + ".png");
            Files.write(path, fileContent);
            cleaningCompanyRepository.updateLogoPath(id, DIRECTORYPhoto + id + ".png");
        }
        return ResponseEntity.ok().body(filenames);
    }

    @GetMapping("/{companyID}")
    public ResponseEntity<?> getCompanyById(@PathVariable String companyID) {
        CleaningServicesCompany company = cleaningCompanyRepository.findByCompanyID(companyID);
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
