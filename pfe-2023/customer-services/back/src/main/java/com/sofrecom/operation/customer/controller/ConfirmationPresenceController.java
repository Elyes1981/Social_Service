package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.dto.ConfirmationPresenceDTO;
import com.sofrecom.operation.customer.service.ConfirmationPresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/confirmation-presence")
@CrossOrigin(origins = "http://localhost:4200")

public class ConfirmationPresenceController {

@Autowired
private ConfirmationPresenceService confirmationPresenceService;


        @PostMapping("")
        public ResponseEntity<String> acceptNotification(@RequestBody ConfirmationPresenceDTO confirmationPresenceDTO) {
            confirmationPresenceService.save(confirmationPresenceDTO.getReservationId(),confirmationPresenceDTO.getConfirmationPresence());
            return ResponseEntity.ok("Notification acceptée");
        }

}
