package com.corenuts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corenuts.entity.StudentDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, Integer> {

}
