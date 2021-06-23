package com.example.demo.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRoleVO {

	Integer applicationId;

	String userName;

	Integer roleCode;

	Character isActive;

	String createdBy;

	Date createdOn;

	String updatedBy;

	Date updatedOn;

}
