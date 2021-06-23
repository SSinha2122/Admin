package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RoleInfoService;
import com.example.demo.vo.RoleInfoVO;
import com.example.demo.vo.RoleInfoVO1;



@RestController
@RequestMapping("/roleinfo")
public class RoleInfoController {
	
	@Autowired
	RoleInfoService roleInfoService;
	
	
	@GetMapping(path="/getAllRole")
	public List<RoleInfoVO> findAll(){
		return roleInfoService.findAll();
	}
	
	@GetMapping(path="/roleId/{appId}")
	public List<RoleInfoVO> getbyId(@PathVariable int appId){
		return roleInfoService.getbyApplicationId(appId);
	}
	
	@GetMapping(path="/roleinfogetall")
	public List<RoleInfoVO1> getAllRoleInfo(){
		return roleInfoService.getAllRoleInfo();
	}
	@GetMapping(path = "/getAllRoleByApplicationKey/{applicationKey}")
	public List<RoleInfoVO> getByApplicationKey(@PathVariable String applicationKey){
		return roleInfoService.getByApplicationKey(applicationKey);
	}
	
}
