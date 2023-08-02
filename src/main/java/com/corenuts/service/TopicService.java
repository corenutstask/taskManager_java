package com.corenuts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corenuts.dto.TopicDTO;
import com.corenuts.entity.Topic;
import com.corenuts.repositories.TopicRepository;

@Service
public class TopicService {
	
	private final TopicRepository topicRepo;
	private final TopicMapper mapper;
	
	@Autowired
	public TopicService(TopicRepository TopicRepo,TopicMapper mapper)
	{
		this.topicRepo= TopicRepo;
		this.mapper=mapper;
	}
	public Topic save(Topic topic)
	{
		
		return topicRepo.save(topic);
	}
	
	public TopicDTO save(TopicDTO topicDTO)
	{
	
	Topic topic=mapper.convertToEntity(topicDTO);
	
	topicRepo.save(topic);
	return  mapper.convertToDTO(topic);
	}
	
	public TopicDTO getby(int id) {
		
		return mapper.convertToDTO(topicRepo.findById(id).get());
	}

	public List< TopicDTO> getall() {
		List< TopicDTO>topics=new ArrayList<>();
		System.out.println("getall");
		List<Topic>topicentity=topicRepo.findAll();
				topics=topicentity.stream().map((topic)->{
			return mapper.convertToDTO(topic) ;
		}).toList();
		System.out.println(topics);
		return topics;
	}

	public TopicDTO update(TopicDTO sub) {
		Topic topicent=mapper.convertToEntity(sub);
		topicRepo.save(topicent);
		return mapper.convertToDTO(topicent);
	}
	public void delete(int id)
	{
		topicRepo.deleteById(id);
	}
}
