package com.corenuts.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="assignment")
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Assignment
{
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "assignment_id")
	    private Integer assignment_id;
	
	@Column(name="assignment_name")
	private String assignment_name;
	
	@Column(name="assignment_description")
	private String assignment_description;
	
	
	@ManyToOne
 	@JoinColumn(name="subject_id",referencedColumnName = "subject_id")
	private SubjectDetails subject_id;
	
	@ManyToOne
 	@JoinColumn(name="created_by",referencedColumnName = "user_id")
 	private UserDetails created_by;
	
	@ManyToOne
	@JoinColumn(name="topic_id",referencedColumnName = "task_id")
	private Topic topic_id;
	
 	
 	@Column(name="status")
 	private String status;
 	
 	@Column(name="created_on")
 	private Date created_on;
 	
 	
 	
 	



 	 
 

}
