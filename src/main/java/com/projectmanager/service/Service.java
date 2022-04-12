package com.projectmanager.service;


import java.util.List;

import com.projectmanager.entity.Leaves;
import com.projectmanager.entity.Profile;
import com.projectmanager.entity.Projects;
import com.projectmanager.entity.SystemUser;

public interface Service {
	SystemUser saveUser(SystemUser user);

	public SystemUser fetchUserByEmailId(String email);

	public SystemUser fetchUserByEmailIdAndPassword(String email, String password);
	
	public Projects saveAll(Projects projects);
	
	public List<Projects> findAll();
	
	public Leaves saveLeave(Leaves leave);
	
	public Profile saveProfile(Profile profile);
	
	public Profile getProfile(String emailId);
	
	public List<Leaves> getLeavesData();
	
	// public List<Leaves> findAll();
	
	public Leaves update(Leaves leaves,int id);
	
	public Leaves updateStatus(Leaves status,int id);
	
	
}
