package com.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmanager.entity.Documents;

@Repository
public interface DocumentRepository extends JpaRepository<Documents, String> {

	//public Documents findByFileName(String fileName);
}
