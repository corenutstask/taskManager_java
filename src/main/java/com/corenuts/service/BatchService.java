package com.corenuts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corenuts.dto.BatchDTO;
import com.corenuts.entity.Batch;
import com.corenuts.entity.SubjectDetails;
import com.corenuts.repositories.BatchRepository;
import com.corenuts.repositories.SubjectRepository;

@Service
public class BatchService {
	
	private final BatchRepository batchRepo;
	private final BatchMapper mapper;
	private final SubjectRepository subrepository; 
	
	@Autowired
	public BatchService(BatchRepository BatchRepo,BatchMapper mapper,SubjectRepository subrepository)
	{
		this.batchRepo= BatchRepo;
		this.mapper=mapper;
		this.subrepository=subrepository;
	}
	public Batch save(Batch batch)
	{
		

		return batchRepo.save(batch);
	}
	
	public BatchDTO save(BatchDTO batchDTO)
	{
	
	Batch batch=mapper.convertToEntity(batchDTO);
//	List<SubjectDetails>subjects=batchDTO.getSubjects().stream().map((subid)->
//			{
//				return subrepository.findById(subid).get();
//			}
//			).toList();
//	batch.setSubjects(subjects);
//	System.out.println(batch.getSubjects());
	batchRepo.save(batch);
	return  mapper.convertToDTO(batch);
	}
	
	public BatchDTO getby(int id) {
		
		return mapper.convertToDTO(batchRepo.findById(id).get());
	}

	public List< BatchDTO> getall() {
		List< BatchDTO>batchs=new ArrayList<>();
		System.out.println("getall");
		List<Batch>batchentity=batchRepo.findAll();
				batchs=batchentity.stream().map((batch)->{
			return mapper.convertToDTO(batch) ;
		}).toList();
		System.out.println(batchs);
		return batchs;
	}

	public BatchDTO update(BatchDTO sub) {
		
		Batch batchent=mapper.convertToEntity(sub);
		batchRepo.save(batchent);
		return mapper.convertToDTO(batchent);
	}
	public void delete(int id)
	{
		batchRepo.deleteById(id);
	}
}
