package com.sofrecom.authentifmou3ina.services;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
		//CleaningServicesCompany compnay = companyRepository.findById(id).get();
		m.setProcessInstanceID(processInstancrId);
		m.setDocState(DocState.NO_DOCUMENT_UPLOADED);
		//m.setEmploymentStatus(EmploymentStatus.self_employed);
		m.setFixedPart(40);
		m.setNbfavoris(0);
		m.setNbPrestations(0);
		m.setN((float) Math.min(Math.max(m.getN(), 0.02), 0.1));  // sets default value to 2%, and maximum value to 10%
		m.setM((float) Math.min(Math.max(m.getM(), 0.1), 0.2));
		float salary = (float) (m.getFixedPart() + (m.getN() * m.getNbfavoris().doubleValue() * m.getFixedPart()) + ((m.getNbPrestations().doubleValue()/ 31) * m.getM() * m.getFixedPart()));
		m.setSalary(salary);
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
		List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(keyDefinition).taskAssignee("demo").list();
		System.out.println(tasks);
		//if (tasks != null && !tasks.isEmpty()) {
		Task task = tasks.get(0);
		//System.out.println(task);
		//processEngine.getTaskService().setVariable("state" ,"accepted" ,true);
		processEngine.getTaskService().setVariable(task.getId(), "isValid", true);
		processEngine.getTaskService().complete(task.getId());
		Mou3inaEntity mou3ina = mou3inaRepository.findById(id).get();
		mou3ina.setDocState(DocState.VERIFIED);
		mou3inaRepository.save(mou3ina);
		return mou3ina;
	}

	@Override
	public Mou3inaEntity DismissDoc(Long id) {
		/*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(keyDefinition).taskAssignee("demo").list();
		System.out.println(tasks);
		//if (tasks != null && !tasks.isEmpty()) {
		Task task = tasks.get(0);
		//System.out.println(task);
		//processEngine.getTaskService().setVariable("state" ,"accepted" ,true);
		processEngine.getTaskService().setVariable(task.getId(), "isValid", true);
		processEngine.getTaskService().complete(task.getId());*/
		Mou3inaEntity mou3ina = mou3inaRepository.findById(id).get();
		mou3ina.setDocState(DocState.NOT_VERIFIED);
		mou3inaRepository.save(mou3ina);
		return mou3ina;
	}


	//+ ajout critere de distance
	@Override
	public String CalculSalary(Long id ) {
		float salary ;
		String map ="";
		Mou3inaEntity mou3ina = mou3inaRepository.findById(id).get();
		//float salary = (float) (mou3ina.getFixedPart() + (mou3ina.getN() * mou3ina.getNbfavoris().doubleValue() * mou3ina.getFixedPart()) + ((mou3ina.getNbPrestations().doubleValue()/ 31) * mou3ina.getM() * mou3ina.getFixedPart()));
		//mou3ina.setSalary(salary);
		if (mou3ina.getNbPrestations().intValue() <  15) {
			salary = (float) (mou3ina.getSalary() * mou3ina.getN());
			mou3ina.setSalary(salary); // diminuer de 10%
		}
		else {
			salary = (float)(mou3ina.getSalary());
		}
		mou3inaRepository.save(mou3ina);
		map = "The Salary of "+mou3ina.getFirstName()+mou3ina.getLastName()+"is"+salary+"dinars";
		return map;

	}

	/*@Override
	public String costService(Long id) {

	}*/
}
	




	

	


	
	


