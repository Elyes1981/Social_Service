package com.sofrecom.authentifmou3ina.services;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sofrecom.authentifmou3ina.entities.*;
import com.sofrecom.authentifmou3ina.repository.CleaningCompanyRepository;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import org.apache.commons.math3.util.Precision;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;







@Service
public class mou3inaImp  implements Imou3inaService{
	@Autowired
	Mou3inaRepository mou3inaRepository ;

	@Autowired
	CleaningCompanyRepository companyRepository;


	@Value("${spring.workflow.keydefinitionname}")
	private String keyDefinition ;
	//public static final String DIRECTORY =  "C://Users/a.mosbah/Downloads/operation-admin-fe-master/operation-admin-fe-master/src/assets/img";

	@Override
	public Mou3inaEntity addMou3ina(Mou3inaEntity m) {
		ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		String processInstancrId= runtimeService.startProcessInstanceByKey(keyDefinition).getProcessInstanceId();
		m.setProcessInstanceID(processInstancrId);
		m.setDocState(DocState.NO_DOCUMENT_UPLOADED);
		m.setEmploymentStatus(EmploymentStatus.self_employed);
		m.setNbfavoris(0);
		m.setNbServicesDone(0);
		m.setN((float) Math.min(Math.max(m.getN(), 0.02), 0.1));  // sets default value to 2%, and maximum value to 10%
		return  mou3inaRepository.save(m);
	}

	@Override
	public void deleteMou3ina(Long id) {
		if(mou3inaRepository.findById(id).isPresent())
			mou3inaRepository.deleteById(id);
		
	}

	@Override
	public Mou3inaEntity updateMou3ina(Mou3inaEntity m) {
		return mou3inaRepository.saveAndFlush(m);
	}

