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
@Table(name = "user_info")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USERID")
	Integer userid;
	@Column(name = "EXTERNALUSERID")
	String externalUserId;
	@Column(name = "USERNAME")
	String userName;
	@Column(name = "FIRSTNAME")
	String firstName;
	@Column(name = "MIDDLENAME")
	String middleName;
	@Column(name = "LASTNAME")
	String lastName;
	@Column(name = "DEPARTMENT")
	String department;
	@Column(name = "DOMICILE_COUNTRY_CODE")
	String domicileCountryCode;
	@Column(name = "BUSINESSUNIT_ID")
	Integer businessUnitId;
	@Column(name = "REGION_CODE")
	String regionCode;
	@Column(name = "DESIGNATION")
	String designation;
	@Column(name = "CURRENTTIMEZONE")
	String currentTimeZone;
	@Column(name = "REPORTINGMANAGER")
	String reportingManager;
	@Column(name = "EMAILID")
	String emailId;
	@Column(name = "CONTACTNUMBER")
	String contactNumber;
	@Column(name = "ISACTIVE")
	String isActive;
	@Column(name = "CREATED_BY")
	String createdBy;
	@Column(name = "CREATED_ON")
	Date createdOn;
	@Column(name = "UPDATED_BY")
	String updatedBy;
	@Column(name = "UPDATED_ON")
	Date updatedOn;
	
		
}
