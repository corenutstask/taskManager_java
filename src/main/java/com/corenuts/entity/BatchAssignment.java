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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="batch_assignment")
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchAssignment
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_assignment_id")
    private Integer batch_assignment_id; 	

	@ManyToOne
 	@JoinColumn(name="created_by",referencedColumnName = "user_id")
 	private UserDetails created_by;
 	
 	@Column(name="status")
 	private String status;
 	
 	@Column(name="start_date")
 	private Date start_date;

 	@ManyToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name="batch_id",referencedColumnName = "batch_id")
 	private Batch batch;
 	
 	@ManyToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name="assignment_id",referencedColumnName = "assignment_id")
 	private Assignment assignment;
 
 	@Column(name="expiration_date")
 	private Date expiration_date;
 	
 	@OneToMany(mappedBy = "assignment_id")
    private List<CompletedAssignment> completedAssignments;
 	



 
 

}
