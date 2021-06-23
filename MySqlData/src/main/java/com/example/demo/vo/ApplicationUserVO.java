package com.example.demo.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationUserVO {
	
	
	String userName;
	Integer applicationId;
	Character isActive;
	Date createdOn;
	Date updatedOn;
	String createdBy;
	String updatedBy;
	
	
}
