package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserRole;
import com.example.demo.vo.GetAppAccessVO1;
import com.example.demo.vo.SaveRoleUserVO1;
import com.example.demo.vo.UserInfoVO1;
import com.example.demo.vo.UserRoleVO;
import com.example.demo.vo.UserRoleVO1;
import com.example.demo.vo.UserRoleVO2;
import com.example.exception.RoleNotFoundException;

public interface UserRoleService {

	UserRole addUserRole(UserRoleVO userRoleVO);

	void deleteUserRole(UserRoleVO1 userRoleVO1);

	List<UserRole> findUserRole(Integer applicationId);

	List<UserInfoVO1> getUserRoles(UserRoleVO2 userRoleVO2) throws RoleNotFoundException ;

	List<UserRole> findByRoleCode(Integer roleCode) ;

	UserRole addMultipleUserRole(SaveRoleUserVO1 saveRoleUserVO1, String createdBy, String updatedBy) throws Exception;

	GetAppAccessVO1 getAppAccess(String userName);
	
	List<UserRole> getUserRoleByUserName(String userName, Integer applicationId);


}
