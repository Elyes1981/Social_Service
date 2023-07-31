package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.dao.*;
import com.sofrecom.operation.customer.dto.CleaningServicesCompanyDTO;
import com.sofrecom.operation.customer.dto.Mou3inaEntityDTO;
import com.sofrecom.operation.customer.entities.*;
import com.sofrecom.operation.customer.service.ICustomerReservation;
import com.sofrecom.operation.customer.service.Imou3inaService;
import com.sofrecom.operation.customer.util.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/CustomerReservations")

public class CustomerReservationcontroller {


    @Autowired
    ICustomerReservation iCustomerReservation;

    @Autowired
    CustomerReservationRepository customerReservationRepository;

    @Autowired
    FeignServiceUtil feignServiceUtil;

    @Autowired
    private Mapper mapper;

    @Autowired
    CustomerRepository customerRepository;

   /* @Autowired
    StatusReservationRepository statusReservationRepository;
*/

    @Autowired
    Mou3inaRepository mou3inaRepository ;

    @Autowired
    private CustomerReservationRepository reservationRepository;

    @Autowired
    private DistanceRepository distanceRepository;
    @Autowired
    private CustomerOrderMou3inaListRepository customerOrderMou3inaListRepository;
    @Autowired
    Imou3inaService Imou3inaService;
    @GetMapping(" ")
    public List<CustomerReservation> getAllCustomerReservations(){
        List <CustomerReservation> CustomerReservations = iCustomerReservation.findAll();
        return CustomerReservations;
    }
    @GetMapping("Reservations")
    public List<CustomerReservation> getAllReservations(){
        List <CustomerReservation> CustomerReservations = iCustomerReservation.findAll();
        return CustomerReservations;
    }
    @GetMapping("/orders")
    public List<CustomerOrderMou3inaList> getAllCustomerReservationsmou3ina(){
        List <CustomerOrderMou3inaList> CustomerReservationOrders = customerOrderMou3inaListRepository.findAll();
        return CustomerReservationOrders;
    }

    @GetMapping(value = "/numberOrders")
    public Long findnumberOrders() {
        return (long) iCustomerReservation.findAll().size();
    }

    @GetMapping("/ListCustomerOrderMou3inaListByCustomerReservation/{id}")
    public List<CustomerOrderMou3inaList> getOrderMou3inaListByCustomerReservation(@PathVariable Long id) {
        CustomerReservation customerReservation = customerReservationRepository.findById(id).get();
        return customerOrderMou3inaListRepository.findByCustomerReservation(customerReservation);

    }

    @RequestMapping(value = "/reservationsByAgentMonthYear/{year}", method = RequestMethod.GET)
    public List<Object[]> finReservationsYear(@PathVariable long year) {
        return iCustomerReservation.findReservationYear(year);
    }
    
    @PostMapping(" ")
    public CustomerReservation createCustomerReservation(@RequestBody CustomerReservation CustomerReservation) {
        Set<Recurrentreservation> reccurents= new HashSet<Recurrentreservation>();
        CustomerReservation.getRecurrents().forEach(r ->{
            r.setCustomerReservation(CustomerReservation);
        });
        return iCustomerReservation.add(CustomerReservation);
    }




