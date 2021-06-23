package com.example.demo.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveRoleUserVO1 {
	
	String action;
	Integer roleCode;
	String applicationKey;
	List<SaveRoleUserVO2> roleUser;

}
