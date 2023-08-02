package com.corenuts.dto;

import java.sql.Date;




import lombok.Data;

//@Service
@Data
//@Builder

public class BranchDTO {

    private int branch_id;
	
 	private String branch_name;
 	
 	private int created_admin;
 	
 	private String status;
 	
 	private Date created_on;
 	
 	private int  modified_admin;
 	
 	private Date modified_on;
	
	private String branch_location;

	private int organization_id;
	
}
