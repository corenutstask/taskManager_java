package com.corenuts.dto;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

//@Service
public class SubjectDTO {

	private int subject_id;

	private String subject_name;

	private int created_by;

	private String status;

	private Date created_on;

	private int modified_by;

	private Date modified_on;
	
	private List<Integer> batches;
}