    @PostMapping("/addReservationCustomer/{id}")
    public CustomerReservation  addReservationCustomer(@PathVariable Long id ,@RequestBody CustomerReservation customerReservation) {
        //StatusReservation statusReservation = statusReservationRepository.findByStatus_en("in progress");
        //customerReservation.setStatuscode(statusReservation);
        Customer customer = (Customer) customerRepository.findById(id).get();
        customerReservation.setStatus(ReservationStatus.PENDING);
        customerReservation.setPaymentStatus(PaymentStatus.Unpaid);
        customerReservation.setCustomer(customer);
        customerReservation.setRate(1.0);
        iCustomerReservation.add(customerReservation);
        double cost = 0;

        for (Mou3inaEntity provider : customerReservation.getProviders()) {
            CustomerOrderMou3inaList customerOrder = new CustomerOrderMou3inaList();
            customerOrder.setOrderDay(customerReservation.getDesiredDate());
            customerOrder.setRank(1); // Remplacez cela par le classement approprié en fonction des préférences du client
            customerOrder.setMou3ina(provider);
            //provider.setServicesDone(provider.getServicesDone()+1) ;
            //feignServiceUtil.incrementServicesDone(provider.id);
            //provider.setNbServicesDone(provider.getNbServicesDone().intValue() + 1);
            customerOrder.setCustomerReservation(customerReservation);

            if (customerReservation.isMorning() && !customerReservation.isAfternoon() && !customerReservation.isEvening()) {
                cost = provider.getMorningCost();
            } else if (!customerReservation.isMorning() && customerReservation.isAfternoon() && !customerReservation.isEvening()) {
                cost = provider.getAfternoonCost();
            } else if (!customerReservation.isMorning() && !customerReservation.isAfternoon() && customerReservation.isEvening()) {
                cost = provider.getEveningCost();
            } else if (customerReservation.isMorning() && customerReservation.isAfternoon() && !customerReservation.isEvening()) {
                cost = provider.getMorningCost() + provider.getAfternoonCost();
            } else if (customerReservation.isMorning() && !customerReservation.isAfternoon() && customerReservation.isEvening()) {
                cost = provider.getMorningCost() + provider.getEveningCost();
            } else if (!customerReservation.isMorning() && customerReservation.isAfternoon() && customerReservation.isEvening()) {
                cost = provider.getAfternoonCost() + provider.getEveningCost();
            } else if (customerReservation.isMorning() && customerReservation.isAfternoon() && customerReservation.isEvening()) {
                cost = provider.getMorningCost() + provider.getAfternoonCost() + provider.getEveningCost();
            }
            ////distance///
            Double latProvider = (double) provider.getHome_Adress_GPS_latt();   //35,8446
            Double lonProvider = (double) provider.getHome_Adress_GPS_long();   //10,6191
            Double latCustomer = (double) customer.getHome_Adress_GPS_latt();  //35,8403
            Double lonCustomer = (double) customer.getHome_Adress_GPS_long();   //10,5943
            // Convertir les coordonnées en radians
            Double radLat1 = Math.toRadians(latProvider);
            Double radLon1 = Math.toRadians(lonProvider);
            Double radLat2 = Math.toRadians(latCustomer);
            Double radLon2 = Math.toRadians(lonCustomer);

            // Calculer la différence de longitude et de latitude
            Double diffLon = radLon2 - radLon1;
            Double diffLat = radLat2 - radLat1;

            // Appliquer la formule de la distance entre deux points GPS
            Double a = Math.sin(diffLat / 2) * Math.sin(diffLat / 2) +
                    Math.cos(radLat1) * Math.cos(radLat2) *
                            Math.sin(diffLon / 2) * Math.sin(diffLon / 2);
            Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            Double distance = 6371 * c; // Rayon de la Terre en kilomètres



            Distance distanceProvCustomer = new Distance();
            distanceProvCustomer.setCustomerReservation(customerReservation);
            distanceProvCustomer.setDistance(distance);
            distanceProvCustomer.setProvider(provider);
            distanceProvCustomer.setCustomer(customer);
            distanceRepository.save(distanceProvCustomer);
            cost += Math.ceil(distance) * 1;
            ///

            customerOrder.setServiceCost(cost);
            customerOrderMou3inaListRepository.save(customerOrder);
            mou3inaRepository.save(provider);

        }
        return  customerReservation;


    }

