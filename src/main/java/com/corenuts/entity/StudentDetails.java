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

@Entity
@Table(name="student_details")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetails {
	
	 	@Id
	    @Column(name="student_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int student_id;
	 
	 	@Column(name="student_name")
	 	private String student_name;
	 	
	 	@Column(name="email")
	 	private String email;
	 	
	 	@Column(name="password")
	 	private String password;
	 
	 	@Column(name="status")
	 	private String status;
	 	
	 	@ManyToOne
	 	@JoinColumn(name="batch_id",referencedColumnName = "batch_id")
	 	private Batch batch_id;
	 	
	 	@Column(name="created_on")
	 	private Date created_on;
	 	
	 	{
			
			this.created_on=new Date(System.currentTimeMillis());
		}

}
