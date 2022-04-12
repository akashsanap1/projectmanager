package com.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanager.entity.Profile;



public interface ProfileRepository extends JpaRepository<Profile, Integer>{

	public Profile findByEmailId(String email);
}
