package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="userrole")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USERROLEID")
	Integer userroleid;
	
	@Column(name = "APPLICATIONID")
	Integer applicationId;
	
	@Column(name = "USERNAME")
	String userName;
	
	@Column(name = "ROLECODE")
	Integer roleCode;
	
	@Column(name = "ISACTIVE")
	Character isActive;
	
	@Column(name = "CREATED_BY")
	String createdBy;
	
	@Column(name = "CREATED_ON")
	Date createdOn;
	
	@Column(name = "UPDATED_BY")
	String updatedBy;
	
	@Column(name = "UPDATED_ON")
	Date updatedOn;

}
