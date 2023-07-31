package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.dto.AppelDirectDTO;
import com.sofrecom.operation.customer.service.AppelDirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/appel-direct")
@CrossOrigin(origins = "http://localhost:4200")

public class AppelDirectController {

@Autowired
private AppelDirectService appelDirectService;


        @PostMapping("")
        public ResponseEntity<String> acceptNotification(@RequestBody AppelDirectDTO appelDirectDTO) {
            appelDirectService.save(appelDirectDTO.getProviderId(),appelDirectDTO.getNumeroTel());
            return ResponseEntity.ok("Notification acceptée");
        }

}
