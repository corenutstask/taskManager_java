package com.corenuts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corenuts.dto.StudentDTO;
import com.corenuts.entity.Batch;
import com.corenuts.entity.StudentDetails;
import com.corenuts.repositories.BatchRepository;

import lombok.Data;
@Data
@Component
public class StudentMapper {
	
	@Autowired
	private BatchRepository batchrepo;

   public StudentDTO convertToDTO(StudentDetails entity)
   {
	   StudentDTO dto=new StudentDTO();
	   dto.setBatch_id(entity.getBatch_id().getBatch_id());
	   dto.setStudent_id(entity.getStudent_id());
	   dto.setCreated_on(entity.getCreated_on());
	   dto.setEmail(entity.getEmail());
	   dto.setPassword(entity.getPassword());
	   dto.setStatus(entity.getStatus());
	   dto.setStudent_name(entity.getStudent_name());
	   return dto;
   }
   
   public StudentDetails convertToEntity(StudentDTO dto)
   {
	   StudentDetails entity=new StudentDetails();
	   Batch batch=new Batch();
	   if(dto.getBatch_id()!=0)
	   {
		   batch=batchrepo.findById(dto.getBatch_id()).get();
		   entity.setBatch_id(batch);
	   }
	   entity.setStudent_id(dto.getStudent_id());
	   entity.setCreated_on(dto.getCreated_on());
	   entity.setEmail(dto.getEmail());
	   entity.setPassword(dto.getPassword());
	   entity.setStatus(dto.getStatus());
	   entity.setStudent_name(dto.getStudent_name());
	   return entity;
   }
   
   
}
