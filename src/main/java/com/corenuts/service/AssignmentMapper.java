package com.corenuts.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corenuts.dto.AssignmentDTO;
import com.corenuts.entity.Assignment;
import com.corenuts.repositories.SubjectRepository;
import com.corenuts.repositories.TopicRepository;
import com.corenuts.repositories.UserDetailRepository;

@Component
public class AssignmentMapper {	
	private final UserDetailRepository detailRepository ;
	private final SubjectRepository subjectRepository;	
	private final TopicRepository topicRepository;
	@Autowired
	public AssignmentMapper(TopicRepository topicRepository,SubjectRepository subjectRepository,UserDetailRepository detailRepository)
	{
		
		this.detailRepository=detailRepository;
		this.subjectRepository=subjectRepository;
		this.topicRepository=topicRepository;
	}
    public Assignment convertToEntity(AssignmentDTO assingmentsDTO) {  
        Assignment assingments = new Assignment();
        assingments.setAssignment_name(assingmentsDTO.getAssignment_name());
        assingments.setAssignment_id(assingmentsDTO.getAssignment_id());
        assingments.setCreated_on(assingmentsDTO.getCreated_on());
        assingments.setAssignment_description(assingmentsDTO.getAssignment_description());
        assingments.setStatus(assingmentsDTO.getStatus());
        assingments.setAssignment_name(assingmentsDTO.getAssignment_name());
        assingments.setSubject_id(subjectRepository.findById(assingmentsDTO.getSubject_id()).get());
        assingments.setCreated_by(detailRepository.findById(assingmentsDTO.getCreated_by()).orElse(null));
        assingments.setTopic_id(topicRepository.findById(assingmentsDTO.getTopic_id()).get());
        return assingments;
    }
    public AssignmentDTO convertToDTO(Assignment assingment) {
        AssignmentDTO assingmentsDTO = new AssignmentDTO();
        assingmentsDTO.setAssignment_id(assingment.getAssignment_id());
        assingmentsDTO.setCreated_on(assingment.getCreated_on());
        assingmentsDTO.setAssignment_name(assingment.getAssignment_name());
        assingmentsDTO.setAssignment_id(assingment.getAssignment_id());
        assingmentsDTO.setAssignment_description(assingment.getAssignment_description());
        assingmentsDTO.setStatus(assingment.getStatus());
        assingmentsDTO.setAssignment_description(assingment.getAssignment_description());
        assingmentsDTO.setCreated_on(assingment.getCreated_on());
        assingmentsDTO.setSubject_id(assingment.getSubject_id().getSubject_id());
        assingmentsDTO.setTopic_id(assingment.getTopic_id().getTask_id());
        if (assingment.getCreated_by() != null) {
            assingmentsDTO.setCreated_by(assingment.getCreated_by().getUser_id());
        }
        
        return assingmentsDTO;
    }
	
	

}
