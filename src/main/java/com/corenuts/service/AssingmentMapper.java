package com.corenuts.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corenuts.dto.AssignmentDTO;
import com.corenuts.entity.Assignment;
import com.corenuts.entity.Batch;
import com.corenuts.repositories.BatchRepository;
import com.corenuts.repositories.SubjectRepository;
import com.corenuts.repositories.TopicRepository;
import com.corenuts.repositories.UserDetailRepository;

@Component
public class AssingmentMapper {	
	private final UserDetailRepository detailRepository ;
	private final SubjectRepository subjectRepository;	
	private final TopicRepository topicRepository;
	@Autowired
	public AssingmentMapper(TopicRepository topicRepository,SubjectRepository subjectRepository,UserDetailRepository detailRepository)
	{
		
		this.detailRepository=detailRepository;
		this.subjectRepository=subjectRepository;
		this.topicRepository=topicRepository;
	}
    public Assignment convertToEntity(AssignmentDTO assingmentsDTO) {  
        Assignment assingments = new Assignment();
        assingments.setAssignment_id(assingmentsDTO.getAssignment_id());
        assingments.setAssignment_name(assingmentsDTO.getAssignment_name());
        assingments.setStatus(assingmentsDTO.getStatus());
        assingments.setAssignment_description(assingmentsDTO.getAssignment_description());
        assingments.setSubject_id(subjectRepository.findById(assingmentsDTO.getSubject_id()).get());
        assingments.setCreated_by(detailRepository.findById(assingmentsDTO.getCreated_by()).orElse(null));
        assingments.setTopic_id(topicRepository.findById(assingmentsDTO.getTopic_id()).get());;
        return assingments;
    }
    public AssignmentDTO convertToDTO(Assignment assingments) {
        AssignmentDTO assingmentsDTO = new AssignmentDTO();
        assingmentsDTO.setAssignment_id(assingments.getAssignment_id());
        assingmentsDTO.setAssignment_name(assingments.getAssignment_name());
        assingmentsDTO.setStatus(assingments.getStatus());
        assingmentsDTO.setAssignment_description(assingments.getAssignment_description());
        assingmentsDTO.setCreated_on(assingments.getCreated_on());
        assingmentsDTO.setSubject_id(assingments.getSubject_id().getSubject_id()); 
        assingmentsDTO.setTopic_id(assingments.getTopic_id().getTask_id());
        if (assingments.getCreated_by() != null) {
            assingmentsDTO.setCreated_by(assingments.getCreated_by().getUser_id());
        }
        
        return assingmentsDTO;
    }
	
	

}
