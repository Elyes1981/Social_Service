package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.dao.CustomerReservationRepository;
import com.sofrecom.operation.customer.entities.CustomerReservation;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
//@Slf4j

public class CustomerReservationservice implements ICustomerReservation {


    @Value("Activity_0mzicix")
    private String keyDefinition ;


    @Autowired
    CustomerReservationRepository customerReservationRepository;

    @Override
    public CustomerReservation add(CustomerReservation c) {


        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();


        String processInstanceId_1 =
                runtimeService.startProcessInstanceByKey("Process_1exax7n").getProcessInstanceId();

        c.setProcessInstanceID(processInstanceId_1);

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

}
