package com.example.demo.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAppAccessVO2 {

	String applicationName;
	List<GetAppAccessVO3> ListOfRoles; 
	
}
