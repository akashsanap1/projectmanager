package com.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmanager.entity.Profile;
import com.projectmanager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	public List<Task> findAllByUserid(int id);
	public Task findByTaskId(int id);
}
