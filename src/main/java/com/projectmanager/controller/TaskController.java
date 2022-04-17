package com.projectmanager.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanager.entity.Leaves;
import com.projectmanager.entity.Profile;
import com.projectmanager.entity.Task;
import com.projectmanager.repository.TaskRepository;
import com.projectmanager.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("task")
public class TaskController {

	@Autowired
	private Service service;
	
	 Task task;
	 @Autowired
	 TaskRepository taskrepo;
	// adding task details
	@PostMapping("/addtask")
	public ResponseEntity<Task> saveTaskDetails(@RequestBody Task task) {
		Task saveTasks = service.saveTask(task);
		return new ResponseEntity<Task>(saveTasks, HttpStatus.CREATED);
	}

	// to get Profile data to add task
	@GetMapping("/getprofiledata/{id}")
	public Optional<Profile> getProfile(@PathVariable("id") int userId) {
		Optional<Profile> profile = service.getProfileData(userId);
		return profile;
	}

	// String email="akashsanap0000@gmail.com";

	@PostMapping("/email")
	public void run(@RequestBody String email) {
		// email=this.email;
		System.out.println(email);
		service.sendMail(email, "New Task Assigned", "You have been assigned new task, please check it out");
	}

	// Get Data from Task for admin 
	@GetMapping("/getalltasks")
	public List<Task> getProfile() {
		List<Task> taskdata = service.getTasksData();
		return taskdata;
	}

	// Get Data from task by id of user
	@GetMapping("/getAlltasksdata/{id}")
	public List<Task> getAllTasks(@PathVariable("id") int id) {
		List<Task> taskdata = service.getAllTasks(id);
		return taskdata;
	}

	// update status of task
	@PutMapping("/update/{id}")
	public Task update(@PathVariable("id") int taskId,@RequestBody Task status ) {
		return service.updateStatus(taskId,status);
	}
	
	
	// to send mail from user 
	@PostMapping("/emailbyuser/{id}")
	public void SendMail(@PathVariable("id") int userid, @RequestBody Task task) {
		// email=this.email;
		Task user=taskrepo.findByTaskId(userid);
		//System.out.println();
		service.sendMailByUser("manager.cashmanagement@gmail.com", "Task Status Updated",  user.getUserName() +" has Completed his work");
	}
}
