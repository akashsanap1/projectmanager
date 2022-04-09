package com.projectmanager.service;


import com.projectmanager.entity.Projects;
import com.projectmanager.entity.SystemUser;

public interface Service {
	SystemUser saveUser(SystemUser user);

	public SystemUser fetchUserByEmailId(String email);

	public SystemUser fetchUserByEmailIdAndPassword(String email, String password);
	
	Projects saveall(Projects projects);
}
