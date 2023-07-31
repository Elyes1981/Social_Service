package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.dao.ResearchResultRepository;
import com.sofrecom.operation.customer.entities.ResearchResult;
import com.sofrecom.operation.customer.entities.ServiceType;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service

public class ResearchResultServiceImpl implements ResearchResultService {
	//@Autowired
	//ResearchResultRepository researchResultRepository;

	@Autowired
	private ResearchResultRepository researchResultRepository;


	public void save(Long id, Long id_mou3ina, String firstname_Mou3ina, String lastname_Mou3ina  , String homeadress_Mou3ina , Collection<ServiceType> serviceTypes){
		ResearchResult researchResult= new ResearchResult();
		researchResult.setId(id);
		researchResult.setId_mou3ina(id_mou3ina);
		researchResult.setFirstname_Mou3ina(firstname_Mou3ina);
		researchResult.setLastname_Mou3ina(lastname_Mou3ina);
		researchResult.setHomeadress_Mou3ina(homeadress_Mou3ina);
		researchResult.setServiceTypes(serviceTypes);
		rechecrcheReport(serviceTypes);


	}
	public static void rechecrcheReport(Collection<ServiceType> serviceTypes) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().processDefinitionKey("Process_0423qz2").taskAssignee("recherche").list();
		for(Task task : tasks){

			System.out.println("id: "+task.getId()+ " name: "+ task.getName());
		}
		Task task =tasks.get(0);
		processEngine.getTaskService().setVariable(task.getId(),"isValid",true);
		processEngine.getTaskService().complete(task.getId());
        /* if (tasks != null && !tasks.isEmpty()) {
            Task task = tasks.get(0);
            processEngine.getTaskService().setVariable(task.getId(), "isValid", true);
            processEngine.getTaskService().createComment(task.getId(),commissionReport.getProcessInstanceId(),comment);
            processEngine.getTaskService().complete(task.getId());
        }
        ReportValidationService.updateReportStatus(commissionReport);*/
	}

	public ResearchResult addResearchResult(ResearchResult m) {
		return researchResultRepository.save(m);
	}

	public void deleteResearchResult(Long id) {

		if (researchResultRepository.findById(id).isPresent())
			researchResultRepository.deleteById(id);
	}

	public ResearchResult updateResearchResult(ResearchResult p) {
		return researchResultRepository.saveAndFlush(p);
	}

	public ResearchResult findResearchResult(Long id) {
		return researchResultRepository.findById(id).get();
	}

	public List<ResearchResult> findAll() {
		return researchResultRepository.findAll();
	}

	

	

}
