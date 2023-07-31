package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.dao.*;
import com.sofrecom.operation.customer.dto.Mou3inaEntityDTO;
import com.sofrecom.operation.customer.entities.*;
import com.sofrecom.operation.customer.util.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
//@Slf4j

public class CustomerReservationservice implements ICustomerReservation {


    /*@Value("Activity_0mzicix")
    private String keyDefinition ;*/

    @Autowired
    CustomerRepository customerRepository ;

    @Autowired
    CustomerReservationRepository customerReservationRepository;

    @Autowired
    private DistanceRepository distanceRepository;

    @Autowired
    private FeignServiceUtil feignServiceUtil;

    @Autowired
    private Mou3inaRepository mou3inaEntityRepository;

    @Autowired
    private CustomerOrderMou3inaListRepository customerOrderMou3inaListRepository;

    @Override
    public CustomerReservation add(CustomerReservation c) {


       /* ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();


        String processInstanceId_1 =
                runtimeService.startProcessInstanceByKey("Process_1exax7n").getProcessInstanceId();

        c.setProcessInstanceID(processInstanceId_1);*/

        return customerReservationRepository.save(c);

    }




    @Override
    public void delete(Long id) {
        if(customerReservationRepository.findById(id).isPresent())
            customerReservationRepository.deleteById(id);
    }

    @Override
    public CustomerReservation update(CustomerReservation c) {
        return customerReservationRepository.saveAndFlush(c);
    }

    @Override
    public CustomerReservation find(Long id) {
        return (CustomerReservation) customerReservationRepository.findById(id).get();
        }

    @Override
    public List<CustomerReservation> getsome(Date date) {
        return (List<CustomerReservation>) customerReservationRepository.getsome(date);
    }
    /*
    @Override
    public List<CustomerReservation> getservicetype(String servicetype) {
        return (List<CustomerReservation>) customerReservationRepository.getservicetype(servicetype);
    }
    */

    @Override
    public List<CustomerReservation> getstatus(String status) {
        return (List<CustomerReservation>) customerReservationRepository.getstatus(status);
    }
    @Override
    public List<CustomerReservation> getgrade(int grade) {
        return (List<CustomerReservation>) customerReservationRepository.getgrade(grade);
    }
    @Override
    public List<CustomerReservation> getnumbermo3ina(int nb) {
        return (List<CustomerReservation>) customerReservationRepository.getnumbermo3ina(nb);
    }
    @Override
    public List<CustomerReservation> findAll() {
        return customerReservationRepository.findAll();
    }

    public List<Mou3inaEntityDTO> getProviders() {
        return feignServiceUtil.findMou3iness();
    }

    public List<Mou3inaEntity> findAvailableProviders(CustomerReservation reservation) {
        Collection<ServiceType> serviceTypes = reservation.getServiceTypes();
        Date desiredDate = reservation.getDesiredDate();
        boolean morning = reservation.isMorning();
        boolean evening = reservation.isEvening();
        boolean afternoon = reservation.isAfternoon();

        // Recherche des fournisseurs disponibles
        Collection<Mou3inaEntity> availableProviders = mou3inaEntityRepository.findAvailableProviders(serviceTypes,desiredDate, morning, evening, afternoon);


        return (List<Mou3inaEntity>) availableProviders;
    }


    @Override
    public List<Object[]> findReservationYear(long year) {
        return customerReservationRepository.findReservationYear(year);

    }
    /////////////////////////////////////////////////////////////////////////////////////
    public List<Mou3inaEntity> filter(Long id ,CustomerReservation customerReservation) {
        List<String> distances = new ArrayList<>();
        //CustomerReservation customerReservation = customerReservationRepository.findById(id).get();
        Customer customer = customerRepository.findById(id).get();
        Delegation delegation = customer.getDelegation();
        Gouvernorat gouvernorat = customer.getGouvernerat();
        Collection<ServiceType> serviceTypes = customerReservation.getServiceTypes();
        Date desiredDate = customerReservation.getDesiredDate();
        boolean morning = customerReservation.isMorning();
        boolean evening = customerReservation.isEvening();
        boolean afternoon = customerReservation.isAfternoon();
        Collection<Mou3inaEntity> availableProviders = mou3inaEntityRepository.findAvailableProviders(serviceTypes,desiredDate, morning, evening, afternoon);
        List<Mou3inaEntity> filteredProviders = new ArrayList<>();
        for (Mou3inaEntity provider : availableProviders) {
            if (provider.getDeligation().equals(delegation) || provider.getGouvernorat().equals(gouvernorat)) {
                filteredProviders.add(provider);
            }
        }

        for(Mou3inaEntity prov : filteredProviders){
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
            //distanceProvCustomer.setCustomerReservation(customerReservation);
            distanceProvCustomer.setDistance(distance);
            distanceProvCustomer.setProvider(prov);
            distanceProvCustomer.setCustomer(customer);
            prov.setDistance(distance);
            //distances.add(distanceProvCustomer);
            distanceRepository.save(distanceProvCustomer);
            distances.add(message);
        }

        return (List<Mou3inaEntity>) filteredProviders;

    }

    ////////////////////////////////////////////////////////////

    @Override
    public CustomerReservation ConfirmReservation(Long id) {
        CustomerReservation reseration = customerReservationRepository.findById(id).get();
        reseration.setStatus(ReservationStatus.CONFIRMED);
        customerReservationRepository.save(reseration);
        return reseration;
    }

    @Override
    public void CancelReservation(Long id) {
        CustomerReservation reseration = customerReservationRepository.findById(id).get();
        reseration.setStatus(ReservationStatus.CANCELLED);
        customerReservationRepository.save(reseration);
    }

