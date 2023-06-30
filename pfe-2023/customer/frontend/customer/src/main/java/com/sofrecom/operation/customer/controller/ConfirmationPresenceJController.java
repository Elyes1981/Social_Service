package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.dto.ConfirmationPresenceJDTO;
import com.sofrecom.operation.customer.service.ConfirmationPresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/confirmation-presencej")
@CrossOrigin(origins = "http://localhost:4200")

public class ConfirmationPresenceJController {

@Autowired
private ConfirmationPresenceService confirmationPresenceJService;


        @PostMapping("")
        public ResponseEntity<String> acceptNotification(@RequestBody ConfirmationPresenceJDTO confirmationPresenceJDTO) {
            confirmationPresenceJService.save(confirmationPresenceJDTO.getReservationId(),confirmationPresenceJDTO.getConfirmationPresenceJ());
            return ResponseEntity.ok("Notification acceptée");
        }

}
