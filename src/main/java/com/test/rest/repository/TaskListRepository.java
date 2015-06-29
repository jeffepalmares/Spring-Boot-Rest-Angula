package com.test.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.rest.entity.TaskList;

public interface TaskListRepository extends JpaRepository<TaskList, Integer>{

}
