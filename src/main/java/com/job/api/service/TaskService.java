package com.job.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.api.models.Task;
import com.job.api.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Task buscarPeloId(Long id) {
		return this.taskRepository.findById(id).orElse(null);
	}
}
