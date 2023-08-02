package com.corenuts.entity;


import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Branch")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Branch {
	
	@Id
    @Column(name="branch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branch_id;
	
	@Column(name="branch_name")
 	private String branch_name;
 	
 	@ManyToOne
 	@JoinColumn(name="created_admin",referencedColumnName = "user_id")
 	private UserDetails created_admin;
 	
 	@Column(name="status")
 	private String status;
 	
 	@Column(name="created_on")
 	private Date created_on;
 	
 	@ManyToOne
 	@JoinColumn(name="modified_admin",referencedColumnName = "user_id")
 	private UserDetails  modified_admin;
 	
	@Column(name="modified_on")
 	private Date modified_on;
	
	@Column(name="branch_location")
	private String branch_location;
	
	@OneToMany(mappedBy="branch_id")
	private List<Batch> batch;
	
	
	@ManyToOne
 	@JoinColumn(name="organization_id",referencedColumnName = "organization_id")
	private Organization organization_id;
	
	{
		
		this.created_on=new Date(System.currentTimeMillis());
	}


}

