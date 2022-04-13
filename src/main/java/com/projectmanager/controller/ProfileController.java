package com.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanager.entity.Leaves;
import com.projectmanager.entity.Profile;
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
		
	
}