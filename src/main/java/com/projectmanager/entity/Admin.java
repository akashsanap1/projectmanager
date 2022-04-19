package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private int userId;
	private String emailId;
	private String password;
	private int authId;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int userId, String emailId, String password, int authId) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.authId = authId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	
	
	
}
