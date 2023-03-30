package com.sofrecom.operation.customer.controller;
import com.sofrecom.operation.customer.dao.CustomerOrderMou3inaListRepository;
import com.sofrecom.operation.customer.entities.*;
import com.sofrecom.operation.customer.dao.CustomerReservationRepository;
import com.sofrecom.operation.customer.service.ICustomerReservation;
import com.sofrecom.operation.customer.service.Imou3inaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/CustomerReservations")

public class CustomerReservationcontroller {

    @Autowired
    ICustomerReservation iCustomerReservation;

    @Autowired
    private CustomerReservationRepository reservationRepository;
    @Autowired
    private CustomerOrderMou3inaListRepository customerOrderMou3inaListRepository;
    @Autowired
    Imou3inaService Imou3inaService;
    @GetMapping(" ")
    public List<CustomerReservation> getAllCustomerReservations(){
        List <CustomerReservation> CustomerReservations = iCustomerReservation.findAll();
        return CustomerReservations;
    }
    @GetMapping("/orders")
    public List<CustomerOrderMou3inaList> getAllCustomerReservationsmou3ina(){
        List <CustomerOrderMou3inaList> CustomerReservationOrders = customerOrderMou3inaListRepository.findAll();
        return CustomerReservationOrders;
    }
    
    @PostMapping(" ")
    public CustomerReservation createCustomerReservation(@RequestBody CustomerReservation CustomerReservation) {
        Set<Recurrentreservation> reccurents= new HashSet<Recurrentreservation>();
        CustomerReservation.getRecurrents().forEach(r ->{
            r.setCustomerReservation(CustomerReservation);
        });
        return iCustomerReservation.add(CustomerReservation);
    }

    @PostMapping("/add/{id}")
    public CustomerReservation  createCustomerReservation(@PathVariable Long id,@RequestBody CustomerReservation CustomerReservation) {
        Date nowUtc = new Date();
        Mou3inaEntity m = (Mou3inaEntity) Imou3inaService.findMou3ina(id);
        iCustomerReservation.add(CustomerReservation);
        CustomerReservation order =   iCustomerReservation.find(CustomerReservation.getId());
        CustomerOrderMou3inaListId pk = new CustomerOrderMou3inaListId(order.getId(), m.getId());
        CustomerOrderMou3inaList CustomerOrderMou3inaList = new CustomerOrderMou3inaList( pk,  nowUtc,1, m,  order);
        CustomerOrderMou3inaList.setRank(1);

        CustomerOrderMou3inaList.setOrderDay(nowUtc);
      //  CustomerOrderMou3inaListId pk = new CustomerOrderMou3inaListId(order.getId(), m.getId());
        CustomerOrderMou3inaList.setPrimaryKey(pk);
        customerOrderMou3inaListRepository.save(CustomerOrderMou3inaList);
        CustomerReservation.setCustomerOrderMou3inaLists(new HashSet<>(Arrays.asList(CustomerOrderMou3inaList)) );
        return CustomerReservation;
    }


        @PostMapping(value = "/NEW/{id}")
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
    }



    @CrossOrigin
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
        CustomerReservation.setCustomerOrderMou3inaLists(CustomerReservationDetails.getCustomerOrderMou3inaLists());
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
    @RequestMapping(value = "/customerReservations/mou3ina/{id}", method = RequestMethod.GET)
	public List<CustomerOrderMou3inaList> finReservationsbymou3ina(@PathVariable long id) {
		return customerOrderMou3inaListRepository.findBymou3ina(id);
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
}
