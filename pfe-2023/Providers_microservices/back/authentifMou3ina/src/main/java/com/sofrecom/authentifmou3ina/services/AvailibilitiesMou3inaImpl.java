package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.AvailibilitiesMou3ina;
import com.sofrecom.authentifmou3ina.repository.AvailibilitiesMou3inaRepository;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;


@Service
public class AvailibilitiesMou3inaImpl implements IAvailibilitiesMou3ina {
	@Autowired
	AvailibilitiesMou3inaRepository AvailibilitiesMou3inaRepository;

	@Value("${spring.workflow.keydefinitionname}")
	private String keyDefinition ;

	@Autowired
	private TaskService taskService;




	@Override
	public AvailibilitiesMou3ina addAvailibilitiesMou3ina(AvailibilitiesMou3ina m) {
		/*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(keyDefinition).taskAssignee("demo").list();
		System.out.println(tasks);
		//if (tasks != null && !tasks.isEmpty()) {
		Task task = tasks.get(0);
		//System.out.println(task);
		//processEngine.getTaskService().setVariable("state" ,"accepted" ,true);
		processEngine.getTaskService().setVariable(task.getId(), "isValid", false);
		processEngine.getTaskService().complete(task.getId());*/
		return AvailibilitiesMou3inaRepository.save(m);
	}

	@Override
	public List<AvailibilitiesMou3ina> findAll() {

		return AvailibilitiesMou3inaRepository.findAll();
	}

	@Override
	public List<AvailibilitiesMou3ina> findMorning() {
		return null;
	}

	@Override
	public AvailibilitiesMou3ina updateAvailibilitiesMou3ina(AvailibilitiesMou3ina p) {
		return AvailibilitiesMou3inaRepository.saveAndFlush(p);

	}

	public static int getNumberOfDaysInMonth(int year, int month) {
		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		return daysInMonth;
	}

	@Override
	public List<Float> findWeekndByMou3ina(Long id, int year) {
		List<AvailibilitiesMou3ina> allweek = new ArrayList<AvailibilitiesMou3ina>();
 		return null;
				//allweekwek.stream().collect(Collectors.groupingBy(p -> Month.from(p.getDate()), Collectors.counting()));
	}

}



