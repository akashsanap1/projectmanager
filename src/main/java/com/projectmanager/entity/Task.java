package com.projectmanager.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int taskId;
	int userid;
	int currentProjectId;
	
	String taskDetails;
	String userName;
	String taskStatus;
	String currentProjectName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date endDate;
			
	String completionDate;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCurrentProjectId() {
		return currentProjectId;
	}

	public void setCurrentProjectId(int currentProjectId) {
		this.currentProjectId = currentProjectId;
	}

	public String getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getCurrentProjectName() {
		return currentProjectName;
	}

	public void setCurrentProjectName(String currentProjectName) {
		this.currentProjectName = currentProjectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public Task(int taskId, int userid, int currentProjectId, String taskDetails, String userName, String taskStatus,
			String currentProjectName, Date startDate, Date endDate, String completionDate) {
		super();
		this.taskId = taskId;
		this.userid = userid;
		this.currentProjectId = currentProjectId;
		this.taskDetails = taskDetails;
		this.userName = userName;
		this.taskStatus = taskStatus;
		this.currentProjectName = currentProjectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.completionDate = completionDate;
	}

	public Task() {
		super();
	}
	
}