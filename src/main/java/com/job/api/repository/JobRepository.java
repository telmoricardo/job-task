package com.job.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.api.models.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
