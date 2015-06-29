package com.test.rest.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.entity.Task;
import com.test.rest.service.TaskService;

@RestController
public class TaskController {

	private final TaskService service;
	
	@Inject
	public TaskController(final TaskService service){
		this.service = service;
	}

	@RequestMapping(value="/saveTask" , method=RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public  void save(@RequestBody  Task task){
		service.save(task);
	}

	@RequestMapping(value="/deleteTask" , method=RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public  void delete(@RequestBody  Task task){
		service.delete(task.getId());
	}
	
	@RequestMapping(value="/findTask" , method=RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Task> find(@RequestBody  Task task){
		return service.findByListId(task.getTaskList().getId()); 
	}
}
