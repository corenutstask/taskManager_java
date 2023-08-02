package com.corenuts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corenuts.dto.AssignmentDTO;
import com.corenuts.entity.Assignment;
import com.corenuts.entity.Batch;
import com.corenuts.repositories.AssignmentRepository;
import com.corenuts.repositories.BatchRepository;

@Service
public class AssignmentService {
	
	private final AssignmentRepository assignmentRepo;
	private final AssignmentMapper mapper;
	private final BatchRepository batchrepository; 
	
	@Autowired
	public AssignmentService(AssignmentRepository AssignmentRepo,AssignmentMapper mapper,BatchRepository batchrepository)
	{
		this.assignmentRepo= AssignmentRepo;
		this.mapper=mapper;
		this.batchrepository=batchrepository;
	}
	public Assignment save(Assignment assignment)
	{
		

		return assignmentRepo.save(assignment);
	}
	
	public AssignmentDTO save(AssignmentDTO assignmentDTO)
	{
	
	Assignment assignment=mapper.convertToEntity(assignmentDTO);
	
		assignmentRepo.save(assignment);
	return  mapper.convertToDTO(assignment);
	}
	
	public AssignmentDTO getby(int id) {
		
		return mapper.convertToDTO(assignmentRepo.findById(id).get());
	}

	public List< AssignmentDTO> getall() {
		List< AssignmentDTO>assignments=new ArrayList<>();
		System.out.println("getall");
		List<Assignment>assignmententity=assignmentRepo.findAll();
				assignments=assignmententity.stream().map((assignment)->{
			return mapper.convertToDTO(assignment) ;
		}).toList();
		System.out.println(assignments);
		return assignments;
	}

	public AssignmentDTO update(AssignmentDTO sub) {
		
		Assignment assignmentent=mapper.convertToEntity(sub);
		assignmentRepo.save(assignmentent);
		return mapper.convertToDTO(assignmentent);
	}
	public void delete(int id)
	{
		assignmentRepo.deleteById(id);
	}
}
