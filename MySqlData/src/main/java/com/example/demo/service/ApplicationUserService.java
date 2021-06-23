package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ApplicationUser;
import com.example.demo.vo.ApplicationUserVO;
import com.example.demo.vo.ApplicationUserVO1;

public interface ApplicationUserService {

	public List<ApplicationUserVO> getByUserName(String userName);

	public List<ApplicationUserVO> getByApplicationId(Integer applicationId);

	public ApplicationUser addApplicationUser(ApplicationUserVO applicationUserVO);

	public ApplicationUser addApplication(ApplicationUserVO1 applicationUserVO1) throws Exception;

}
