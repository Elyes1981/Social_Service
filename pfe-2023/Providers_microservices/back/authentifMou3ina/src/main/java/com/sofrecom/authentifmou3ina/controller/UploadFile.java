package com.sofrecom.authentifmou3ina.controller;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.sofrecom.authentifmou3ina.entities.DocState;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static java.nio.file.Paths.get;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/filee")
public class UploadFile {
	public static final String DIRECTORY ="C://DATA/provider_services_front/operation/src/assets/copie/" + "";
	public static final String DIRECTORYPhoto ="C://DATA/provider_services_front/operation/src/assets/photos/" + "";

	public static final String DIRECTORYCIN ="C://DATA/provider_services_front/operation/src/assets/CIN/" + "";


	//C:\Users\e.bentaher\OneDrive - orange.com\Bureau\operation-admin-fe\src\assets\copie

	    @Autowired
	    private Mou3inaRepository mou3inaRepository;


		@Value("${spring.workflow.keydefinitionname}")
		private String keyDefinition ;

		@Autowired
		private TaskService taskService;



		/////UploadCIN///////////////////////////
	@PostMapping(value = "/uploadd/{id}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Transactional
	public ResponseEntity<List<String>> uploadFiles(@PathVariable("id") Long id, @RequestParam("files") List<MultipartFile> multipartFiles) throws IOException, InterruptedException{
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
		List<String> filenames = new ArrayList<>();
		for(MultipartFile file : multipartFiles) {  
			byte[] fileContent = file.getBytes();
			Path path = Paths.get(DIRECTORYCIN + id + ".png");
			Files.write(path, fileContent);
			mou3inaRepository.updateLogoPath2(id, DIRECTORYCIN + id + ".png");

			Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
			mouina.setDocState(DocState.DOCUMENT_UPLOADED);
			//mou3inaRepository.updateImage(id,fileContent);
			//filenames.add(file.getOriginalFilename());
			//mouina.setImage(fileContent);
			//byte[] data = Files.readAllBytes(path);
		}
		return ResponseEntity.ok().body(filenames);
	}



	///////////////UploadPhoto////////////////////////////////

	@PostMapping(value = "/uploaddd/{id}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Transactional
	public ResponseEntity<List<String>> uploadFile(@PathVariable("id") Long id,  @RequestParam("photo") List<MultipartFile> photo) throws IOException, InterruptedException{
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
		List<String> filenames = new ArrayList<>();
		for(MultipartFile file : photo) {
			byte[] fileContent = file.getBytes();
			Path path = Paths.get(DIRECTORYPhoto + id + ".png");
			Files.write(path, fileContent);
			mou3inaRepository.updateLogoPath(id, DIRECTORYPhoto + id + ".png");
		}
		return ResponseEntity.ok().body(filenames);
	}
		
		// Define a method to download the file
		@GetMapping("download/{filename}")
	    public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
	        Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
	      //   filename = filePath.replace(/^.*\\/, "");
	        if(!Files.exists(filePath)) {
	            throw new FileNotFoundException(filename + " was not found on the server");
	        }
	        Resource resource = new UrlResource(filePath.toUri());
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.add("File-Name", filename);
	        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
	        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
	                .headers(httpHeaders).body(resource);
	    }
		@GetMapping("photo/{filename}")
		public ResponseEntity<Resource> fromDatabaseAsResEntity(@PathVariable("filename") String filename) 
		        throws IOException {

			Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
	        if(!Files.exists(filePath)) {
	            throw new FileNotFoundException(filename + " was not found on the server");
	        }
	        Resource resource = new UrlResource(filePath.toUri());
			
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
		}
	}

