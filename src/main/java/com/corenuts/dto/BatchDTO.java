package com.corenuts.dto;

import java.sql.Date;
import java.util.List;


import lombok.Data;

@Data
//@Builder
//@Service
public class BatchDTO {
	private int batch_id;

	private String batch_name;
	
	private int branch_id;

	private int created_by;

	private String status;

	private Date created_on;

	private int modified_by;

	private Date modified_on;

	private List<Integer> subjects;

//	private List<StudentDetails> students;

	
}
