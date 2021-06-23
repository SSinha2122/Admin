package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApplicationUser;
import com.example.demo.service.ApplicationUserService;
import com.example.demo.vo.ApplicationUserVO;
import com.example.demo.vo.ApplicationUserVO1;

@RestController
@RequestMapping("/applicationuser")
public class ApplicationUserController {

	@Autowired
	ApplicationUserService applicationUserService;
	
	@GetMapping(path = "/getapplication/{userName}")
	public List<ApplicationUserVO> getByUserName(@PathVariable String userName) {
		return applicationUserService.getByUserName(userName);
	}
	
	@GetMapping(path = "/getApp/{applicationId}")
	public List<ApplicationUserVO> getByApplicationId(@PathVariable Integer applicationId){
		return applicationUserService.getByApplicationId(applicationId);
	}
	@PostMapping(path="/addData")
	public ApplicationUser addApplicationUser(@RequestBody ApplicationUserVO applicationUserVO) {
		return applicationUserService.addApplicationUser(applicationUserVO);
	}
	@PostMapping(path = "/addMultipleData")
	public ApplicationUser addApplication(@RequestBody ApplicationUserVO1 applicationUserVO1) throws Exception {
	         return  applicationUserService.addApplication(applicationUserVO1);
	}
}
