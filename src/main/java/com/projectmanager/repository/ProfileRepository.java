package com.projectmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanager.entity.Profile;



public interface ProfileRepository extends JpaRepository<Profile, Integer>{

	public Profile findByEmailId(String email);
	public List<Profile> findByCurrentProjectId(int id);

	public List<Profile> findAllByEmailId(String email);
	// to get profiles who wants to change project change internally 
	public List<Profile> findByProjectChangeId(int i);
	
	
	// to change project of employee by owner
	public Optional<Profile> findByuserid(int i);
	

}
