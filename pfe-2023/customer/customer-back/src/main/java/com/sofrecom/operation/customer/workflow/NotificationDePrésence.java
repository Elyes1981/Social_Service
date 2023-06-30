package com.sofrecom.operation.customer.workflow;

import com.sofrecom.operation.customer.dao.CustomerReservationRepository;
import com.sofrecom.operation.customer.entities.CustomerReservation;
import com.sofrecom.operation.customer.service.FirebaseMessagingService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class NotificationDePrésence implements JavaDelegate {

    @Autowired
    private FirebaseMessagingService firebaseService;

    @Autowired
    private CustomerReservationRepository customerReservationRepository;
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        CustomerReservation customerReservation = customerReservationRepository.findAllByOrderByIdDesc().get(0);

        firebaseService.sendNotification("notification de vérification de présence  ", //customerReservation.getId()+
                 "Bonjour  Ahmed, confirmation de votre presence ", "fCA64Yw0T-Ox4S3rUJZs4Z:APA91bEGeKbuuoyclLUZy-EaylHnjlIzWSBgw-BTQE8d8hz1-HrRjK9HOiVmtgeaM3b7OwcE-XXRvp3c73ditif3Odxpx5girbG1_uNVuU6fQqKw5C7s4wOKn_u5dZel2rIS-UHboaZz");
        //System.out.println("notification de rappel pour le client et provider ");
    }
}
