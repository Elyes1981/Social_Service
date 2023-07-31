package com.sofrecom.operation.customer.controller;


import com.sofrecom.operation.customer.dao.CustomerRepository;
import com.sofrecom.operation.customer.entities.Customer;
import com.sofrecom.operation.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerRepository customerRepository ;
	@Autowired
	  private JavaMailSender javaMailSender; 
	 /*@Autowired
	  PasswordEncoder encoder;*/
	   public static String generateRandomPassword(int len) {
			String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
	          +"lmnopqrstuvwxyz!@#$%&";
			Random rnd = new Random();
			StringBuilder sb = new StringBuilder(len);
			for (int i = 0; i < len; i++)
				sb.append(chars.charAt(rnd.nextInt(chars.length())));
			return sb.toString();
		}

	@GetMapping(value = "/customers")
	public List<Customer> findAllcustomers() {
		return customerService.findAll();
	}

	@GetMapping(value = "/numberCustomers")
	public Long findnumberCustomerDe() {
		return (long) customerService.findAll().size();
	}

	@GetMapping(value = "/customers/{id}")
	public Customer findoneCustomer(@PathVariable Long id) {
		return customerService.findCustomer(id);
		
	}

	@GetMapping(value = "/customereli/{e}")
	public List<Customer> findByDeligation(@PathVariable long e) {

		return customerRepository.findByDeligation(e);
	}

	@PostMapping(value ="/customers")
	public Customer addCustomer(@RequestBody Customer m) {
	//	String pass =  generateRandomPassword(8);
		//encoder.encode(pass);
	//	m.setPassword(pass);
		
	//	SimpleMailMessage msg = new SimpleMailMessage();
	    //  msg.setTo(m.getEmailAdress());

	     // msg.setSubject("Username & Password");
	  //    msg.setText("Hello \n"+m.getFirstName()+" "+m.getLastName()+ " \n this is your username : \n "+m.getUsername().toString()+ "\n and your password :\n"+m.getPassword().toString()+"\n you may change them in your first sign in");

	    //  javaMailSender.send(msg);
		return customerService.addCustomer(m);
		
		
	}

	
	@PutMapping(value ="/customers/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer p) {
	p.setId(id);
		return customerService.updateCustomer(p);
		
	}


	

	@DeleteMapping(value = "/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}

    @GetMapping("/test")
    public Double calculateDistance() {

		Double lat1 = 35.825603; // Latitude du femmeMenage  35.825603
		Double lon1 = 10.608395; // Longitude du femmeMenage  10.608395
		Double lat2 = 34.747847; // Latitude du Customer 		34.747847
		Double lon2 = 10.766163; // Longitude du Customer		10.766163

        // Convertir les coordonnées en radians
        Double radLat1 = Math.toRadians(lat1);
        Double radLon1 = Math.toRadians(lon1);
        Double radLat2 = Math.toRadians(lat2);
        Double radLon2 = Math.toRadians(lon2);

        // Calculer la différence de longitude et de latitude
        Double diffLon = radLon2 - radLon1;
        Double diffLat = radLat2 - radLat1;

        // Appliquer la formule de la distance entre deux points GPS
        Double a = Math.sin(diffLat / 2) * Math.sin(diffLat / 2) +
                Math.cos(radLat1) * Math.cos(radLat2) *
                        Math.sin(diffLon / 2) * Math.sin(diffLon / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double distance = 6371 * c; // Rayon de la Terre en kilomètres

        return distance;
    }

   /* public static void main(String[] args) {
        // Exemple d'utilisation
        double lat1 = 48.8566; // Latitude du femmeMenage
        double lon1 = 2.3522; // Longitude du femmeMenage
        double lat2 = 51.5074; // Latitude du Customer
        double lon2 = -0.1278; // Longitude du Customer

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Distance: " + distance + " km");
    }*/




}


