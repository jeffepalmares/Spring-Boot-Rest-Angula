package com.test.rest.service;

import java.util.List;

import com.test.rest.entity.TaskList;

public interface TaskListService {
	
	public void save(TaskList taskList);
	public List<TaskList> findAll();
	public void delete(Integer id);
}
