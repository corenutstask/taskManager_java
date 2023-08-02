package com.corenuts.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="batch")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Batch {
	
	@Id
    @Column(name="batch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int batch_id;
	
	@Column(name="batch_name")
 	private String batch_name;
 	
 	@ManyToOne
 	@JoinColumn(name="created_by",referencedColumnName = "user_id")
 	private UserDetails created_by;
 	
 	@Column(name="status")
 	private String status;
 	
 	@Column(name="created_on")
 	private Date created_on;
 	
 	@ManyToOne
 	@JoinColumn(name="modified_by",referencedColumnName = "user_id")
 	private UserDetails  modified_by;
 	
	@Column(name="modified_on")
 	private Date modified_on;
	
	
	
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "batch_subject", joinColumns = { @JoinColumn(name = "batch_id") }, inverseJoinColumns = { @JoinColumn(name = "subject_id") })
	private List<SubjectDetails> subjects;


	
	@OneToMany(mappedBy = "batch_id")
	private List<StudentDetails>students;
	
	@ManyToOne
 	@JoinColumn(name="branch_id",referencedColumnName = "branch_id")
	private Branch branch_id;
	
	{
		
		this.created_on=new Date(System.currentTimeMillis());
	}


}
