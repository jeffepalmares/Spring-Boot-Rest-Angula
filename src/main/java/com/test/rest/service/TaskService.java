package com.test.rest.service;

import java.util.List;

import com.test.rest.entity.Task;

public interface TaskService {
	public void save(Task task);
	public List<Task> findAll();
	public List<Task> findByListId(Integer listId);
	public void delete(Integer id);
}