    /*@PutMapping("/addReservation/{id}")
    public CustomerReservation  createReservation(@PathVariable Long id,@RequestBody List<Long> idProviders) {

        //		Mou3inaEntity mou3ina = mou3inaRepository.findById(id).get();
        CustomerReservation CustomerReservation = customerReservationRepository.findById(id).get();
        //iCustomerReservation.add(CustomerReservation);
        List<Mou3inaEntityDTO> providers = feignServiceUtil.findMou3iness();
        List<Mou3inaEntityDTO> assignedproviders = providers.stream()

                .filter(provider -> idProviders.contains(provider.getId()))

                .collect(Collectors.toList());
        CustomerReservationDTO reservationDTO = mapper.toDto(CustomerReservation);
        CustomerReservationDTO.setProviders(assignedproviders);
        CustomerReservation = mapper.toEntity(reservationDTO);
        customerReservationRepository.save(CustomerReservation);
        return CustomerReservation;
    }*/

        /*@PostMapping("/addReservationProvider")
        public CustomerReservation  createReservationProvider(@RequestBody CustomerReservation customerReservation ) {

            //		Mou3inaEntity mou3ina = mou3inaRepository.findById(id).get();
            //CustomerReservation CustomerReservation =   customerReservationRepository.findById(id).get();
            List<Mou3inaEntityDTO> providers = feignServiceUtil.findMou3iness();
            List<Long> selectedProviderIds = customerReservation.getProviders()
                    .stream()
                    .map(Mou3inaEntity::getId)
                    .collect(Collectors.toList());


            List<Mou3inaEntityDTO> assignedProviders = providers.stream()
                    .filter(provider -> selectedProviderIds.contains(provider.getId()))
                    .collect(Collectors.toList());

            CustomerReservationDTO reservationDTO = mapper.toDto(customerReservation);
            reservationDTO.setProviders(assignedProviders);
            customerReservation =mapper.toEntity(reservationDTO);
            reservationDTO.setProviders(assignedProviders);
            customerReservationRepository.save(customerReservation);
            return customerReservation;

    }*/

    @RequestMapping(value = "/CleaningCompanies" , method = RequestMethod.GET) //RequestMapping
    public List<CleaningServicesCompanyDTO> getCommpanies(){
         List<CleaningServicesCompanyDTO> companies = feignServiceUtil.findCleaningServicesCompany();
         return companies;
    }


    @PostMapping("/insert")
    public void insertProvidersFromOtherMicroservice() {
        // Récupérer la liste des fournisseurs du microservice "providers-services"
        List<Mou3inaEntityDTO> providers = feignServiceUtil.findMou3iness();

        List<Long> existingProviderIds = mou3inaRepository.findAll().stream()
                .map(Mou3inaEntity::getId)
                .collect(Collectors.toList());

        List<Mou3inaEntity> newProviders = providers.stream()
                .filter(provider -> !existingProviderIds.contains(provider.getId()))
                .map(provider -> { Mou3inaEntity entity = mapper.mapMou3inaEntityDtoToEntity(provider);
                            entity.setId(provider.getId());
                            return entity;
                })
                .collect(Collectors.toList());

      /*  // Mapper les fournisseurs récupérés vers l'entité Mou3inaEntity
        List<Mou3inaEntity> mappedProviders = providers.stream()
                .map(provider -> mapper.mapMou3inaEntityDtoToEntity(provider))
                .collect(Collectors.toList());*/

        // Insérer chaque fournisseur dans la table Mou3inaEntity du microservice "customer-services"
        mou3inaRepository.saveAll(newProviders);
    }

    @PostMapping("/search")
    public List<Mou3inaEntity> searchAvailableProviders(@RequestBody CustomerReservation reservation) {
        List<Mou3inaEntity> availableProviders = iCustomerReservation.findAvailableProviders(reservation);
        return availableProviders;
    }

    @PostMapping("/filterProviders/{id}")
    public List<Mou3inaEntity> filterProviders(@PathVariable Long id ,@RequestBody CustomerReservation reservation) {
        List<Mou3inaEntity> availableProviders = iCustomerReservation.filter(id ,reservation);
        return availableProviders;
    }






