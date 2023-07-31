package com.sofrecom.operation.admin.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.operation.admin.dao.CustomerRepository;
import com.sofrecom.operation.admin.dao.RoleRepository;
import com.sofrecom.operation.admin.entities.ERole;
import com.sofrecom.operation.admin.entities.Gender;
import com.sofrecom.operation.admin.entities.Gouvernorat;
import com.sofrecom.operation.admin.entities.Mou3inaEntity;
import com.sofrecom.operation.admin.entities.ResidenceType;
import com.sofrecom.operation.admin.entities.Role;
import com.sofrecom.operation.admin.entities.Status;
import com.sofrecom.operation.admin.entities.Agent;
import com.sofrecom.operation.admin.entities.CooptedByType;
import com.sofrecom.operation.admin.entities.Customer;
import com.sofrecom.operation.admin.entities.Delegation;
import com.sofrecom.operation.admin.payload.request.LoginRequest;
import com.sofrecom.operation.admin.payload.request.SignupRequest;
import com.sofrecom.operation.admin.payload.response.JwtResponse;
import com.sofrecom.operation.admin.payload.response.MessageResponse;
import com.sofrecom.operation.admin.security.jwt.JwtUtils;
import com.sofrecom.operation.admin.service.CustomerService;
import com.sofrecom.operation.admin.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  CustomerRepository userRepository;

  Customer customer;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  @Autowired
	CustomerService customerService;
  @Autowired
  private JavaMailSender javaMailSender; 
 
  
  @PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam String username) {

		String response = customerService.forgotPassword(username);
      Customer customer= userRepository.findByUsername(username);
		if (!response.startsWith("Invalid")) {
			response = "http://localhost:4200/reset-password/" + response;
		}
		 SimpleMailMessage msg = new SimpleMailMessage();
	      msg.setTo(customer.getEmailAdress());

	      msg.setSubject("Forget Password");
	      msg.setText("Hello  \n follow this link to change your password!! \n "+response);

	      javaMailSender.send(msg);
		//sendEmailpassword( email);
		return response;
	}

	@PutMapping("/reset-password")
	public String resetPassword(@RequestParam String token,
			@RequestParam String password) {

		return customerService.ResetPassword(token, password);
	}

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody  Customer m) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(m.getUsername(), m.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                       
                         userDetails.getPassword(),
                         userDetails.getId(),
                         userDetails.getUsername(),
                        
                         roles,
                         
                         userDetails.getFirstName(),
                         userDetails.getLastName(),
                         userDetails.getGender(),
                         userDetails.getAgent(),
                         userDetails.getBirthDate(),
                         userDetails.getStatus(),
                         userDetails.getPhone(),
                         userDetails.getGouvernerat(),
                         userDetails.getDelegation(),
                         userDetails.getHome_Adress(),
                         userDetails.getHome_Adress_GPS_long(),
                         userDetails.getHome_Adress_GPS_latt(),
                         userDetails.getEmailAdress(), 
                         userDetails.getPaymentMean(),
                         userDetails.getCreditCardNumber(),
                         userDetails.getCooptedById(),
                         userDetails.getCooptedByType(),
                         userDetails.getCreditCardCVV2(),
                         userDetails.getResidenceType(),
                         userDetails.getCreditCardExpireDate(),
                         userDetails.getResidenceNumberOfrooms(),
                         userDetails.getNumberOfPersonInRes(),
                         userDetails.getMetrage(),
                         userDetails.getPhoto(),
                         userDetails.getImage(),
                         userDetails.getMou3inas_preferences(),
                         userDetails.getMou3inas_blacklist()
                        
                        
                      
                         ));
    /*String token, String type, Long id, String username, List<String> roles,
	@Size(min = 2, message = "firstName must be >2 characters long.") String firstName,
	@Size(min = 2, message = "LastName must be >2 characters long.") String lastName, Gender gender,
	Agent agent, Date birthDate, Status status, String phone, Gouvernorat gouvernerat, Delegation delegation,
	@Size(min = 6, message = "Home Adress must be more than 6 characters long.") String home_Adress,
	Float home_Adress_GPS_long, Float home_Adress_GPS_latt,
	@Email(message = "Enter a valid email address.") String emailAdress, String paymentMean,
	Long creditCardNumber, Long cooptedById, CooptedByType cooptedByType, Long creditCardCVV2,
	ResidenceType residenceType,
	@FutureOrPresent(message = "Date input is invalid for an Expiration Date.") Date creditCardExpireDate,
	@Min(1) @Max(10) Long residenceNumberOfrooms, @Min(1) @Max(10) Long numberOfPersonInRes, Long metrage,
	String photo, byte[] image, Collection<Mou3inaEntity> mou3inas_preferences,
	Collection<Mou3inaEntity> mou3inas_blacklist*/
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody Customer m) {
	  
    if (userRepository.existsByUsername(m.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmailAdress(m.getEmailAdress())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }
  // encoder.encode(m.getPassword());
    // Create new user's account
  // Customer user = new Customer( encoder.encode(m.getPassword()),m.getUsername(),m.getDelegation(),m.getBirthDate(),m.getEmailAdress(),m.getFirstName(),m.getLastName());
    Customer user = new Customer(m.getId(),m.getUsername(),encoder.encode(m.getPassword()),m.getRoles(),m.getFirstName(),m.getLastName(),m.getGender(),m.getAgent(),m.getBirthDate(),m.getStatus(),m.getPhone(),m.getGouvernerat(),m.getDelegation(),m.getHome_Adress(),m.getHome_Adress_GPS_long(),m.getHome_Adress_GPS_latt(),m.getEmailAdress(),m.getPaymentMean(),m.getCreditCardNumber(),m.getCooptedById(),m.getCooptedByType(),m.getCreditCardCVV2(),m.getResidenceType(),m.getCreditCardExpireDate(),m.getResidenceNumberOfrooms(),m.getNumberOfPersonInRes(),m.getMetrage(),m.getPhoto(),m.getImage(),m.getMou3inas_preferences(),m.getMou3inas_blacklist());

	Set<Role> strRoles = m.getRoles();
	Set<Role> roles = new HashSet<>();

	if (strRoles == null) {
		Role userRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
	} 

user.setRoles(roles);
	userRepository.save(user);

	return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
}
}