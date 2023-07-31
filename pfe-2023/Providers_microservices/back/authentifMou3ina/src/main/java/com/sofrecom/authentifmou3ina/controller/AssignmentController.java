



/*
package com.sofrecom.authentifmou3ina.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.c2s.dsif.entities.EdgeServiceDTO;
import com.c2s.dsif.entities.Mapper;
import com.c2s.dsif.entities.Project;
import com.c2s.dsif.entities.ProjectDTO;
import com.c2s.dsif.repositories.ProjectRepository;
import com.c2s.dsif.services.EdgeServiceFeignClient;

@RestController

public class AssignmentController {
	@Autowired
	private EdgeServiceFeignClient edgeServiceFeignClient;
	@Autowired
	private  ProjectRepository projectRepository;
	@Autowired
	private Mapper mapper;
	
	
	
	@PostMapping("/assign/{projectName}")
	public Project assignEdgeservicesToProject(@PathVariable String projectName, @RequestBody List<Long> edgeservicesIds) {
		
	   Project project = projectRepository.getByName(projectName);
	   List<EdgeServiceDTO> edgeservices =edgeServiceFeignClient.retrieveAllEdgeServices();
	   List<EdgeServiceDTO> assignedEdgeServices = edgeservices
	            .stream()
	            .filter(edgeService -> edgeservicesIds.contains(edgeService.getId()))
	            .collect(Collectors.toList());
	   ProjectDTO projectDTO = mapper.toDto(project);
	    projectDTO.setEdgeservices(assignedEdgeServices);
	    project = mapper.toEntity(projectDTO); 
	   projectRepository.save(project);

	  return project;
	}
	
	@GetMapping("/projectdetails/{projectName}")
	public String getProjectDetails (@PathVariable String projectName) {
		
		Project project = projectRepository.getByName(projectName);
		
		List<EdgeServiceDTO> edgeservices =edgeServiceFeignClient.retrieveAllEdgeServices();
		List <Long>assignededgeservices=project.getEdgeservices();
		List<EdgeServiceDTO> assign =  new ArrayList<>();
		
		for (int i=0;i<edgeservices.size();i++) {
			for (int j=0;j<assignededgeservices.size();j++) {
			if((edgeservices.get(i).getId()).equals(assignededgeservices.get(j)) )
				assign.add(edgeservices.get(i)) ;
		}
		} 
		String result = "";
		for (int i=0;i<assign.size();i++) {
			 result += "\n EdgeService " + i +"    Id:  " +assign.get(i).getId()  +"    Name:  "+assign.get(i).getName()+"    ServerPort:    "+assign.get(i).getServerPort();
		}
		
		String details=" Project ID: " + project.getId()  +"\nProject Edgeservices:" + result;
		
		return "Details about "+ projectName+":\n" + details;
		
	}

	@GetMapping("/findusedport")
	public String findUsedPort() {
		
			return "the used port : " + edgeServiceFeignClient.getPort();
	}
	@GetMapping("/findEdgeService/{id}")
	public String retriveEdgeServiceDTO(@PathVariable("id") Long id) {
		EdgeServiceDTO edgeServiceDTO = edgeServiceFeignClient.retrieveEdgeService(id);
	return  "The name of the EdgeService is :" + edgeServiceDTO.getName() + "with serverport "+edgeServiceDTO.getServerPort() ;
		
	}
	
	
	@GetMapping("/findallprojects")
	public List<Project> findAllProjects() {
		return  projectRepository.findAll();
	}
	
	@GetMapping("/findprojectbyid/{id}")
	public Optional<Project> findproject(@PathVariable("id") Long id ) {
		return  projectRepository.findById(id);
	}
	@PostMapping("/addproject")
	public Project createProjecte(@RequestBody Project project) {
		
		return  projectRepository.save(project);
	}
	 
	
	}

*/
