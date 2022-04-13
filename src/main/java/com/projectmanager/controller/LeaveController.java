package com.projectmanager.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanager.entity.Leaves;
import com.projectmanager.entity.Profile;
import com.projectmanager.entity.Projects;
import com.projectmanager.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("leave")
public class LeaveController {

	@Autowired
	private Service service;
	
	// add leave
	@PostMapping("/addleave")
	public Leaves addLeave(@RequestBody Leaves leave)
	{
		return service.saveLeave(leave);			
	}
	
	// return profile data of user to apply leave
	@GetMapping("/getprofiledata/{email}")
    public Profile getProfile(@PathVariable ("email") String emailId) {
        Profile profile= service.getProfile(emailId);
        return profile;
    }
	
	
	// return whole data of leaves for table - > leave plan
	@GetMapping("/getleaves")
    public List<Leaves> getLeavesData() {
        List<Leaves> leaves= service.getLeavesData();
        return leaves;
    }
	
//	@GetMapping("/details")
//	public List<LeavesDetails> getDetails(){
//		
//		List<LeavesDetails> list= service.findAll();
//		return list;
//	}
//
	
@PutMapping("/update/{id}")
	
	public Leaves update( @PathVariable("id") int leaveId,@RequestBody Leaves leaves) {
		
		return service.update(leaves,leaveId);
		
	}
	
@PutMapping("/updatestatus/{id}")
	public Leaves updatestatus( @PathVariable("id") int leaveId,@RequestBody Leaves status) {
		
		return service.updateStatus(status,leaveId);
		
	}
	 
	
	
//	@GetMapping("/projectslist")
//    public ResponseEntity<List<Projects>> getProject() {
//        List<Projects> projectList= service.findAll();
//        return ResponseEntity.ok(projectList);
//    }
	
	
}