	@Override
	public Mou3inaEntity findMou3ina(Long id) {
		Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
		Path path = Paths.get(mouina.getPhoto());
		Path path2 = Paths.get(mouina.getName());
		try {
			byte[] data = Files.readAllBytes(path);
		
			mouina.setImage(data);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			byte[] data2 = Files.readAllBytes(path2);
			
			mouina.setCopie(data2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mouina;
		 
	}

	@Override
	public Mou3inaEntity findByfirstName(String firstName) {
		return mou3inaRepository.findByFirstName(firstName);
	}

	@Override
	public Mou3inaEntity findByTypeService(String serviceType) {
		return mou3inaRepository.findByServiceType(serviceType);
	}

	@Override
	public ResponseEntity<Object> findAll() {
		  List<Mou3inaEntity> dbMou3inas = mou3inaRepository.findAll();
	        if (dbMou3inas.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	      
	        return new ResponseEntity<>(dbMou3inas, HttpStatus.OK);
	    }

	@Override
	public Mou3inaEntity findMou3inaa(Long id) {
		Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
		return mouina;
	}

	@Override
	public void deleteByProcessInstanceID(String processInstanceID) {
		mou3inaRepository.deleteByProcessInstanceID(processInstanceID);
	}

	@Override
	public Mou3inaEntity ValidateDoc(Long id) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		TaskService taskService = processEngine.getTaskService();
		Mou3inaEntity mou3ina = mou3inaRepository.findById(id).get();
		List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(keyDefinition).taskAssignee("demo").processInstanceId(mou3ina.getProcessInstanceID()).list();
		System.out.println(tasks);
		Task AccuserDocument = null;
		for (Task task : tasks) {
			if ("Accuser la réception du complément de document administratif".equals(task.getName())) {
				AccuserDocument = task;
				break;
			}
		}
		processEngine.getTaskService().setVariable(AccuserDocument.getId(), "isValid", true);
		processEngine.getTaskService().complete(AccuserDocument.getId());
		mou3ina.setDocState(DocState.VERIFIED);
		mou3inaRepository.save(mou3ina);
		return mou3ina;
	}

	@Override
	public Mou3inaEntity DismissDoc(Long id) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		TaskService taskService = processEngine.getTaskService();
		Mou3inaEntity mou3ina = mou3inaRepository.findById(id).get();
		List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(keyDefinition).taskAssignee("demo").processInstanceId(mou3ina.getProcessInstanceID()).list();
		System.out.println(tasks);
		Task AccuserDocument = null;
		for (Task task : tasks) {
			if ("Accuser la réception du complément de document administratif".equals(task.getName())) {
				AccuserDocument = task;
				break;
			}
		}
		processEngine.getTaskService().setVariable(AccuserDocument.getId(), "isValid", false);
		processEngine.getTaskService().complete(AccuserDocument.getId());
		mou3ina.setDocState(DocState.NOT_VERIFIED);
		mou3inaRepository.save(mou3ina);
		return mou3ina;
	}


	//+ ajout critere de distance

	/*@Scheduled(cron = "0 0 0 1 * ?") // exécuté à minuit le premier jour de chaque mois
	@Override
	public void CalculSalary() {
		float salary ;
		//String map ="";
		//Mou3inaEntity mou3ina = mou3inaRepository.findById(id).get();
		List<Mou3inaEntity> salariedEmployees = mou3inaRepository.findSalariedEmployees();
		for (Mou3inaEntity mou3ina : salariedEmployees) {
			//float salary = (float) (mou3ina.getFixedPart() + (mou3ina.getN() * mou3ina.getNbfavoris().doubleValue() * mou3ina.getFixedPart()) + ((mou3ina.getNbPrestations().doubleValue()/ 31) * mou3ina.getM() * mou3ina.getFixedPart()));
			if (mou3ina.getNbServicesDone().intValue() < mou3ina.getWorkDaysByMonth().intValue()) {
				salary = (float) (mou3ina.getSalary() * mou3ina.getN());
				mou3ina.setSalary(salary); // diminuer de 10%
				mou3inaRepository.save(mou3ina);
			}
			mou3inaRepository.save(mou3ina);
		}

		//map = "The Salary of "+mou3ina.getFirstName()+mou3ina.getLastName()+"is"+salary+"dinars";
		//return map;

	}*/

	@Scheduled(cron = "0 0 0 1 * ?") // exécuté à minuit le premier jour de chaque mois
	@Override
	public void RewardService() {
		List<Mou3inaEntity> NonsalariedEmployees = mou3inaRepository.findNonSalariedEmployees();
		for (Mou3inaEntity mou3ina : NonsalariedEmployees) {
			if (mou3ina.getNbServicesDone().intValue()> mou3ina.getWorkDaysByMonth().intValue()){ //workdaysbymonths
				float morningCost = (float) mou3ina.getMorningCost();
				float eveningCost = (float) mou3ina.getEveningCost();
				float afternonCost = (float) mou3ina.getAfternoonCost();
				float Morningreward = morningCost * mou3ina.getN() / 100; // calculate the reward using the percentage N
				float Eveningreward = eveningCost * mou3ina.getN() / 100;
				float Afternonreward = afternonCost * mou3ina.getN() / 100;
				morningCost += Morningreward;
				eveningCost += Eveningreward;
				afternonCost += Afternonreward;
				mou3ina.setMorningCost(morningCost);
				mou3ina.setEveningCost(eveningCost);
				mou3ina.setAfternoonCost(afternonCost);
				mou3inaRepository.save(mou3ina);
				//ajouter une notification de reward vers le provider
				//ajouuter un reward aussi si elle est ajouter favoris
			}
			mou3inaRepository.save(mou3ina);
		}

	}

	@Override
	public void updateCommissionPercentageForAllProviders(double commissionPercentage) {
		List<Mou3inaEntity> providers = (List<Mou3inaEntity>) mou3inaRepository.findByEmploymentStatus(EmploymentStatus.self_employed);
		for (Mou3inaEntity provider : providers) {
			provider.setCommissionPercentage(commissionPercentage);
		}
		mou3inaRepository.saveAll(providers);
	}

	public double getCompanyPercentageById(Long providerId) {
		Optional<CleaningServicesCompany> optionalCompany = companyRepository.findByProvidersId(providerId);
		if (optionalCompany.isPresent()) {
			CleaningServicesCompany company = optionalCompany.get();
			return company.getPercentage();
		} else {
			// Gérer le cas où aucune entreprise n'est associée au fournisseur
			// Vous pouvez renvoyer une valeur par défaut ou générer une exception, selon vos besoins.
			return 0.0; // Par exemple, renvoie 0.0 si aucun pourcentage n'est trouvé
		}
	}


	@Scheduled(cron = "0 0 0 * * SUN") // Exécute la méthode chaque lundi à minuit
	public void resetServicesDone() {
		// Récupérer toutes les femmes de ménage
		List<Mou3inaEntity> mou3inas = mou3inaRepository.findAll();

		// Réinitialiser l'attribut servicesDone et mettre à jour la date de réinitialisation pour chaque femme de ménage
		for (Mou3inaEntity mou3ina : mou3inas) {
			mou3ina.setServicesDone(0);
			mou3ina.setLastResetDate(LocalDate.now());
		}

		// Enregistrer les modifications dans la base de données
		mou3inaRepository.saveAll(mou3inas);
	}

		public Double calculateOccupationRate(Long mou3inaId) {
			 int WORKING_DAYS_IN_WEEK = 6;

			Mou3inaEntity mou3ina = mou3inaRepository.findById(mou3inaId).get();

			Integer servicesDone = mou3ina.getServicesDone();
				if (servicesDone == null) {
					servicesDone = 0;
				}
				Double occupationRate = ((double) servicesDone / WORKING_DAYS_IN_WEEK) * 100 ;
				return occupationRate;

		}

	public Double calculateAverageOccupationRate() {
		List<Mou3inaEntity> mou3inas = mou3inaRepository.findAll();
		int totalMou3inas = mou3inas.size();
		Double sumOccupationRate = 0.0;

		for (Mou3inaEntity mou3ina : mou3inas) {
			Double occupationRate = calculateOccupationRate(mou3ina.getId());
			sumOccupationRate += occupationRate;
		}

		Double averageOccupationRate = sumOccupationRate / totalMou3inas;
		return averageOccupationRate;
	}



}
	




	

	


	
	


