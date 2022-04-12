package com.projectmanager.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Projects {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int pId;
	String pName;
	String pDescription;
	String teamSize;
	String teamLimit;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date startDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date proposedDate;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public String getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(String teamSize) {
		this.teamSize = teamSize;
	}

	public String getTeamLimit() {
		return teamLimit;
	}

	public void setTeamLimit(String teamLimit) {
		this.teamLimit = teamLimit;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getProposedDate() {
		return proposedDate;
	}

	public void setProposedDate(Date proposedDate) {
		this.proposedDate = proposedDate;
	}

	public Projects(int pId, String pName, String pDescription, String teamSize, String teamLimit, Date startDate,
			Date proposedDate) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pDescription = pDescription;
		this.teamSize = teamSize;
		this.teamLimit = teamLimit;
		this.startDate = startDate;
		this.proposedDate = proposedDate;
	}

	public Projects() {
		super();
	}

}
