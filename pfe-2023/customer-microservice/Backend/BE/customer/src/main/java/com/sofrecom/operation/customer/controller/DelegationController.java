package com.sofrecom.operation.customer.controller;

import java.util.Collection;
import java.util.List;

import com.sofrecom.operation.customer.dao.StatusReservationRepository;
import com.sofrecom.operation.customer.entities.Delegation;
import com.sofrecom.operation.customer.entities.StatusReservation;
import com.sofrecom.operation.customer.service.DelegationService;
import com.sofrecom.operation.customer.service.IStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DelegationController {
	@Autowired
    DelegationService delegationService;

	@GetMapping(value = "/delegations")
	public Collection<Delegation> findAlldelegations() {
		return delegationService.findAll();
	}

	@GetMapping(value = "/delegations/{id}")
	public Delegation findoneDelegation(@PathVariable Long id) {
		return delegationService.findDelegation(id);
	}

	@PostMapping(value ="/delegations")
	public Delegation addDelegation(@RequestBody Delegation m) {
		return delegationService.addDelegation(m);
	}

	
	@PutMapping(value ="/delegations/{id}")
	public Delegation updateDelegation(@PathVariable Long id, @RequestBody Delegation p) {
	p.setIddele(id);
		return delegationService.updateDelegation(p);
		
	}

	@DeleteMapping(value = "/delegations/{id}")
	public void deleteDelegation(@PathVariable Long id) {
		delegationService.deleteDelegation(id);
	}

    @Primary
    @Service
    public static class StatusReservationService implements IStatus {
        @Autowired
        StatusReservationRepository statusReservationRepository;

        @Override
        public StatusReservation addStatus(StatusReservation s) {
         statusReservationRepository.save(s);
            return s;
        }

        @Override
        public void deleteStatus(Long id) {
         if(statusReservationRepository.findById(id).isPresent())
          statusReservationRepository.deleteById(id);
        }

        @Override
        public StatusReservation updateStatus(StatusReservation s) {
            return statusReservationRepository.saveAndFlush(s);
        }

        @Override
        public StatusReservation findStatus(Long code) {
            StatusReservation s = (StatusReservation) statusReservationRepository.findById(code).get();
            return s;
        }

        @Override
        public List<StatusReservation> findAll() {
            return statusReservationRepository.findAll();
        }
    }
}
