package com.corenuts.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
//@Service
public class OrganizationDTO {

	private int organization_id;

	private String organization_name;

	private int created_by;

	private String status;

	private Date created_on;

	private int modified_by;

	private Date modified_on;

	

	
}
