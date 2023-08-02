package com.corenuts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corenuts.entity.BatchAssignment;

public interface BatchAssignmentRepository extends JpaRepository<BatchAssignment, Integer> {

}
