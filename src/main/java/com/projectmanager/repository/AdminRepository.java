package com.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmanager.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByEmailId(String email);
    public Admin findByEmailIdAndPassword(String email, String password);
}
