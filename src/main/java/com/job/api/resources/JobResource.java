package com.job.api.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("/{id}")
	public Job buscaPeloId(@PathVariable Long id) {
		Optional<Job> obj = jobRepository.findById(id);
		return obj.orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<Job> criar(@RequestBody Job job, HttpServletResponse response) {
		Job jobSalva = jobRepository.save(job);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(jobSalva.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(jobSalva);
	}
}
