package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRole;
import com.example.demo.service.UserRoleService;
import com.example.demo.vo.GetAppAccessVO1;
import com.example.demo.vo.SaveRoleUserVO1;
import com.example.demo.vo.UserInfoVO1;
import com.example.demo.vo.UserRoleVO;
import com.example.demo.vo.UserRoleVO1;
import com.example.demo.vo.UserRoleVO2;
import com.example.exception.RoleNotFoundException;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {

	@Autowired
	UserRoleService userRoleService;

	@PostMapping(path = "/addUserRole")
	public UserRole addUserRole(@RequestBody UserRoleVO userRoleVO) {
		return userRoleService.addUserRole(userRoleVO);
	}

	@GetMapping(path = "/findByAppId/{applicationId}")
	public List<UserRole> findUserRole(@PathVariable Integer applicationId) {
		return userRoleService.findUserRole(applicationId);
	}

	@DeleteMapping(path = "/deleteUserRole")
	public void deleteUserRole(@RequestBody UserRoleVO1 userRoleVO1) {
		userRoleService.deleteUserRole(userRoleVO1);
	}

	@GetMapping(path = "/getUserRoles")
	public List<UserInfoVO1> getUserRoles(@RequestBody UserRoleVO2 userRoleVO2) throws RoleNotFoundException {
    return userRoleService.getUserRoles(userRoleVO2);
    }

	@GetMapping(path = "/findByRoleCode/{roleCode}")
	public List<UserRole> findByRoleCode(@PathVariable Integer roleCode) {
		return userRoleService.findByRoleCode(roleCode);
	}

	@PostMapping(path = "/addMultipleUserRole")
	public UserRole addMultipleUserRole(@RequestBody SaveRoleUserVO1 saveRoleUserVO1,@RequestHeader(value = "createdBy")String createdBy,@RequestHeader(value = "updatedBy")String updatedBy) throws Exception {
		return userRoleService.addMultipleUserRole(saveRoleUserVO1,createdBy,updatedBy);
	}
	
	@GetMapping(path = "/getAppAccess")
	public GetAppAccessVO1 getAppAccess(@RequestHeader(value = "userName")String userName) {
		return userRoleService.getAppAccess(userName);
	}
	
	@GetMapping(path = "/getUserRolesByUserNames/{userName}/{applicationId}")
	public List<UserRole> getUserRoleByUserName(@PathVariable String userName,@PathVariable Integer applicationId){
		return userRoleService.getUserRoleByUserName(userName,applicationId);
	}
	
	
	
	
	
}
