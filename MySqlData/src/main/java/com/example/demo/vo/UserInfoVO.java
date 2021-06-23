package com.example.demo.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoVO {
    String externalUserId;

	String userName;

	String firstName;

	String middleName;

	String lastName;

	String department;

	String domicileCountryCode;

	Integer businessUnitId;

	String regionCode;

	String designation;

	String currentTimeZone;

	String reportingManager;
	
	String emailId;

	String contactNumber;

	String isActive;

	String createdBy;

	Date createdOn;

	String updatedBy;

	Date updatedOn;

	}
