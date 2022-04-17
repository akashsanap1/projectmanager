package com.projectmanager.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;
	private int userid;
	private String skillSet;
	private String experience;
	private int currentProjectId;
	private String currentProject;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date releaseDate;
	private String emailId;
	private String fileName;
	private String fileType;
	private String userName;
	private int newProjectId;
	private String newProject;
	private int projectChangeId;
	@Lob
	private byte[] data;
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(int profileId, int userid, String skillSet, String experience, int currentProjectId,
			String currentProject, Date releaseDate, String emailId, String fileName, String fileType, String userName,
			int newProjectId, String newProject, int projectChangeId, byte[] data) {
		super();
		this.profileId = profileId;
		this.userid = userid;
		this.skillSet = skillSet;
		this.experience = experience;
		this.currentProjectId = currentProjectId;
		this.currentProject = currentProject;
		this.releaseDate = releaseDate;
		this.emailId = emailId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.userName = userName;
		this.newProjectId = newProjectId;
		this.newProject = newProject;
		this.projectChangeId = projectChangeId;
		this.data = data;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public int getCurrentProjectId() {
		return currentProjectId;
	}
	public void setCurrentProjectId(int currentProjectId) {
		this.currentProjectId = currentProjectId;
	}
	public String getCurrentProject() {
		return currentProject;
	}
	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getNewProjectId() {
		return newProjectId;
	}
	public void setNewProjectId(int newProjectId) {
		this.newProjectId = newProjectId;
	}
	public String getNewProject() {
		return newProject;
	}
	public void setNewProject(String newProject) {
		this.newProject = newProject;
	}
	public int getProjectChangeId() {
		return projectChangeId;
	}
	public void setProjectChangeId(int projectChangeId) {
		this.projectChangeId = projectChangeId;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	
}