package com.corenuts.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corenuts.entity.Batch;
@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {

	
	
}
