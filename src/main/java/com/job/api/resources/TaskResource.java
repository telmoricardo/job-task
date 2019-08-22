package com.job.api.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.job.api.models.Task;
import com.job.api.repository.TaskRepository;
import com.job.api.service.TaskService;

@RestController
@RequestMapping(value="/tasks")
public class TaskResource {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public List<Task> listar() {
		return taskRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long id){
		Task obj = taskService.buscarPeloId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Task> criar(@RequestBody Task task, HttpServletResponse response){
		Task taskSalvo = taskRepository.save(task);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(taskSalvo.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(taskSalvo);
	}
	
}
