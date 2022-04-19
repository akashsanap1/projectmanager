package com.projectmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanager.entity.SystemUser;

public interface Repository extends JpaRepository<SystemUser, Integer> {

	public SystemUser findByEmailId(String email);
    public SystemUser findByEmailIdAndPassword(String email, String password);
    //public SystemUser findByResetPasswordToken(String token);
   // public SystemUser findByToken(String token);
    public Optional<SystemUser> findByuserid(int id);
}
