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
@Table(name="organization")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
	
	@Id
    @Column(name="organization_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organization_id;
	
	@Column(name="organization_name")
 	private String organization_name;
 	
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
	
	@OneToMany(mappedBy = "organization_id")
	private List<Branch> branch;
	
	{
		
		this.created_on=new Date(System.currentTimeMillis());
	}


}