   @GetMapping("/reservation/{id}/providers")
    public List<Mou3inaEntity> getProvidersByReservationId(@PathVariable Long id) {
        // Récupérer la réservation à partir de l'ID
        CustomerReservation reservation = iCustomerReservation.find(id);

        // Récupérer les fournisseurs associés à la réservation
        List<Mou3inaEntity> providerIds = (List<Mou3inaEntity>) reservation.getProviders();

        // Appeler le microservice "providers-services" pour récupérer les informations des fournisseurs
        /*List<Mou3inaEntityDTO> providers = feignServiceUtil.findMou3iness();

        // Filtrer les fournisseurs en fonction des IDs associés à la réservation
        List<Mou3inaEntityDTO> assignedProviders = providers.stream()
                .filter(provider -> providerIds.contains(provider.getId()))
                .collect(Collectors.toList());*/

        return providerIds;
    }

    @GetMapping("/reservationCost/{id}/providers")
    public ReponseMessage CostReservation(@PathVariable Long id) {
        String str = "";
        double totalCost = 0.0;

        // Récupérer la réservation à partir de l'ID
        CustomerReservation reservation = iCustomerReservation.find(id);

        // Récupérer les fournisseurs associés à la réservation
        Set<Mou3inaEntity> providerIds = (Set<Mou3inaEntity>) reservation.getProviders();
        int NbProviders = providerIds.size();
        for (Mou3inaEntity mou3ina : providerIds) {
            //Mou3inaEntity mou3ina = providerIds.iterator(i);
            double cost = 0.0;

            if (reservation.isMorning()) {
                cost += mou3ina.getMorningCost();
            }

            if (reservation.isAfternoon()) {
                cost += mou3ina.getAfternoonCost();
            }

            if (reservation.isEvening()) {
                cost += mou3ina.getEveningCost();
            }

            totalCost += cost;

        }
        // Appeler le microservice "providers-services" pour récupérer les informations des fournisseurs
        /*List<Mou3inaEntityDTO> providers = feignServiceUtil.findMou3iness();

        // Filtrer les fournisseurs en fonction des IDs associés à la réservation
        List<Mou3inaEntityDTO> assignedProviders = providers.stream()
                .filter(provider -> providerIds.contains(provider.getId()))
                .collect(Collectors.toList());*/

        //return providerIds;
        str = "le cout de votre prestation est : " +totalCost;

        ReponseMessage m = new ReponseMessage();
        m.setStr(str);
        return m;
    }

    @PostMapping("/providerCost/{id}")
    public ReponseMessage providerCost(@PathVariable Long id , @RequestBody CustomerReservation reservation) {

        String str = "";
        double cost = 0;
        Mou3inaEntity mou3ina = mou3inaRepository.findById(id).get();

        if (reservation.isMorning() && !reservation.isAfternoon() && !reservation.isEvening()) {
            cost = mou3ina.getMorningCost();
        } else if (!reservation.isMorning() && reservation.isAfternoon() && !reservation.isEvening()) {
            cost = mou3ina.getAfternoonCost();
        } else if (!reservation.isMorning() && !reservation.isAfternoon() && reservation.isEvening()) {
            cost = mou3ina.getEveningCost();
        } else if (reservation.isMorning() && reservation.isAfternoon() && !reservation.isEvening()) {
            cost = mou3ina.getMorningCost() + mou3ina.getAfternoonCost();
        } else if (reservation.isMorning() && !reservation.isAfternoon() && reservation.isEvening()) {
            cost = mou3ina.getMorningCost() + mou3ina.getEveningCost();
        } else if (!reservation.isMorning() && reservation.isAfternoon() && reservation.isEvening()) {
            cost = mou3ina.getAfternoonCost() + mou3ina.getEveningCost();
        } else if (reservation.isMorning() && reservation.isAfternoon() && reservation.isEvening()) {
            cost = mou3ina.getMorningCost() + mou3ina.getAfternoonCost() + mou3ina.getEveningCost();
        }

        // Ajoutez ici la logique pour obtenir le pourcentage de la société en utilisant l'ID du fournisseur (id)
        // double companyPercentage = feignServiceUtil.getCompanyPercentageByProviderId(id);

        // Calculez le coût total en incluant le pourcentage de la société
        //cost = cost* (1+ companyPercentage) ;*/

        str = cost +"TND" ;
        ReponseMessage m = new ReponseMessage();
        m.setStr(str);
        return m;
    }








