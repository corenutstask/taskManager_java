package com.corenuts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corenuts.dto.BatchAssignmentDTO;
import com.corenuts.entity.BatchAssignment;
import com.corenuts.repositories.AssignmentRepository;
import com.corenuts.repositories.BatchRepository;
import com.corenuts.repositories.UserDetailRepository;

@Component
public class BatchAssignmentMapper {

	
	private final AssignmentRepository assignrepo;
	private final BatchRepository batchRepository;
	private final UserDetailRepository userRepo;
	@Autowired
	public BatchAssignmentMapper(AssignmentRepository assignrepo,BatchRepository batchRepository,UserDetailRepository userRepo) {
		this.batchRepository=batchRepository;
		this.assignrepo=assignrepo;
		this.userRepo=userRepo;
	}
	public BatchAssignment convertToEntity(BatchAssignmentDTO dto)
	{
		BatchAssignment assingment=new BatchAssignment();
		assingment.setStatus(dto.getStatus());
		assingment.setBatch_assignment_id(dto.getBatch_assignment_id());
		assingment.setExpiration_date(dto.getExpiration_date());
		assingment.setStart_date(dto.getStart_date());
		assingment.setBatch(batchRepository.findById(dto.getBatch()).get());
		assingment.setAssignment(assignrepo.findById(dto.getAssignment()).get());
		assingment.setCreated_by(userRepo.findById(dto.getCreated_by()).get());
		return assingment;
	}
	
	public BatchAssignmentDTO convertToDTO(BatchAssignment entity)
	{
		BatchAssignmentDTO dto=new BatchAssignmentDTO();
		dto.setStatus(entity.getStatus());
		dto.setBatch_assignment_id(entity.getBatch_assignment_id());
		dto.setExpiration_date(entity.getExpiration_date());
		dto.setStart_date(entity.getStart_date());
		dto.setBatch(entity.getBatch().getBatch_id());
		dto.setAssignment(entity.getAssignment().getAssignment_id());
		dto.setCreated_by(entity.getCreated_by().getUser_id());
		return dto;
	}
	
}
