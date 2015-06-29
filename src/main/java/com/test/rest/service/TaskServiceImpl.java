package com.test.rest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.test.rest.entity.Task;
import com.test.rest.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	private final TaskRepository repository;
	
	@Inject
	public TaskServiceImpl( final TaskRepository repository ) {
		this.repository = repository; 
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public void save(Task task) {
		repository.save(task);
	}

	@Override
	public List<Task> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Task> findByListId(Integer listId) {
		return repository.find(listId);
	}

}
