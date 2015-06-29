package com.test.rest.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.entity.TaskList;
import com.test.rest.service.TaskListService;

@RestController
public class TaskListController {
	
	private final TaskListService service;
	
	@Inject
	public TaskListController(final TaskListService service){
		this.service = service;
	}

	@RequestMapping(value="/save" , method=RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public  void save(@RequestBody  TaskList taskList){
		service.save(taskList);
	}

	@RequestMapping(value="/delete" , method=RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public  void delete(@RequestBody  TaskList taskList){
		service.delete(taskList.getId());
	}
	
	@RequestMapping(value="/find")
	public List<TaskList> find(){
		return service.findAll(); 
	}
	
}
