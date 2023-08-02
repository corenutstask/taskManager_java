	package com.corenuts.entity;
	
	import java.sql.Date;
	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	
	import lombok.AllArgsConstructor;
	import lombok.Builder;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;
	
	@Entity
	@Table(name="user_details")
	@Getter
	@Setter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public class UserDetails {
		
		 	@Id
		    @Column(name="user_id")
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private int user_id;
		 
		 	@Column(name="user_name")
		 	private String user_name;
		 	
		 	@Column(name="email_id",unique = true)
		 	private String email;
		 	
		 	@Column(name="password")
		 	private String password;
		 	
		 	@Column(name="role")
		 	private String role;
		 	
		 	@Column(name="status")
		 	private String status;
		 	
		 	@Column(name="created_on")
		 	private Date created_on;
	
		 	{
				
				this.created_on=new Date(System.currentTimeMillis());
			}
	}
