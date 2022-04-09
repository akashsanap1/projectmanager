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
	public void setEmail(String emailId) {
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
	public SystemUser(String name, int userid, String emailId, String phone, String password, String cpassword,
			String gender) {
		super();
		this.name = name;
		this.userid = userid;
		this.emailId = emailId;
		this.phone = phone;
		this.password = password;
		this.cpassword = cpassword;
		this.gender = gender;
	}
	public SystemUser() {
		super();
	}
	@Override
	public String toString() {
		return "SystemUser [name=" + name + ", userid=" + userid + ", emailId=" + emailId + ", phone=" + phone
				+ ", password=" + password + ", cpassword=" + cpassword + ", gender=" + gender + "]";
	}
    
}
