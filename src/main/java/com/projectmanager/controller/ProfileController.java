package com.projectmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanager.entity.Profile;
import com.projectmanager.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("profile")
public class ProfileController {
	
	@Autowired
	private Service service;
	
	
	@PostMapping("/addprofile")
	public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile )
	{
		Profile saveProfile = service.saveProfile(profile);
		return new ResponseEntity<Profile>(saveProfile, HttpStatus.CREATED);
	}
	

}

