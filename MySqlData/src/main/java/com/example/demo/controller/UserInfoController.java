package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.vo.UserInfoVO;
import com.example.demo.vo.UserInfoVO1;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;

	@GetMapping(path = "getUserByEmailId/{emailId}")
	public UserInfoVO getUserByEmailId(@PathVariable String emailId) {
		return userInfoService.getUserByEmailId(emailId);
	}

	@PostMapping(path = "/addUsers")
	public UserInfo addUserInfo(@RequestBody UserInfoVO userInfoVO) {
		return userInfoService.addUserInfo(userInfoVO);
	}
	
	@DeleteMapping(value = "/deleteUser/{emailId}")
	public void deleteUserInfo(@PathVariable("emailId") String emailId) {
		userInfoService.deleteUser(emailId);
	}
	@GetMapping(path = "/{userName}")
	public UserInfoVO getUserByUserName(@PathVariable String userName) {
		return userInfoService.getUserByUserName(userName);
	}
	@GetMapping(path = "/getUser/{userName}")
	public UserInfoVO1 findUserByUserName(@PathVariable String userName) {
		return userInfoService.findUserByUserName(userName);
	}
	
	@DeleteMapping(value = "/deleteUserByUserName/{userName}")
	public void deleteUserByUserName(@PathVariable("userName") String userName) {
       userInfoService.deleteUserByUserName(userName);
    }
	
	@DeleteMapping(path = "/deleteAll")
	public String deleteAll() {
		return userInfoService.deleteAll();
	}
	
}
