package com.corenuts.dto;

import java.sql.Date;
import java.util.List;



import lombok.Data;

@Data

public class BatchAssignmentDTO {

	
	
    private int batch_assignment_id; 	
 	
    private int created_by;
 	
 	private String status;
 	
 	private Date start_date;

 	private int batch;
 	
 	private int assignment;
 
 	private Date expiration_date;
 	
    private List<Integer> completedAssignments;
 	


}
