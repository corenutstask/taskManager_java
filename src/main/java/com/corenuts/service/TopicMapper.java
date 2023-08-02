package com.corenuts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corenuts.dto.TopicDTO;
import com.corenuts.entity.Assignment;
import com.corenuts.entity.Topic;
import com.corenuts.repositories.AssignmentRepository;

@Component
public class TopicMapper {
	@Autowired
	private AssignmentRepository assignmentRepository;

	public TopicDTO convertToDTO(Topic topic)
	{
		TopicDTO dto=new TopicDTO();
		dto.setSub_topic_name(topic.getTopic_name());
		dto.setSub_topic_name(topic.getSub_topic_name());
		dto.setTask_id(topic.getTask_id());
		List<Integer> topics=topic.getAssingment_id().stream().map(e->e.getAssignment_id()).toList();
		dto.setAssingment_id(topics);
		return dto;
	}
	
	public Topic convertToEntity(TopicDTO dto)
	{
		Topic entity=new Topic();
		entity.setTask_id(dto.getTask_id());
		entity.setTopic_name(dto.getTopic_name());
		entity.setSub_topic_name(dto.getSub_topic_name());
		List<Assignment>assignments=dto.getAssingment_id().stream().map(id->assignmentRepository.findById(id).get()).toList();
		
		entity.setAssingment_id(assignments);
		return entity;
		
	}
}
