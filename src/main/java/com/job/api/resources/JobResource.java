package com.job.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.api.models.Job;
import com.job.api.repository.JobRepository;

@RestController
@RequestMapping("/jobs")
public class JobResource {
	
	@Autowired
	JobRepository jobRepository;
	
	@GetMapping
	public List<Job> lista(){
		return jobRepository.findAll();
	}
}