       /* @PostMapping(value = "/NEW/{id}")
        public CustomerReservation addmou3ina(@PathVariable Long id, @RequestBody CustomerReservation CustomerReservation) {

        Mou3inaEntity m = (Mou3inaEntity) Imou3inaService.findMou3ina(id);

        Set<CustomerOrderMou3inaList> CustomerOrderMou3inaLists = new HashSet<CustomerOrderMou3inaList>();
        Date nowUtc = new Date();
        iCustomerReservation.add(CustomerReservation);
        iCustomerReservation.find(CustomerReservation.getId());

        CustomerReservation.getCustomerOrderMou3inaLists().forEach(r -> {
            customerOrderMou3inaListRepository.save(r);
            r.setMou3ina(m);
            r.setCustomerReservation(CustomerReservation);
            r.setOrderDay(nowUtc);
            r.setRank(1);

            r.setPrimaryKey(r.getPrimaryKey(new CustomerOrderMou3inaList(CustomerReservation.getId(),m.getId())));

           // r.setPrimaryKey(id);

        //    r.setRank( );etRank();

           customerOrderMou3inaListRepository.save(r);

        });
        CustomerReservation.setCustomerOrderMou3inaLists(CustomerOrderMou3inaLists);
        return CustomerReservation;
    }*/

    @PutMapping("/{id}")
    public CustomerReservation updateCustomerReservation(@PathVariable(value = "id") Long Id,
                                   @RequestBody CustomerReservation CustomerReservationDetails) {

        CustomerReservation CustomerReservation = reservationRepository.findById(Id).orElseThrow(null);
        CustomerReservation.setDesiredDate(CustomerReservationDetails.getDesiredDate());
       // CustomerReservation.setDesiredDate(CustomerReservationDetails.getcommande());
        CustomerReservation.setServiceTypes(CustomerReservationDetails.getServiceTypes());
        CustomerReservation.setNumberOfMou3ina(CustomerReservationDetails.getNumberOfMou3ina());
        CustomerReservation.setRate(CustomerReservationDetails.getRate());

        CustomerReservation.setStatuscode(CustomerReservationDetails.getStatuscode());
        CustomerReservation.setGradeAverage(CustomerReservationDetails.getGradeAverage());
        CustomerReservation.setDesiredHour(CustomerReservationDetails.getDesiredHour());
        CustomerReservation.setPaymentStatus(CustomerReservationDetails.getPaymentStatus());
        //CustomerReservation.setCustomerOrderMou3inaLists(CustomerReservationDetails.getCustomerOrderMou3inaLists());
        CustomerReservation.setMorning(CustomerReservationDetails.isMorning());
        CustomerReservation.setAfternoon(CustomerReservationDetails.isAfternoon());
        CustomerReservation.setEvening(CustomerReservationDetails.isEvening());
        
        CustomerReservation updateCustomerReservation = reservationRepository.save(CustomerReservation);

        return updateCustomerReservation;
    }


    @GetMapping("/{id}")
    public CustomerReservation find(@PathVariable Long id) {
        return iCustomerReservation.find(id);
    }

    @RequestMapping(value = "/customerReservations/{id}", method = RequestMethod.GET)
	public List<CustomerReservation> finReservationsByCustomer(@PathVariable long id) {
		return reservationRepository.findByCustomer(id);
	}
    @RequestMapping(value = "/ProviderOrder/{id}", method = RequestMethod.GET)
	public List<CustomerOrderMou3inaList> findByMou3inaId(@PathVariable long id) {
		return customerOrderMou3inaListRepository.findByMou3inaId(id);
	}

