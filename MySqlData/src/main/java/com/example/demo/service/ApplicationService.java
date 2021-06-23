package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Application;
import com.example.demo.vo.RoleInfoVO;
import com.example.demo.vo.UserInfoVO;

public interface ApplicationService {

	List<RoleInfoVO> getByApplicationKey(String applicationKey);

	List<UserInfoVO> getUserByApplicationKey(String applicationKey);

	Application findByApplicationName(String applicationname);

}
