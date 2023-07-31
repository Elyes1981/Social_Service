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
import com.sofrecom.authentifmou3ina.entities.*;
import com.sofrecom.authentifmou3ina.jwt.JwtUtils;
import com.sofrecom.authentifmou3ina.repository.CleaningCompanyRepository;
import com.sofrecom.authentifmou3ina.repository.CompanyOwnerRepository;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.repository.RoleRepository;
import com.sofrecom.authentifmou3ina.request.LoginRequest;
import com.sofrecom.authentifmou3ina.response.JwtResponse;
import com.sofrecom.authentifmou3ina.response.MessageResponse;
import com.sofrecom.authentifmou3ina.services.Imou3inaService;
import com.sofrecom.authentifmou3ina.services.UserDetailsImpl;
import com.sofrecom.authentifmou3ina.util.FeignServiceUtil;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


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

	@Autowired
	CompanyOwnerRepository companyOwnerRepository;

	@Autowired
	FeignServiceUtil feignServiceUtil;

	@Value("${spring.workflow.keydefinitionname}")
	private String keyDefinition ;
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
	public ResponseEntity<?> registerUser(@Valid @RequestBody Mou3inaEntity signUpRequest , @RequestParam(value = "companyID", required = false) String companyID) {
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
	           signUpRequest.getVideo(),  signUpRequest.getEmailAdress(), signUpRequest.getVip(), signUpRequest.getComment(), signUpRequest.getAvailibility(),
	           signUpRequest.getRib() ,  signUpRequest.getCooptedByID(), signUpRequest.getGradeAverage(),
	           signUpRequest.getHasASmartPhone(),  signUpRequest.getPhoto(), signUpRequest.getName(), signUpRequest.getImage(),
	            signUpRequest.getCopie(),signUpRequest.getOperational_Id(),
	         signUpRequest.getStatus(),/*signUpRequest.getReclamation(),*/signUpRequest.getServiceType(),signUpRequest.getProcessInstanceID(),signUpRequest.getDocState(),signUpRequest.getTokenDevice(), signUpRequest.getN(), signUpRequest.getCommissionPercentage(), signUpRequest.getNbfavoris(), signUpRequest.getNbServicesDone(),signUpRequest.getSalary(),signUpRequest.getEmploymentStatus(),signUpRequest.getCompany(),signUpRequest.getWorkDaysByMonth(),signUpRequest.getMorningCost(), signUpRequest.getAfternoonCost(), signUpRequest.getEveningCost(), signUpRequest.getServiceCost(), signUpRequest.getServicesDone(), signUpRequest.getDevice(),signUpRequest.getRoles(), /*signUpRequest.getWeeklyCost(),*/ signUpRequest.getLastResetDate(),
	         signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword())
	   );

		Set<Role> roles = new HashSet<>();
		Role roleProvider = new Role();
		roleProvider.setName(ERole.ROLE_USER);
		Role savedRole = roleRepository.save(roleProvider);
		roles.add(savedRole); // Add the newly created role to the roles set
		mou3ina.setRoles(roles); // Set the roles for the provider


		ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		String processInstancrId= runtimeService.startProcessInstanceByKey(keyDefinition).getProcessInstanceId();
		mou3ina.setProcessInstanceID(processInstancrId);
		mou3ina.setDocState(DocState.NO_DOCUMENT_UPLOADED);
		mou3ina.setEmploymentStatus(EmploymentStatus.self_employed);
		mou3ina.setNbfavoris(0);
		//mou3ina.setServicesDone(0);
		mou3ina.setN((float) Math.min(Math.max(mou3ina.getN(), 0.02), 0.1));  // sets default value to 2%, and maximum value to 10%

		if (companyID != null && !companyID.isEmpty()) {
			// Vérifier si l'entreprise existe avec l'ID spécifié
			CleaningServicesCompany company = CompanyRepository.findByCompanyID(companyID);
			if (company == null) {
				return ResponseEntity.badRequest().body(new MessageResponse("Error: Company not found!"));
			}
			Set<Mou3inaEntity> providers = company.getProviders();
			mou3ina.setEmploymentStatus(EmploymentStatus.salaried_employee);
			mou3ina.setDocState(DocState.VERIFIED);
			providers.add(mou3ina);
			company.setProviders(providers);

			// Mettre à jour l'entreprise
			userRepository.save(mou3ina);
			CompanyRepository.save(company);

		}


	   	userRepository.save(mou3ina);
		feignServiceUtil.insertProvidersFromOtherMicroservice();

	   return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}



	@PostMapping("/signupcompany")
	public ResponseEntity<?> registerCleaningCompany(@Valid @RequestBody CleaningServicesCompany signUpRequest ) {
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

		CleaningServicesCompany company = new CleaningServicesCompany(signUpRequest.getId(), signUpRequest.getCompanyName(), signUpRequest.getAdress(), signUpRequest.getEmailAdress(), signUpRequest.getRib(), signUpRequest.getPhone(),signUpRequest.getRne(),
				signUpRequest.getSiteLinkedIn(), signUpRequest.getSiteInstagram(),  signUpRequest.getSiteTwitter(), signUpRequest.getLogo(),signUpRequest.getDescription(),signUpRequest.getProviders(), signUpRequest.getRoles(),
				 signUpRequest.getCompanyOwners(), signUpRequest.getFirstNameOwner(), signUpRequest.getLastNameOwner(),signUpRequest.getMeansPayment() , signUpRequest.getPercentage(), signUpRequest.getCompanyID(),
				signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));

		/*//Set<Role> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		//if (strRoles == null) {

			Role rolecomp = new Role();
			rolecomp.setName(ERole.ROLE_ADMIN);
			Role savedRole = roleRepository.save(rolecomp);
			//Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					//.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			//roles.add(savedRole);
			roles.add(savedRole); // Add the newly created role to the company's roles set
			company.setRoles(roles); // Set the roles for the company
			//signUpRequest.getRoles().add(rolecomp);
		//signUpRequest.setRoles(roles);
		//}

		//company.setRoles(roles);*/



		CompanyOwners owner = new CompanyOwners();
		owner.setFirstName(signUpRequest.getFirstNameOwner());
		owner.setLastName(signUpRequest.getLastNameOwner());
		//owner.setCompany(company);
		CompanyOwners savedOwner = companyOwnerRepository.save(owner);

		Set<CompanyOwners> ownercompany = new HashSet<>();
		ownercompany.add(savedOwner);
		company.setCompanyOwners(ownercompany);


		Set<Role> roles = new HashSet<>();

		Role rolecomp = new Role();
		rolecomp.setName(ERole.ROLE_ADMIN);
		Role savedRole = roleRepository.save(rolecomp);

		roles.add(savedRole); // Add the newly created role to the roles set

		company.setRoles(roles); // Set the roles for the company
		CompanyRepository.save(company);

		return ResponseEntity.ok(new MessageResponse("company registered successfully!"));

	}

	//@PostMapping("/signupProviderCompany/{id}")
	@PostMapping(value = "/signupProviderCompany/{id}")
	public ResponseEntity<?> registerProviderToCompany(@PathVariable Long id, @RequestBody Mou3inaEntity signUpRequest) {
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
				signUpRequest.getVideo(),  signUpRequest.getEmailAdress(), signUpRequest.getVip(), signUpRequest.getComment(), signUpRequest.getAvailibility(),
				signUpRequest.getRib() ,  signUpRequest.getCooptedByID(), signUpRequest.getGradeAverage(),
				signUpRequest.getHasASmartPhone(),  signUpRequest.getPhoto(), signUpRequest.getName(), signUpRequest.getImage(),
				signUpRequest.getCopie(),signUpRequest.getOperational_Id(),
				signUpRequest.getStatus(),/*signUpRequest.getReclamation(),*/signUpRequest.getServiceType(),signUpRequest.getProcessInstanceID(),signUpRequest.getDocState(),signUpRequest.getTokenDevice(), signUpRequest.getN(), signUpRequest.getCommissionPercentage(), signUpRequest.getNbfavoris(), signUpRequest.getNbServicesDone(),signUpRequest.getSalary(),signUpRequest.getEmploymentStatus(),signUpRequest.getCompany(),signUpRequest.getWorkDaysByMonth(),signUpRequest.getMorningCost(), signUpRequest.getAfternoonCost(), signUpRequest.getEveningCost(), signUpRequest.getServiceCost(), signUpRequest.getServicesDone(), signUpRequest.getDevice(),signUpRequest.getRoles(),/* signUpRequest.getWeeklyCost(),*/ signUpRequest.getLastResetDate(),
				signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword())
		);


		Set<Role> roles = new HashSet<>();
		Role roleProvider = new Role();
		roleProvider.setName(ERole.ROLE_USER);
		Role savedRole = roleRepository.save(roleProvider);
		roles.add(savedRole); // Add the newly created role to the roles set
		mou3ina.setRoles(roles); // Set the roles for the provider
		mou3ina.setEmploymentStatus(EmploymentStatus.salaried_employee);
		mou3ina.setNbfavoris(0);
		//mou3ina.setServicesDone(0);
		mou3ina.setDocState(DocState.VERIFIED);
		mou3ina.setN((float) Math.min(Math.max(mou3ina.getN(), 0.02), 0.1));  // sets default value to 2%, and maximum value to 10%
		CleaningServicesCompany company= CompanyRepository.findById(id).get();
		company.getProviders().add(mou3ina);
		userRepository.save(mou3ina);
		CompanyRepository.save(company);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
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
