package com.corenuts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corenuts.entity.CompletedAssignment;

public interface CompletedAssignmentRepository extends JpaRepository<CompletedAssignment, Integer> {

}
