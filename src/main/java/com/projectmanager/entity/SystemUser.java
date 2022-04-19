package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SystemUser {
	private String name;
    @Id
    private int userid;
    private String emailId;
    private String phone;
    private String password;
    private String cpassword;
    private String gender;
    private int authID;
    private int otp;
    private int newProfileCheckId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAuthID() {
		return authID;
	}
	public void setAuthID(int authID) {
		this.authID = authID;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public int getNewProfileCheckId() {
		return newProfileCheckId;
	}
	public void setNewProfileCheckId(int newProfileCheckId) {
		this.newProfileCheckId = newProfileCheckId;
	}
	public SystemUser(String name, int userid, String emailId, String phone, String password, String cpassword,
			String gender, int authID, int otp, int newProfileCheckId) {
		super();
		this.name = name;
		this.userid = userid;
		this.emailId = emailId;
		this.phone = phone;
		this.password = password;
		this.cpassword = cpassword;
		this.gender = gender;
		this.authID = authID;
		this.otp = otp;
		this.newProfileCheckId = newProfileCheckId;
	}
	public SystemUser() {
		super();
	}

    
	
}

