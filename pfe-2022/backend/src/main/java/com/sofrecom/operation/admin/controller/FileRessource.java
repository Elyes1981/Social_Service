package com.sofrecom.operation.admin.controller;


import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sofrecom.operation.admin.dao.CustomerRepository;




@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileRessource {
public static final String DIRECTORY ="C://Users/i.chaoua/Downloads/operation-admin-fe-master/src/assets/img/"
;

    @Autowired
    private CustomerRepository customerRepository;


@PostMapping(value = "/upload" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
@Transactional
public ResponseEntity<List<String>> uploadFiles(@RequestParam("id") long id, @RequestParam("files") List<MultipartFile> multipartFiles) throws IOException, InterruptedException{
List<String> filenames = new ArrayList<>();
for(MultipartFile file : multipartFiles) {  
byte[] fileContent = file.getBytes();

Path path = Paths.get(DIRECTORY + id + ".png");
Files.write(path, fileContent);
customerRepository.updateLogoPath(id, DIRECTORY + id + ".png");



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
}}