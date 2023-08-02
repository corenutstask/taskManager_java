package com.corenuts.dto;

import java.sql.Date;
import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssignmentDTO {
	
	private int assignment_id;

	private String assignment_name;

	private String assignment_description;

	private int subject_id;

	private int created_by;

	private String status;

	private Date created_on;
	
	private int topic_id;
	
	
	


}
