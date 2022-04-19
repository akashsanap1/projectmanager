package com.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projectmanager.entity.FileDB;
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
