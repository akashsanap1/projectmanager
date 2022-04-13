package com.projectmanager.service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.validation.constraints.Email;

import org.springframework.mail.javamail.JavaMailSender;

import com.projectmanager.entity.Leaves;
import com.projectmanager.entity.Profile;
import com.projectmanager.entity.Projects;
import com.projectmanager.entity.SystemUser;
import com.projectmanager.entity.Task;

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
	
	public List<Profile> getProjects(int id);
	
	public Task saveTask(Task task);
	
	public Optional<Profile> getProfileData(int id);
	
	public List<Profile> getAllProfileData();
	
	public void sendMail(String email, String subject, String body);
	
	public List<Task> getTasksData();
}
