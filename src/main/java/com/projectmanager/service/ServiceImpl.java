package com.projectmanager.service;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectmanager.entity.Leaves;
import com.projectmanager.entity.Profile;
import com.projectmanager.entity.Projects;
import com.projectmanager.entity.SystemUser;
import com.projectmanager.repository.LeaveRepository;
import com.projectmanager.repository.ProfileRepository;
import com.projectmanager.repository.ProjectRepository;
import com.projectmanager.repository.Repository;


@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	private Repository repository;
	
	@Autowired
	private LeaveRepository leaveRepository;
	
	@Autowired
	private ProfileRepository profileRepository;

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
	
	// to add project
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

	@Override
	public Leaves saveLeave(Leaves leaves) {
			return leaveRepository.save(leaves);
		
	}

	@Override
	public Profile saveProfile(Profile profile) {
		Profile profile2=profileRepository.save(profile);
		return profile2;
	}

	@Override
	public Profile getProfile(String emailId) {
		
		Profile profile = profileRepository.findByEmailId(emailId);
        if (profile!=null) {
            return profile;
        } else {
            return null;
        }
	}

	@Override
	public List<Leaves> getLeavesData() {
		List<Leaves> leaves = new ArrayList<>();
        leaveRepository.findAll().forEach(leaves::add);
        return leaves;
	}
	
//	@Override
//	public List<LeavesDetails> findAll() {
//		List<LeavesDetails> leavesList = new ArrayList<>();
//		leaveRepo.findAll().forEach(leavesList::add);
//		return leavesList;
//	}
	
	
	// update leave after decline by project managee
	@Override
	public Leaves update(Leaves leaves,int id) {
		Leaves olddata = null;
		Optional<Leaves> optionaluser = leaveRepository.findById(id);
		if (optionaluser.isPresent()) {
			olddata = optionaluser.get();
			System.out.println(olddata);
			//olddata.setDescription(leaves.getDescription());
			olddata.setReason(leaves.getReason());
			olddata.setStatus(leaves.getStatus());
			leaveRepository.save(olddata);
		} else {
			return new Leaves();
		}
		return olddata;
	}
	
	
	@Override
	public Leaves updateStatus(Leaves status, int id) {
		Leaves olddata = null;
		Optional<Leaves> optionaluser = leaveRepository.findById(id);
		if (optionaluser.isPresent()) {
			olddata = optionaluser.get();
			System.out.println(olddata);
			olddata.setStatus(status.getStatus());
			olddata.setReason(olddata.getReason());
			leaveRepository.save(olddata);
		} else {
			return new Leaves();
		}
		return olddata;
	}
}
