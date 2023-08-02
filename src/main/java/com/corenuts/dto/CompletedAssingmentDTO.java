package com.corenuts.dto;



import java.sql.Date;


import lombok.Data;


@Data

public class CompletedAssingmentDTO {
	
	    private int assingement_completed_id;

	    private int assignment_id;

	    private int student_id;

	    private String status;

	    private Date submission_date;

}
