package com.corenuts.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corenuts.dto.SubjectDTO;
import com.corenuts.entity.Batch;
import com.corenuts.entity.SubjectDetails;
import com.corenuts.repositories.BatchRepository;
import com.corenuts.repositories.UserDetailRepository;

@Component
public class SubjectMapper {

    private final UserDetailRepository detailRepository;
    private final BatchRepository batchRepository;

    @Autowired
    public SubjectMapper(UserDetailRepository detailRepository,BatchRepository batchRepository) {
    	this.batchRepository=batchRepository;
        this.detailRepository = detailRepository;
    }

    public SubjectDetails convertToEntity(SubjectDTO subjectDetailsDTO) {
        SubjectDetails subjectDetails = new SubjectDetails();
        subjectDetails.setSubject_id(subjectDetailsDTO.getSubject_id());
        subjectDetails.setSubject_name(subjectDetailsDTO.getSubject_name());
        subjectDetails.setStatus(subjectDetailsDTO.getStatus());
//        subjectDetails.setCreated_on(subjectDetailsDTO.getCreated_on());
        subjectDetails.setModified_on(subjectDetailsDTO.getModified_on());
//        List<Batch>batches=subjectDetailsDTO.getBatches().stream().map(batch->batchRepository.findById(batch).get()).toList();
//        subjectDetails.setBatches(batches);

        if (subjectDetailsDTO.getModified_by() != 0) {
            subjectDetails.setModified_by(detailRepository.findById(subjectDetailsDTO.getModified_by()).orElse(null));
        }

        subjectDetails.setCreated_by(detailRepository.findById(subjectDetailsDTO.getCreated_by()).orElse(null));

        return subjectDetails;
    }

    public SubjectDTO convertToDTO(SubjectDetails subjectDetails) {
        SubjectDTO subjectDetailsDTO = new SubjectDTO();
        subjectDetailsDTO.setSubject_id(subjectDetails.getSubject_id());
        subjectDetailsDTO.setSubject_name(subjectDetails.getSubject_name());
        subjectDetailsDTO.setStatus(subjectDetails.getStatus());
        subjectDetailsDTO.setCreated_on(subjectDetails.getCreated_on());
        subjectDetailsDTO.setModified_on(subjectDetails.getModified_on());
//        subjectDetailsDTO.setBatches(subjectDetails.getBatches().stream().map(batch->batch.getBatch_id()).toList());
        if (subjectDetails.getCreated_by() != null) {
            subjectDetailsDTO.setCreated_by(subjectDetails.getCreated_by().getUser_id());
        }

        if (subjectDetails.getModified_by() != null) {
            subjectDetailsDTO.setModified_by(subjectDetails.getModified_by().getUser_id());
        }

        return subjectDetailsDTO;
    }
}
