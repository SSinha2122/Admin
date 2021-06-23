package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Application;
import com.example.demo.service.ApplicationService;
import com.example.demo.vo.RoleInfoVO;
import com.example.demo.vo.UserInfoVO;

@RestController
@RequestMapping("/application")
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;
	
	@GetMapping(path = "/getRoles/{applicationKey}")
	public List<RoleInfoVO> findByApplicationKey(@PathVariable String applicationKey){
		return applicationService.getByApplicationKey(applicationKey);
	}
	
	@GetMapping(path = "/getUserRole/{applicationKey}")
	public List<UserInfoVO> findUserByApplicationKey(@PathVariable String applicationKey){
		return applicationService.getUserByApplicationKey(applicationKey);
	}
	
   	@GetMapping(path = "/getByApplicationName/{applicationname}")
   	public Application findByApplicationName(@PathVariable String applicationname){
   		
   		return applicationService.findByApplicationName(applicationname);
   		
   	}
}
