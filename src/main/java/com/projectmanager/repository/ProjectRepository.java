package com.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmanager.entity.Projects;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Integer>{
	
	public Projects findBypId(int pId);

}
