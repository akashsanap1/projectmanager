package com.projectmanager.controller;

import java.io.IOException;
import java.net.MalformedURLException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

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
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projectmanager.entity.Documents;
import com.projectmanager.entity.Leaves;
import com.projectmanager.entity.Profile;
import com.projectmanager.entity.ResponseFile;
import com.projectmanager.entity.ResponseMessage;
import com.projectmanager.repository.DocumentRepository;
import com.projectmanager.service.Service;
import com.projectmanager.service.ServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("profile")
public class ProfileController {

	@Autowired
	private Service service;

	@GetMapping("/getCompleteProfile")
	public List<Profile> getLeavesData() {
		List<Profile> profile = service.getAllProfileData();
		return profile;
	}

	@PostMapping("/addprofile")
	public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile) {
		Profile saveProfile = service.saveProfile(profile);
		return new ResponseEntity<Profile>(saveProfile, HttpStatus.CREATED);
	}

	@GetMapping("/getProfile/{id}")
	public List<Profile> getProjectDetails(@PathVariable("id") int projectId) {
		List<Profile> getDetails = service.getProjects(projectId);
		return getDetails;
	}

	// apply new project
	@PutMapping("/applynewproject/{id}")
	public Profile update(@PathVariable("id") int pId, @RequestBody Profile profile) {
		return service.applyForNewProject(profile, pId);
	}

	// get profiles who applied new projects for internal project change => add
	// employee
	@GetMapping("/profilesbychangeid")
	public List<Profile> getProfilesByProjectChangeId() {
		List<Profile> profile = service.getProfilesByProjectChangeId(1);
		return profile;
	}

	// change in profiles who applied new projects for internal project change =>
	// add employee
	@PutMapping("/changeproject/{id}")
	public Profile changeThePrject(@PathVariable("id") int pId, @RequestBody Profile profile) {
		return service.changeTheProjectInternal(profile, pId);
	}
	  
	@GetMapping("/profile/{id}")
	public  Optional<Profile> getProfil(@PathVariable("id") int userId) {
		Optional<Profile> profile = service.getProfileForProjectChangeByManager(userId);
		return profile;
	}
	
	@PutMapping("/applyinternalproject/{id}")
	public Profile updateadminProject(@PathVariable ("id") int id, @RequestBody Profile  profile)
	{
		return service.applyNewProjectIn(profile,id);
	}

	
}
