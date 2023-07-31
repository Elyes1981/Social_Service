package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.dao.CustomerOrderMou3inaListRepository;
import com.sofrecom.operation.customer.dao.Mou3inaRepository;
import com.sofrecom.operation.customer.dto.Mou3inaEntityDTO;
import com.sofrecom.operation.customer.entities.Mou3inaEntity;
import com.sofrecom.operation.customer.service.Imou3inaService;
import com.sofrecom.operation.customer.util.FeignServiceUtil;
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

    @Autowired
    CustomerOrderMou3inaListRepository customerOrderMou3inaListRepository;


    @Autowired
    FeignServiceUtil feignServiceUtil;

    public static final String DIRECTORY =  "C://Users/a.mosbah/Downloads/operation-admin-fe-master/operation-admin-fe-master/src/assets/img";

    @GetMapping(value = "/Mou3inas")
    public ResponseEntity<Object> findMou3iness() {
        return (ResponseEntity<Object>) mou3inaService.findAll();
    }

    @RequestMapping(value = "/providers" , method = RequestMethod.GET) //RequestMapping
    List<Mou3inaEntityDTO> findProviders(){
        return  feignServiceUtil.findMou3iness();

    }

   /* @RequestMapping(value = "/providers" , method = RequestMethod.GET) //RequestMapping
    public void updateServicesDoneForCurrentMonth() {
        // Récupérer toutes les Mou3inaEntity
        List<Mou3inaEntity> mou3inaList = mou3inaRepository.findAll();

        // Obtenir la date du premier jour du mois courant
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = calendar.getTime();

        for (Mou3inaEntity mou3ina : mou3inaList) {
            // Récupérer toutes les CustomerOrderMou3inaList associées à la Mou3inaEntity pour le mois courant
            List<CustomerOrderMou3inaList> ordersForCurrentMonth = customerOrderMou3inaListRepository.findByMou3inaAndOrderDayGreaterThanEqual(
                    mou3ina, firstDayOfMonth);

            // Mettre à jour le nombre de servicesDone avec le nombre de CustomerOrderMou3inaList du mois courant
            int servicesDoneForCurrentMonth = ordersForCurrentMonth.size();
            mou3ina.setServicesDone(servicesDoneForCurrentMonth);

            // Sauvegarder les changements dans la base de données
            mou3inaRepository.save(mou3ina);
        }
    }*/



    @RequestMapping(value = "/tet" , method = RequestMethod.GET) //RequestMapping
    String test(){
        return  feignServiceUtil.test();
    }

    /*@PostMapping(value = "/Mou3ina/newMou3ina")
    public String addMou3ina() {
        List<Mou3inaEntityDTO> providers = feignServiceUtil.findMou3iness();

        for (Mou3inaEntityDTO prov : providers) {
            // Vérifier si le fournisseur existe déjà dans la table Mou3inaEntity
            Optional<Mou3inaEntity> existingProvider = mou3inaRepository.findById(prov.getId());

            if (existingProvider == null) {
                // Le fournisseur n'existe pas, créer un nouvel objet Mou3inaEntity à partir des données du fournisseur DTO
                Mou3inaEntity newProvider = new Mou3inaEntity();
                newProvider.setId(prov.getId());
                newProvider.setFirstName(prov.getFirstName());
                newProvider.setLastName(prov.getLastName());
                newProvider.setPhone(prov.getPhone());
                newProvider.setDocumentIdType(prov.getDocumentIdType());
                newProvider.setPhone2(prov.getPhone2());
                newProvider.setHome_Adress(prov.getHome_Adress());
                newProvider.setHome_Adress_GPS_long(prov.getHome_Adress_GPS_long());
                newProvider.setHome_Adress_GPS_latt(prov.getHome_Adress_GPS_latt());
                newProvider.setCollaborationStatus(prov.getCollaborationStatus());
                newProvider.setInscriptionStatus(prov.getInscriptionStatus());
                newProvider.setVideo(prov.getVideo());
                newProvider.setEmailAdress(prov.getEmailAdress());
                newProvider.setGradeAverage(prov.getGradeAverage());
                newProvider.setHasASmartPhone(prov.getHasASmartPhone());
                newProvider.setPhoto(prov.getPhoto());
                newProvider.setName(prov.getName());
                newProvider.setImage(prov.getImage());
                newProvider.setCopie(prov.getCopie());
                newProvider.setNbServicesDone(prov.getNbServicesDone());
                newProvider.setNbfavoris(prov.getNbfavoris());
                newProvider.setSalary(prov.getSalary());
                newProvider.setMorningCost(prov.getMorningCost());
                newProvider.setEveningCost(prov.getEveningCost());
                newProvider.setAfternoonCost(prov.getAfternoonCost());
                newProvider.setDevice(prov.getDevice());
                // Sauvegarder le nouveau fournisseur dans la table Mou3inaEntity
                mou3inaRepository.save(newProvider);
            }
        }
        return "mou3ina added";
    }*/


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





}
