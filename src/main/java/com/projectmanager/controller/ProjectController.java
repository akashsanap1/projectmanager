package com.projectmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanager.entity.Projects;
import com.projectmanager.service.Service;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("projects")
public class ProjectController {

	@Autowired
	private Service service;
	
	
//	public ResponseEntity<Projects> registerUser(@RequestBody Projects user) {
//		
//		return new ResponseEntity<Projects>(service.saveall(user) ,HttpStatus.CREATED);
//		}
	@PostMapping("/addproject")
	public Projects registerUser(@RequestBody Projects user) {
	
	return service.saveAll(user);
	}

	
}
