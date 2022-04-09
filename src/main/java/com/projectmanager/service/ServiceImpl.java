package com.projectmanager.service;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.projectmanager.entity.Projects;
import com.projectmanager.entity.SystemUser;
import com.projectmanager.repository.ProjectRepository;
import com.projectmanager.repository.Repository;


@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	private Repository repository;

	@Override
	public SystemUser saveUser(SystemUser user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public SystemUser fetchUserByEmailId(String emailId) {
		 return repository.findByEmailId(emailId);
	}

	@Override
	public SystemUser fetchUserByEmailIdAndPassword(String emailId, String password) {
		return repository.findByEmailIdAndPassword(emailId,password);
	}
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Projects saveAll(Projects projects) {
		return projectRepository.save(projects);
	}
	
	@Override
	public List<Projects> findAll() {
        List<Projects> projectList = new ArrayList<>();
        projectRepository.findAll().forEach(projectList::add);
        return projectList;
        
    }
	
}
