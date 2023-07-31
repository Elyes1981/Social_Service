/*
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

        firebaseService.sendNotification("notification de vérification de présence  pour le provider", customerReservation.getId()+"", "f-c_xqujSsayobXIZAXZt-:APA91bGVllRxmegJopnbsr9qPLKWJbJgTCjTHCgY8ADD3aYTP909nog60Db3dotM9MwL7WilnFTlePTYXfUHAhJvAQ4CfyZEd-pPYsGFDNG8874JBol-eCu6V_I-P33XBFeq0WUx35wG");
        //System.out.println("notification de rappel pour le client et provider ");
    }
}
*/
