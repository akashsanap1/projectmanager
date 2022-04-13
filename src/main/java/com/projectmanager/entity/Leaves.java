package com.projectmanager.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Leaves {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int leaveId;
	int userId;
	String userName;
	String projectName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date endDate;
	String reason;
	String status;
	
	public Leaves() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Leaves(int leaveId, int userId, String userName, String projectName, Date startDate, Date endDate,
			String reason, String status) {
		super();
		this.leaveId = leaveId;
		this.userId = userId;
		this.userName = userName;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
	}


	public int getLeaveId() {
		return leaveId;
	}


	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
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


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	
}
