package com.projectmanager.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.core.io.Resource;
//
//import org.springframework.boot.context.config.Profiles;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projectmanager.entity.Documents;
import com.projectmanager.entity.Leaves;
import com.projectmanager.entity.Profile;
import com.projectmanager.entity.ResponseMessage;
import com.projectmanager.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("profile")
public class ProfileController {
	
	@Autowired
	private Service service;
	
	@GetMapping("/getCompleteProfile")
    public List<Profile> getLeavesData() {
        List<Profile> profile= service.getAllProfileData();
        return profile;
    }
	
	@PostMapping("/addprofile")
	public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile )
	{
		Profile saveProfile = service.saveProfile(profile);
		return new ResponseEntity<Profile>(saveProfile, HttpStatus.CREATED);
	}
	
	@GetMapping("/getProfile/{id}")
	public List<Profile> getProjectDetails(@PathVariable("id") int projectId){
		List<Profile> getDetails=service.getProjects(projectId);
		return getDetails;
	}
	
	
	// File Upload and Download from Document Entity
	
	 @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	      service.store(file);
	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	
	 @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable int id) {
	    Documents document = service.getFile(id);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
	        .body(document.getData());
	  }

	  
	  // apply new project 
	  @PutMapping("/applynewproject/{id}")
		public Profile update( @PathVariable("id") int pId,@RequestBody Profile profile) {
			return service.applyForNewProject(profile,pId);
		}
	  
	  // get profiles who applied new projects for internal project change => add employee
	  @GetMapping("/profilesbychangeid")
	    public List<Profile> getProfilesByProjectChangeId() {
	        List<Profile> profile= service.getProfilesByProjectChangeId(1);
	        return profile;
	    }
	  
	// change in  profiles who applied new projects for internal project change => add employee
	  @PutMapping("/changeproject/{id}")
		public Profile changeThePrject( @PathVariable("id") int pId,@RequestBody Profile profile) {
			return service.changeTheProjectInternal(profile,pId);
		}
	
}

