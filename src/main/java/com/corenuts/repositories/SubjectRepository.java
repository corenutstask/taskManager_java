package com.corenuts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.corenuts.entity.SubjectDetails;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectDetails, Integer> {

	@Query(value="select subject_id from  corenuts_taskmanager.batch_subject where batch_id=:batchId",nativeQuery = true)
	public List<Integer> SubByBatch(int batchId); 
}
