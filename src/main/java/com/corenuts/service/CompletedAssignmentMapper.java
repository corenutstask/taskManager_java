package com.corenuts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corenuts.dto.CompletedAssingmentDTO;
import com.corenuts.entity.CompletedAssignment;
import com.corenuts.repositories.BatchAssignmentRepository;
import com.corenuts.repositories.StudentRepository;

@Component
public class CompletedAssignmentMapper {
	
	@Autowired
	private BatchAssignmentRepository assignmentRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	

	public CompletedAssignment convertToEntity(CompletedAssingmentDTO dto)
	{
		CompletedAssignment entity=new CompletedAssignment();
		entity.setAssignment_id(assignmentRepository.findById(dto.getAssignment_id()).get());
		entity.setAssingement_completed_id(dto.getAssingement_completed_id());
		entity.setStudent_id (studentRepository.findById(dto.getStudent_id()).get());
		entity.setStatus(dto.getStatus());
		entity.setSubmission_date(dto.getSubmission_date());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	public CompletedAssingmentDTO convertToDTO(CompletedAssignment entity)
	{
		CompletedAssingmentDTO dto=new CompletedAssingmentDTO();
		dto.setAssignment_id(entity.getAssignment_id().getBatch_assignment_id());
		dto.setAssingement_completed_id(entity.getAssingement_completed_id());
		dto.setStudent_id (entity.getStudent_id().getStudent_id());
		dto.setStatus(dto.getStatus());
		dto.setSubmission_date(dto.getSubmission_date());
		dto.setStatus(entity.getStatus());
		return dto;
		
	}
}