    @RequestMapping(value = "/date/{one_date}",method = RequestMethod.GET)
    public List<CustomerReservation> findToday(@PathVariable(value = "one_date")  @DateTimeFormat(pattern = "dd-MM-yyyy") Date fromDate) {

        return iCustomerReservation.getsome(fromDate);
    }


    @RequestMapping(value = "/status/{status}",method = RequestMethod.GET)
    public List<CustomerReservation> getstatus(@PathVariable(value = "status") String status) {

        return iCustomerReservation.getstatus(status);
    }

    @RequestMapping(value = "/nb/{nb}",method = RequestMethod.GET)
    public List<CustomerReservation> getnumbermo3ina(@PathVariable(value = "nb") int nb) {
        return iCustomerReservation.getnumbermo3ina(nb);
    }

    @RequestMapping(value = "/grade/{nb}",method = RequestMethod.GET)
    public List<CustomerReservation> getgrade(@PathVariable(value = "nb") int nb) {
        return iCustomerReservation.getgrade(nb);
    }

    @GetMapping("/customer/{customerId}/provider/{providerId}")
    public Double findByProvider(@PathVariable(value = "customerId") Long idcustomer , @PathVariable(value = "providerId") Long idprovider){
        return  distanceRepository.findDistanceByCustomerIdAndProviderId(idcustomer, idprovider);
    }

        
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Long Id) {
        iCustomerReservation.find(Id);
        boolean exist = reservationRepository.existsById(Id);
        if (!exist) {

            return "CustomerReservation :"+Id+"does not exist";
        } else {
            iCustomerReservation.delete(Id);
            return "CustomerReservation deleted";
        }
    }


    /*@PostMapping("/addReservationProvider")
    public ResponseEntity<String> addReservation(@RequestBody CustomerReservation customerReservation) {
        // Récupérer la liste des fournisseurs depuis le microservice "providers-services"
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
       *//* // Vérifier si les fournisseurs sélectionnés dans la réservation existent
        //List<Long> selectedProviderIds = reservationDTO.getProviders();
        List<Long> selectedProviderIds = customerReservation.getProviders()
                .stream()
                .map(Mou3inaEntity::getId)
                .collect(Collectors.toList());
        for (Long providerId : selectedProviderIds) {
            boolean providerExists = providers.stream()
                    .anyMatch(provider -> provider.getId().equals(providerId));
            if (!providerExists) {
                return ResponseEntity.badRequest().body("Fournisseur avec l'ID " + providerId + " n'existe pas");
            }
        }

        // Mapper la réservation DTO en entité
        //CustomerReservation reservation = mapper.toEntity(customerReservation);

        // Assigner les fournisseurs à la réservation
        Set<Mou3inaEntity> reservationProviders = new HashSet<>();
        for (Long providerId : selectedProviderIds) {
            Mou3inaEntity provider = new Mou3inaEntity();
            provider.setId(providerId);
            reservationProviders.add(provider);
        }
        customerReservation.setProviders(reservationProviders);
*//*
        // Enregistrer la réservation
        iCustomerReservation.add(customerReservation);

        customerReservationRepository.save(customerReservation);
        return ResponseEntity.ok("La réservation a été ajoutée avec succès");
    }
*/

    @GetMapping("/companyPercentage/{providerId}")
    public double getCompanyPercentageByProviderId(@PathVariable Long providerId){
        return feignServiceUtil.getCompanyPercentageByProviderId(providerId);
    }

    @GetMapping("/{id}/total-service-cost")
    public Double getTotalServiceCost(@PathVariable("id") Long id) {
        return customerOrderMou3inaListRepository.calculateTotalServiceCostByCustomerReservation(id);
    }


    @RequestMapping(value = "/findRateByYear/{year}", method = RequestMethod.GET)
    public List<Object[]> findRateByYear(@PathVariable long year) {
        return customerReservationRepository.findRateByYear(year);
    }

    @RequestMapping(value = "/findCostByYear/{year}", method = RequestMethod.GET)
    public List<Object[]> findCostByYear(@PathVariable long year) {
        return customerReservationRepository.findCostByYear(year);
    }

    @GetMapping("/Revenu")
    public Double getTotalRevenu() {
        Double totalRevenu = iCustomerReservation.Revenu();
        return totalRevenu;
    }

    @GetMapping("/pourcentage")
    public Double getPourcentage() {
        Double pourcentage = 0.0;
        Double kpi = 1000.0;
        Double totalRevenu = iCustomerReservation.Revenu();
        pourcentage = (totalRevenu/kpi) * 100;
        return pourcentage;
    }


    @RequestMapping(value = "/customerReservationsByMou3ina/{year}/{idmou3ina}", method = RequestMethod.GET)
    public List<Object[]> findMou3inaOrdersByYearByMonth(@PathVariable long year, @PathVariable long idmou3ina) {
        YearMonth yearMonthObject = YearMonth.of(2022, 2);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        return customerOrderMou3inaListRepository.findMou3inaOrdersByYearByMonth(year, idmou3ina);
    }

    @RequestMapping(value = "/findResTime/{idcustomer}", method = RequestMethod.GET)
    public List<Integer> findStatusReservationsByTime(@PathVariable Long idcustomer) {
        return iCustomerReservation.findStatusReservationsByTime(idcustomer);
    }

    @RequestMapping(value = "/ordersCustomer/{id}/{year}", method = RequestMethod.GET)
    public Map<Object, Long> ordersCustomerByYear(@PathVariable Long id, @PathVariable Integer year) {
        return iCustomerReservation.findreservationsCustomerYear(id, year);
    }

    @RequestMapping(value = "/findRes/{idcustomer}", method = RequestMethod.GET)
    public List<Integer> findStatusReservations(@PathVariable long idcustomer) {
        return iCustomerReservation.findStatusReservations(idcustomer);
    }

    @RequestMapping(value = "/search/{idcustomer}", method = RequestMethod.POST)
    public List<CustomerReservation>searchReservation(@RequestParam(name = "month") String month ,@RequestParam(name = "year")int year,@PathVariable long idcustomer) {
        return iCustomerReservation.search(month,year,idcustomer);
    }


    @PutMapping("/{id}/ConfirmReservation")
    public String  ConfirmReservation(@PathVariable Long id) {
        iCustomerReservation.ConfirmReservation(id);
        return "Reservation confirmed successfully.";

    }

    @PutMapping("/{id}/CancelReservation")
    public String CancelReservation(@PathVariable Long id) {
        iCustomerReservation.CancelReservation(id);
        return "Reservation cancelled successfully.";

    }

    @PutMapping("/{id}/SubmitlReservation")
    public String SubmitlReservation(@PathVariable Long id) {
        iCustomerReservation.SubmitReservation(id);
        return "Reservation completed successfully.";

    }