    @Override
    public void SubmitReservation(Long id) {
        CustomerReservation reseration = customerReservationRepository.findById(id).get();
        reseration.setStatus(ReservationStatus.COMPLETED);
        customerReservationRepository.save(reseration);
    }


    @Override
    public Long countRatNeutre(Long year) {
        List<CustomerReservation> cr = customerReservationRepository.findAll();
        long count = 0;

        for (CustomerReservation r : cr) {
            Date desiredDate = r.getDesiredDate();
            if (desiredDate != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(desiredDate);
                int yearFromDesiredDate = calendar.get(Calendar.YEAR);

                if (yearFromDesiredDate == year && r.getRate() == 3) {
                    count++;
                }
            }
        }

        return count;
    }
    @Override
    public Long countRatBonne(Long year) {
        List<CustomerReservation> cr = customerReservationRepository.findAll();
        long count = 0;

        for (CustomerReservation r : cr) {
            //LocalDate desiredDate = r.getDesiredDate().toLocalDate();
            Date desiredDate = r.getDesiredDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(desiredDate);
            int yearFromDesiredDate = calendar.get(Calendar.YEAR);
            if (yearFromDesiredDate == year && (r.getRate() == 4 || r.getRate() == 5)) {
                count++;
            }
        }

        return count;

    }

   /* @Override
    public Long countRatePromouvantes(long idoper, long year) {
        List<CustomerReservation> cr = customerReservationRepository.findBy(idoper);
        List<CustomerReservation> RateProum = new ArrayList<CustomerReservation>();
        cr.forEach(r -> {
            if (r.getDesiredDate().getYear() == year && (r.getRate() == 1 || r.getRate() == 2)) {
                RateProum.add(r);
            }
        });
        return (long) RateProum.size();
    }*/


    public Double Revenu() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        Double totalDifference = 0.0;
        List<CustomerReservation> reservations = customerReservationRepository.findAll();

        for (CustomerReservation reservation : reservations) {
            Calendar reservationCalendar = Calendar.getInstance();
            reservationCalendar.setTime(reservation.getDesiredDate());
            int reservationYear = reservationCalendar.get(Calendar.YEAR);

            if (reservationYear == currentYear) {
                Double totalServiceCost = customerOrderMou3inaListRepository.calculateTotalServiceCostByCustomerReservation(reservation.getId());
                Double costDifference = reservation.getTotalCost() - totalServiceCost;
                totalDifference += costDifference;
            }
        }

        return totalDifference;
    }

    @Override
    public List<Integer> findStatusReservationsByTime(Long idcustomer) {
        List<CustomerReservation> cr = customerReservationRepository.findByCustomer(idcustomer);
        List<CustomerReservation> resultatMorning = new ArrayList<CustomerReservation>();
        List<CustomerReservation> resultatAfternoon = new ArrayList<CustomerReservation>();
        List<CustomerReservation> resultatEvening = new ArrayList<CustomerReservation>();
        List<Integer> reselutat = new ArrayList<>();

        cr.forEach(el -> {
            if (el.isMorning()) {
                resultatMorning.add(el);
            }
            if (el.isAfternoon()) {
                resultatAfternoon.add(el);
            }
            if (el.isEvening()) {
                resultatEvening.add(el);
            }
        });
        reselutat.add(resultatMorning.size());
        reselutat.add(resultatAfternoon.size());
        reselutat.add(resultatEvening.size());

        return reselutat;
    }

    @Override
    public Map<Object, Long> findreservationsCustomerYear(Long id, Integer year) {
        List<CustomerReservation> cr = customerReservationRepository.findByCustomer(id);
        Map<Object, Long> testorders = cr.stream()
                .filter(el -> el.getDesiredDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() == year)
                .collect(Collectors.groupingBy(p -> Month.from(p.getDesiredDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()), Collectors.counting()));

        return testorders;
    }


    @Override
    public List<CustomerReservation> search(String month, Integer year, Long idcustomer) {
        List<CustomerReservation> cr = customerReservationRepository.findByCustomer(idcustomer);
        List<CustomerReservation> resultat = new ArrayList<CustomerReservation>();
        cr.forEach(el -> {
            LocalDate desiredDate = el.getDesiredDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (desiredDate.getYear() == year && desiredDate.getMonth().name().equalsIgnoreCase(month)) {
                resultat.add(el);
            }
        });
        return resultat;
    }
    @Override
    public List<Integer> findStatusReservations(long idcustomer) {
        List<CustomerReservation> cr = customerReservationRepository.findByCustomer(idcustomer);
        List<ServiceType> stHouse = new ArrayList<ServiceType>();
        List<ServiceType> stIroning = new ArrayList<ServiceType>();
        List<ServiceType> stkeep = new ArrayList<ServiceType>();
        List<ServiceType> stCook = new ArrayList<ServiceType>();
        List<Integer> reselutat = new ArrayList<>();

        cr.forEach(el -> {
            el.getServiceTypes().forEach(r -> {



                if (r.getLabel().equalsIgnoreCase("housework")) {
                    stHouse.add(r);
                } else if (r.getLabel().equalsIgnoreCase("help for elderly")) {
                    stkeep.add(r);
                } else if (r.getLabel().equalsIgnoreCase("ironing")) {
                    stIroning.add(r);
                } else if (r.getLabel().equalsIgnoreCase("cook")) {
                    stCook.add(r);
                }
            });
        });
        reselutat.add(stHouse.size());
        reselutat.add(stkeep.size());
        reselutat.add(stIroning.size());
        reselutat.add(stCook.size());
        // System.out.println(stkeep.size());;
        return reselutat;

    }




}
