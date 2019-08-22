package com.job.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.api.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
