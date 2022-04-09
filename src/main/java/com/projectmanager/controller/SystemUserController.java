package com.projectmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanager.entity.SystemUser;
import com.projectmanager.service.Service;
import com.projectmanager.service.ServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("user")
public class SystemUserController {

	@Autowired
	private Service service;
	
	@PostMapping("/register")
	public ResponseEntity<SystemUser> registerUser(@RequestBody SystemUser user) {
		
	return new ResponseEntity<SystemUser>(service.saveUser(user),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
    public SystemUser loginUser(@RequestBody SystemUser  systemUser)  {

        String tempEmailId= systemUser.getEmailId();
        String tempPass= systemUser.getPassword();
        System.out.println(tempEmailId+" "+tempPass);
        SystemUser  loginObj=null;
        if(tempEmailId !=null && tempPass !=null){
            loginObj= service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
            System.out.println(loginObj.toString());
        }
        
        if(loginObj==null)
        {
        	//System.out.println(logIn.getEmail()+" "+logIn.getPassword()+" "+logIn.getName()+" "+logIn..+" "+logIn.getAge()+" "+logIn.getGender());
            //throw new ResourceDoseNotExistException("Bad credentials");
        	System.out.println("Error");
        } 
       return  loginObj;
	
}
}