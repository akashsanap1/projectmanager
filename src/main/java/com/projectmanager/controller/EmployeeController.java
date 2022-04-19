package com.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanager.entity.Documents;
import com.projectmanager.entity.Profile;
import com.projectmanager.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("document")
public class EmployeeController {

	@Autowired
	private Service service;
	
}
