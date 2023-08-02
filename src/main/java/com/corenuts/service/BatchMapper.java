package com.corenuts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corenuts.dto.BatchDTO;
import com.corenuts.entity.Batch;
import com.corenuts.entity.SubjectDetails;
import com.corenuts.repositories.BatchRepository;
import com.corenuts.repositories.BranchRepository;
import com.corenuts.repositories.SubjectRepository;
import com.corenuts.repositories.UserDetailRepository;

@Component
public class BatchMapper {
	
	private final UserDetailRepository detailRepository ;
	private final BranchRepository branchRepository;
	private final SubjectRepository subjectRepository;
	
	
	@Autowired
	public BatchMapper(SubjectRepository subjectRepository,UserDetailRepository detailRepository,BranchRepository branchRepository)
	{
		
		this.detailRepository=detailRepository;
		this.branchRepository=branchRepository;
		this.subjectRepository=subjectRepository;
	}
	

    public Batch convertToEntity(BatchDTO batchDTO) {
    	 
         List<Integer>subjectIds=batchDTO.getSubjects();
         List<SubjectDetails>subjects=subjectIds.stream().map((subject)->
         {
        	 return subjectRepository.findById(subject).get();
         }).toList();
        Batch batch = new Batch();
        batch.setBatch_id(batchDTO.getBatch_id());
        batch.setBatch_name(batchDTO.getBatch_name());
        batch.setStatus(batchDTO.getStatus());
        batch.setModified_on(batchDTO.getModified_on());
        batch.setSubjects(subjects);
        batch.setBranch_id(branchRepository.findById(batchDTO.getBranch_id()).get());
        if (batchDTO.getModified_by() != 0) {
            batch.setModified_by(detailRepository.findById(batchDTO.getModified_by()).orElse(null));
        }

        batch.setCreated_by(detailRepository.findById(batchDTO.getCreated_by()).orElse(null));

        return batch;
    }

    public BatchDTO convertToDTO(Batch batch) {
        BatchDTO batchDTO = new BatchDTO();
        batchDTO.setBatch_id(batch.getBatch_id());
        batchDTO.setBatch_name(batch.getBatch_name());
        batchDTO.setStatus(batch.getStatus());
        batchDTO.setCreated_on(batch.getCreated_on());
        batchDTO.setModified_on(batch.getModified_on());
        batchDTO.setBranch_id(batch.getBranch_id().getBranch_id());
//        List<Integer>subIds= subjectRepository.SubByBatch(batch.getBatch_id());
//        batchDTO.setSubjects(subIds);
        batchDTO.setSubjects(batch.getSubjects().stream().map(sub->sub.getSubject_id()).toList());
        if (batch.getCreated_by() != null) {
            batchDTO.setCreated_by(batch.getCreated_by().getUser_id());
        }
        if (batch.getModified_by() != null) {
            batchDTO.setModified_by(batch.getModified_by().getUser_id());
        }

        return batchDTO;
    }
	
	

}
