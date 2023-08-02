package com.corenuts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corenuts.entity.Assignment;


public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

	
}
