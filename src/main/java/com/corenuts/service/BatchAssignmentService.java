package com.corenuts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corenuts.dto.AssignmentDTO;
import com.corenuts.dto.BatchAssignmentDTO;
import com.corenuts.entity.Assignment;
import com.corenuts.entity.Batch;
import com.corenuts.entity.BatchAssignment;
import com.corenuts.repositories.AssignmentRepository;
import com.corenuts.repositories.BatchAssignmentRepository;
import com.corenuts.repositories.BatchRepository;

@Service
public class BatchAssignmentService {
	
	private final BatchAssignmentRepository assignmentRepo;
	private final  BatchAssignmentMapper mapper;
	private final BatchRepository batchrepository; 
	
	@Autowired
	public BatchAssignmentService(BatchAssignmentRepository assignmentRepo,BatchAssignmentMapper mapper,BatchRepository batchrepository)
	{
		this.assignmentRepo=assignmentRepo;
		this.mapper=mapper;
		this.batchrepository=batchrepository;
	}
	
	
	public BatchAssignmentDTO save(BatchAssignmentDTO assignmentDTO)
	{
	
		BatchAssignment assignment=mapper.convertToEntity(assignmentDTO);
	
		assignmentRepo.save(assignment);
	return  mapper.convertToDTO(assignment);
	}
	
	public BatchAssignmentDTO getby(int id) {
		
		return mapper.convertToDTO(assignmentRepo.findById(id).get());
	}

	public List<BatchAssignmentDTO> getall() {
		List<BatchAssignmentDTO>assignments=new ArrayList<>();
		System.out.println("getall");
		List<BatchAssignment>assignmententity =assignmentRepo.findAll();
				assignments=assignmententity.stream().map((assignment)->{
			return mapper.convertToDTO(assignment) ;
		}).toList();
		System.out.println(assignments);
		return assignments;
	}

	public BatchAssignmentDTO update(BatchAssignmentDTO sub) {
		
		BatchAssignment assignmentent=mapper.convertToEntity(sub);
		assignmentRepo.save(assignmentent);
		return mapper.convertToDTO(assignmentent);
	}
	public void delete(int id)
	{
		assignmentRepo.deleteById(id);
	}
}
