package com.test.rest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.rest.entity.TaskList;
import com.test.rest.repository.TaskListRepository;

@Service
public class TaskListServiceImpl implements TaskListService{

	private final TaskListRepository repository;
	
	@Inject
	public TaskListServiceImpl(final TaskListRepository repository) {
		this.repository = repository;
	}
	
	
	@Transactional
	public void save(TaskList taskList) {
		repository.save(taskList);
	}


	@Override
	public List<TaskList> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	@Override
	public void delete(Integer id) {
		repository.delete(id);
		
	}

}
