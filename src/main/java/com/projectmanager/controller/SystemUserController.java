package com.projectmanager.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.projectmanager.entity.Admin;
import com.projectmanager.entity.Documents;
import com.projectmanager.entity.SystemUser;
import com.projectmanager.entity.Task;
import com.projectmanager.service.Service;
import com.projectmanager.service.ServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("user")
public class SystemUserController {

	public String email;
	public String pass;

	@Autowired
	private Service service;

	@PostMapping("/register")
	public ResponseEntity<SystemUser> registerUser(@RequestBody SystemUser user) {


		return new ResponseEntity<SystemUser>(service.saveUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public SystemUser loginUser(@RequestBody SystemUser systemUser) {
		String tmp = null;
		String tempEmailId = systemUser.getEmailId();
		String tempPass = systemUser.getPassword();
		email = tempEmailId;
		pass = tempPass;

		System.out.println(tempEmailId + " " + tempPass);
		SystemUser loginObj = new SystemUser();
		if (tempEmailId != null && tempPass != null) {
			loginObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
			if (loginObj == null)
				tmp = "admin";
			// System.out.println(loginObj.toString());
		}
		if (tmp == "admin") {
			loginObj = valueAdd();
			if (loginObj == null)
				return loginObj;
		}
		return loginObj;
	}

	private SystemUser valueAdd() {
		Admin Object = null;
		Object = service.fetchAdminByEmailIdAndPassword(email, pass);
		SystemUser loginObj1 = new SystemUser();
		if (Object != null) {
			loginObj1.setUserid(Object.getUserId());
			loginObj1.setEmailId(Object.getEmailId());
			loginObj1.setPassword(Object.getPassword());
			loginObj1.setAuthID(Object.getAuthId());
			return loginObj1;
		}
		return null;
	}


	// get userId universally
	@GetMapping("/getuserid/{id}")
	public SystemUser fetchUserByEmaiId(@PathVariable("id") String email) {
		return service.fetchUserByEmailId(email);
	}

	// genarate otp
	@GetMapping("/forget/{id}")
	public SystemUser forget(@PathVariable("id") String email) {
		return service.forget(email);

	}

	// save passw
	@PutMapping("/password/{id}")
	public SystemUser update(@PathVariable("id") String emailId, @RequestBody SystemUser user) {
		return service.changePassword(emailId, user);
	}

	 @PutMapping("/changeIdentification/{id}")
	public SystemUser changeIdentificationId(@PathVariable("id") int id) {
		return service.changeIdentificationId(id);
	}



//	// get user data for UPDATING profile
//	@GetMapping("/getuser/{id}")
//	public getUser
//	{
//		
//	}
	
}