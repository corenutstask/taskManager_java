package com.corenuts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corenuts.dto.SubjectDTO;
import com.corenuts.entity.SubjectDetails;
import com.corenuts.repositories.SubjectRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubjectService {
	
	private final SubjectRepository subjectRepo;
	private final SubjectMapper mapper;
	
	@Autowired
	public SubjectService(SubjectRepository subjectRepo,SubjectMapper mapper)
	{
		this.subjectRepo= subjectRepo;
		this.mapper=mapper;
	}
	
	public SubjectDTO save(SubjectDTO subjectDTO)
	{
		
	SubjectDetails sub=mapper.convertToEntity(subjectDTO);
	
	subjectRepo.save(sub);
	return  mapper.convertToDTO(sub);
	
		
	}
	
	public SubjectDTO getby(int id) {
		
		return mapper.convertToDTO(subjectRepo.findById(id).get());
	}

	public List< SubjectDTO> getall() {
		List< SubjectDTO>subjects=new ArrayList<>();
		System.out.println("getall");
		List<SubjectDetails>subents=subjectRepo.findAll();
				subjects=subents.stream().map((subject)->{
			return mapper.convertToDTO(subject) ;
		}).toList();
		System.out.println(subjects);
		return subjects;
	}

	public SubjectDTO update(SubjectDTO sub) {
		
		SubjectDetails subent=mapper.convertToEntity(sub);
		log.info("updating batches through subject{}",subent.getBatches());
		subjectRepo.save(subent);
		return mapper.convertToDTO(subent);
	}
	public void delete(int id)
	{
		subjectRepo.deleteById(id);
	}
}
