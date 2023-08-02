package com.corenuts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corenuts.dto.CompletedAssingmentDTO;
import com.corenuts.entity.CompletedAssignment;
import com.corenuts.repositories.BatchRepository;
import com.corenuts.repositories.CompletedAssignmentRepository;

@Service
public class CompletedAssignmentService {
	
	private final CompletedAssignmentRepository assignmentRepo;
	private final  CompletedAssignmentMapper mapper;
	private final BatchRepository batchrepository; 
	
	@Autowired
	public CompletedAssignmentService(CompletedAssignmentRepository assignmentRepo,CompletedAssignmentMapper mapper,BatchRepository batchrepository)
	{
		this.assignmentRepo=assignmentRepo;
		this.mapper=mapper;
		this.batchrepository=batchrepository;
	}
	
	
	public CompletedAssingmentDTO save(CompletedAssingmentDTO assignmentDTO)
	{
	
		CompletedAssignment assignment=mapper.convertToEntity(assignmentDTO);
	
		assignmentRepo.save(assignment);
	return  mapper.convertToDTO(assignment);
	}
	
	public CompletedAssingmentDTO getby(int id) {
		
		return mapper.convertToDTO(assignmentRepo.findById(id).get());
	}

	public List<CompletedAssingmentDTO> getall() {
		List<CompletedAssingmentDTO>assignments=new ArrayList<>();
		System.out.println("getall");
		List<CompletedAssignment>assignmententity =assignmentRepo.findAll();
				assignments=assignmententity.stream().map((assignment)->{
			return mapper.convertToDTO(assignment) ;
		}).toList();
		System.out.println(assignments);
		return assignments;
	}

	public CompletedAssingmentDTO update(CompletedAssingmentDTO sub) {
		
		CompletedAssignment assignmentent=mapper.convertToEntity(sub);
		assignmentRepo.save(assignmentent);
		return mapper.convertToDTO(assignmentent);
	}
	public void delete(int id)
	{
		assignmentRepo.deleteById(id);
	}
}
