package com.job.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.api.models.Job;
import com.job.api.repository.JobRepository;

@Service
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	public Job buscarPeloId(Long id) {
		return this.jobRepository.findById(id).orElse(null);
	}
}
