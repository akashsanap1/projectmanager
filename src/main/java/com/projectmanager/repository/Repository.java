package com.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanager.entity.SystemUser;

public interface Repository extends JpaRepository<SystemUser, Integer> {

	public SystemUser findByEmailId(String email);
    public SystemUser findByEmailIdAndPassword(String email, String password);
}
