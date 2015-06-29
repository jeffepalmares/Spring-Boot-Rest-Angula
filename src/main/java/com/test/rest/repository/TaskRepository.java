package com.test.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.rest.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

	@Query("SELECT t FROM Task t WHERE taskList.id = :listId")
	public List<Task> find(@Param("listId") Integer lastName);
}
