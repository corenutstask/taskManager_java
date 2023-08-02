package com.corenuts.entity;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

@Entity(name="topic")
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topic
{
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "task_id")
	    private Integer task_id;
	
	@Column(name="topic_name")
	private String topic_name;
	
	@Column(name="sub_topic_name")
	private String sub_topic_name;

	
	@ManyToOne
	@JoinColumn(name="subject",referencedColumnName = "subject_id")
	private SubjectDetails subject;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "topic_id")
	private List<Assignment> assingment_id;
	
	
 	
 	
 	
 	



 	 
 

}
