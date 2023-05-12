package com.sofrecom.authentifmou3ina.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.ERole;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.Role;
import com.sofrecom.authentifmou3ina.jwt.JwtUtils;
import com.sofrecom.authentifmou3ina.repository.CleaningCompanyRepository;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.repository.RoleRepository;
import com.sofrecom.authentifmou3ina.request.LoginRequest;
import com.sofrecom.authentifmou3ina.response.JwtResponse;
import com.sofrecom.authentifmou3ina.response.MessageResponse;
import com.sofrecom.authentifmou3ina.services.Imou3inaService;
import com.sofrecom.authentifmou3ina.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  Imou3inaService mou3inaService;
	@Autowired
	Mou3inaRepository mou3inaRepository;
	//public static final String DIRECTORY =  "C://Users/a.mosbah/Downloads/operation-admin-fe-master/operation-admin-fe-master/src/assets/img";

  @Autowired
  Mou3inaRepository userRepository;

	@Autowired
	CleaningCompanyRepository  CompanyRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
   
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
                         userDetails.getId(),
                         userDetails.getUsername(),
                         userDetails.getEmailAdress(),
                         roles));
  }
  

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody Mou3inaEntity signUpRequest) {
	   if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return ResponseEntity
	            .badRequest()
	            .body(new MessageResponse("Error: Username is already taken!"));
	   }

	   if (userRepository.existsByemailAdress(signUpRequest.getEmailAdress())) {
	      return ResponseEntity
	            .badRequest()
	            .body(new MessageResponse("Error: Email is already in use!"));
	   }

	   // Create new user's account
	   Mou3inaEntity mou3ina = new Mou3inaEntity(
	   signUpRequest.getId(), signUpRequest.getFirstName(), signUpRequest.getLangageSpeaking(),
	         signUpRequest.getLastName(), signUpRequest.getBirthday(),signUpRequest.getGender(),  signUpRequest.getSeniority()
	         ,signUpRequest.getGouvernorat(),signUpRequest.getDeligation(),
	           signUpRequest.getCooptedBy(),signUpRequest.getPhone(), signUpRequest.getDocumentIdType(),
	           signUpRequest.getPhone2()  ,  signUpRequest.getHome_Adress(),signUpRequest.getHome_Adress_GPS_long(),
	           signUpRequest.getHome_Adress_GPS_latt(),  signUpRequest.getCollaborationStatus(), signUpRequest.getInscriptionStatus(),
	           signUpRequest.getVideo(),  signUpRequest.getEmailAdress(), signUpRequest.getVip(), signUpRequest.getComment(),/*signUpRequest.getAvailibility(),*/
	           signUpRequest.getRib() ,  signUpRequest.getCooptedByID(), signUpRequest.getGradeAverage(),
	           signUpRequest.getHasASmartPhone(),  signUpRequest.getPhoto(), signUpRequest.getName(), signUpRequest.getImage(),
	            signUpRequest.getCopie(),signUpRequest.getOperational_Id(),
	         signUpRequest.getStatus(),/*signUpRequest.getReclamation(),*/signUpRequest.getServiceType(),signUpRequest.getProcessInstanceID(),signUpRequest.getDocState(),signUpRequest.getTokenDevice(), signUpRequest.getFixedPart(), signUpRequest.getM(), signUpRequest.getN(), signUpRequest.getNbfavoris(), signUpRequest.getNbPrestations(), signUpRequest.getSalary(),/*signUpRequest.getEmploymentStatus(),*/
	         signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword())
	   );

	   Set<Role> strRoles = signUpRequest.getRoles();
	   Set<Role> roles = new HashSet<>();

	   if (strRoles == null) {
	      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	      roles.add(userRole);
	   
	   }

	   mou3ina.setRoles(roles);
	   userRepository.save(mou3ina);

	   return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}



	@PostMapping("/signupcompany")
	public ResponseEntity<?> registerCleaningCompany(@Valid @RequestBody CleaningServicesCompany signUpRequest) {
		if (CompanyRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (CompanyRepository.existsByemailAdress(signUpRequest.getEmailAdress())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		CleaningServicesCompany company = new CleaningServicesCompany(signUpRequest.getId(), signUpRequest.getCompanyName(), signUpRequest.getAdress(), signUpRequest.getEmailAdress(), signUpRequest.getRib(), signUpRequest.getPhone()
				, signUpRequest.getProviders(), signUpRequest.getUsername(),encoder.encode(signUpRequest.getPassword()));

		Set<Role> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);

		}

		company.setRoles(roles);
		CompanyRepository.save(company);

		return ResponseEntity.ok(new MessageResponse("company registered successfully!"));

	}

	
	@RequestMapping(value = "/Mou3inas", method = RequestMethod.GET)
	public ResponseEntity<Object> findMou3iness() {
		return (ResponseEntity<Object>) mou3inaService.findAll();
	}


	@GetMapping(value = "/Mou3ina/{id}")
	public Mou3inaEntity findOneMou3inaById(@PathVariable Long id) {
		return	 mou3inaService.findMou3ina(id);
	
		
		 
	}		
	@GetMapping(value = "/Mou3inaa/{id}")
	public Mou3inaEntity findOneMou3ina(@PathVariable Long id) {
		
		return	 mou3inaService.findMou3inaa(id);
	
		
		 
	}	
	@GetMapping(value = "/Mou3ina/Search/firstName")
	public Mou3inaEntity findMou3inanByfirstName(@PathVariable String e) {
		return mou3inaService.findByfirstName(e);
	}
	
	
	@PutMapping(value = "/Mou3inas/Mou3ina/{id}")
	public Mou3inaEntity updateMou3ina(@PathVariable Long id, @RequestBody Mou3inaEntity p) {
		p.setId(id);
		return mou3inaService.updateMou3ina(p);
	}

	@DeleteMapping(value = "/deleteMou3inas/{id}")
	public void deleteMou3ina(@PathVariable Long id) {
		mou3inaService.deleteMou3ina(id);
	}
	
}
