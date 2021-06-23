package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "applicationuser")
public class ApplicationUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPLICATIONUSERID")
	Integer applicationUserId;
	
	@Column(name = "ISACTIVE")
	Character isActive;
	
	@Column(name = "CREATED_BY")
	String createdBy;
	
	@Column(name="CREATED_ON")
	Date createdOn;
	
	@Column(name = "UPDATED_BY")
	String updatedBy;
	
	@Column(name="UPDATED_ON")
    Date updatedOn;
	
	@Column(name = "USERNAME")
	String userName;
	
	@Column(name="APPLICATIONID")
	Integer applicationId;
	
	
	

	
	
}