/*    @GetMapping("/filtre/{id}")
    public List<String> filter(@PathVariable Long id) {
        CustomerReservation customerReservation = reservationRepository.findById(id).get();
        List<String> distances = new ArrayList<>();
        Customer customer = customerReservation.getCustomer();
        Delegation delegation = customer.getDelegation();
        Gouvernorat gouvernorat = customer.getGouvernerat() ;
        List<Mou3inaEntity> providers = mou3inaRepository.findByGouvernoratAndDeligation(gouvernorat,delegation);
        for (Mou3inaEntity prov : providers) {
            Double latProvider = (double) prov.getHome_Adress_GPS_latt();   //35,8446
            Double lonProvider = (double) prov.getHome_Adress_GPS_long();   //10,6191
            Double latCustomer = (double) customer.getHome_Adress_GPS_latt();  //35,8403
            Double lonCustomer = (double) customer.getHome_Adress_GPS_long();   //10,5943
            // Convertir les coordonnées en radians
            Double radLat1 = Math.toRadians(latProvider);
            Double radLon1 = Math.toRadians(lonProvider);
            Double radLat2 = Math.toRadians(latCustomer);
            Double radLon2 = Math.toRadians(lonCustomer);

            // Calculer la différence de longitude et de latitude
            Double diffLon = radLon2 - radLon1;
            Double diffLat = radLat2 - radLat1;

            // Appliquer la formule de la distance entre deux points GPS
            Double a = Math.sin(diffLat / 2) * Math.sin(diffLat / 2) +
                    Math.cos(radLat1) * Math.cos(radLat2) *
                            Math.sin(diffLon / 2) * Math.sin(diffLon / 2);
            Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            Double distance = 6371 * c; // Rayon de la Terre en kilomètres

            String message = "Le fournisseur " + prov.getFirstName() + " " + prov.getLastName() +
                    " se trouve à une distance de " + distance + " kilomètres.";

            distances.add(message);

        }

        return distances;
    }*/

    @GetMapping("/filtre/{id}")
    public List<String> filter(@PathVariable Long id) {
        CustomerReservation customerReservation = reservationRepository.findById(id).get();
        List<String> distances = new ArrayList<>();
        Customer customer = customerReservation.getCustomer();
        Delegation delegation = customer.getDelegation();
        Gouvernorat gouvernorat = customer.getGouvernerat() ;
        List<Mou3inaEntity> providers = mou3inaRepository.findByGouvernoratAndDeligation(gouvernorat ,delegation);
        for (Mou3inaEntity prov : providers) {
            Double latProvider = (double) prov.getHome_Adress_GPS_latt();   //35,8446
            Double lonProvider = (double) prov.getHome_Adress_GPS_long();   //10,6191
            Double latCustomer = (double) customer.getHome_Adress_GPS_latt();  //35,8403
            Double lonCustomer = (double) customer.getHome_Adress_GPS_long();   //10,5943
            // Convertir les coordonnées en radians
            Double radLat1 = Math.toRadians(latProvider);
            Double radLon1 = Math.toRadians(lonProvider);
            Double radLat2 = Math.toRadians(latCustomer);
            Double radLon2 = Math.toRadians(lonCustomer);

            // Calculer la différence de longitude et de latitude
            Double diffLon = radLon2 - radLon1;
            Double diffLat = radLat2 - radLat1;

            // Appliquer la formule de la distance entre deux points GPS
            Double a = Math.sin(diffLat / 2) * Math.sin(diffLat / 2) +
                    Math.cos(radLat1) * Math.cos(radLat2) *
                            Math.sin(diffLon / 2) * Math.sin(diffLon / 2);
            Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            Double distance = 6371 * c; // Rayon de la Terre en kilomètres

            String message = "Le fournisseur " + prov.getFirstName() + " " + prov.getLastName() +
                    " se trouve à une distance de " + distance + " kilomètres.";

            Distance distanceProvCustomer = new Distance();
            distanceProvCustomer.setCustomerReservation(customerReservation);
            distanceProvCustomer.setDistance(distance);
            distanceProvCustomer.setProvider(prov);
            distanceProvCustomer.setCustomer(customer);
            //distances.add(distanceProvCustomer);
            distanceRepository.save(distanceProvCustomer);
            distances.add(message);

        }

        return distances;
    }


    @RequestMapping(value = "/countRateBonnee/{year}", method = RequestMethod.GET)
    public Long countRateBonnee(@PathVariable Long year) {
        return iCustomerReservation.countRatBonne(year);
    }

    @RequestMapping(value = "/countRateNeutre/{year}", method = RequestMethod.GET)
    public Long countRateNeutr(@PathVariable Long year) {
        return iCustomerReservation.countRatNeutre(year);
    }





    }
