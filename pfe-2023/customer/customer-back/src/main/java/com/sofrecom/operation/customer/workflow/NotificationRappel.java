package com.sofrecom.operation.customer.workflow;

//import com.sofrecom.operation.customer.service.FirebaseMessagingService;

import com.sofrecom.operation.customer.dao.CustomerReservationRepository;
import com.sofrecom.operation.customer.entities.CustomerReservation;
import com.sofrecom.operation.customer.service.FirebaseMessagingService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NotificationRappel implements JavaDelegate {

    @Autowired
    private FirebaseMessagingService firebaseService;

    @Autowired
    private CustomerReservationRepository customerReservationRepository;
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        CustomerReservation customerReservation = customerReservationRepository.findAllByOrderByIdDesc().get(0);

        firebaseService.sendNotification("notification de rappel de votre commande", //customerReservation.getId()+
                "Bonjour  Ahmed,  \n confirmation de commande \n le 27-06-2023 \n ironing , housework \n 45DT", "fCA64Yw0T-Ox4S3rUJZs4Z:APA91bEGeKbuuoyclLUZy-EaylHnjlIzWSBgw-BTQE8d8hz1-HrRjK9HOiVmtgeaM3b7OwcE-XXRvp3c73ditif3Odxpx5girbG1_uNVuU6fQqKw5C7s4wOKn_u5dZel2rIS-UHboaZz");
        //System.out.println("notification de rappel pour le client et provider ");
        //firebaseService.sendNotification("notification de rappel pour le client ", customerReservation.getId()+"", "dMHif54rSCunVSXavDRdT-:APA91bEVcwr3kTYqfM7WVBA8273miES2zI4SHJsE5-2kL7T8q6C2ErhWxR0VNEF8TMSQuGpxfkVJ_KJ8F_y7v2FiXmQZ6qLLLBcIPOFhYABVUZVaizEJOtsiU0dhScL9z-lwPA3Qu2Nc");
    }
}
