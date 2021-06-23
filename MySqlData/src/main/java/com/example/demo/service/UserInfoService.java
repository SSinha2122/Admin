package com.example.demo.service;

import com.example.demo.model.UserInfo;
import com.example.demo.vo.UserInfoVO;
import com.example.demo.vo.UserInfoVO1;

public interface UserInfoService {

	public UserInfoVO getUserByEmailId(String emailId);

	public UserInfo addUserInfo(UserInfoVO userInfoVO);

	public void deleteUser(String emailId); 

	public UserInfoVO getUserByUserName(String userName);

	void deleteUserByUserName(String userName);

	public String deleteAll();

	public UserInfoVO1 findUserByUserName(String userName);

	
	
	

}
