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

import com.projectmanager.entity.Profile;
import com.projectmanager.entity.Projects;
import com.projectmanager.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("projects")
public class ProjectController {

	@Autowired
	private Service service;

	@GetMapping("/projectslist")
    public ResponseEntity<List<Projects>> getProject() {
        List<Projects> projectList= service.findAll();
        return ResponseEntity.ok(projectList);
    }

	// to add project
	@PostMapping("/projects")
	public ResponseEntity<Projects> registerUser(@RequestBody Projects user) {
		return new ResponseEntity<Projects>(service.saveAll(user) ,HttpStatus.CREATED);
		}
	
	// get project name for applying new project
	@GetMapping("/getprojectname/{id}")
    public Projects getProject(@PathVariable ("id") int pId) {
        Projects project= service.getProject(pId);
        return project;
    }
	
	
}
