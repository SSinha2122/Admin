package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.RoleInfoVO;
import com.example.demo.vo.RoleInfoVO1;

public interface RoleInfoService {

	public List<RoleInfoVO> findAll();

	public List<RoleInfoVO> getbyApplicationId(Integer appId);

	List<RoleInfoVO1> getAllRoleInfo();

	List<RoleInfoVO> getByApplicationKey(String applicationKey);

	
	
	
}
