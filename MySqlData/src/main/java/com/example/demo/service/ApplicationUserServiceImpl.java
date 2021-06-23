package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Application;
import com.example.demo.model.ApplicationUser;
import com.example.demo.model.UserInfo;
import com.example.demo.repo.ApplicationRepo;
import com.example.demo.repo.ApplicationUserRepo;
import com.example.demo.repo.UserInfoRepo;
import com.example.demo.vo.ApplicationUserVO;
import com.example.demo.vo.ApplicationUserVO1;
import com.example.demo.vo.User;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

	@Autowired
	ApplicationUserRepo applicationUserRepo;

	@Autowired
	ApplicationRepo applicationRepo;

	@Autowired
	UserInfoRepo userInfoRepo;

	@Override
	public List<ApplicationUserVO> getByUserName(String userName) {
		List<ApplicationUserVO> result = new ArrayList<>();
		List<ApplicationUser> applicationUser = applicationUserRepo.findByUserName(userName);

		for (int i = 0; i < applicationUser.size(); i++) {
			ApplicationUserVO applicationUserVO = new ApplicationUserVO();
			applicationUserVO.setCreatedBy(applicationUser.get(i).getCreatedBy());
			applicationUserVO.setUpdatedBy(applicationUser.get(i).getUpdatedBy());
			applicationUserVO.setApplicationId(applicationUser.get(i).getApplicationId());
			applicationUserVO.setCreatedOn(applicationUser.get(i).getCreatedOn());
			result.add(applicationUserVO);
		}
		return result;
	}

	@Override
	public List<ApplicationUserVO> getByApplicationId(Integer applicationId) {
		List<ApplicationUserVO> result = new ArrayList<>();
		List<ApplicationUser> applicationUser = applicationUserRepo.findByApplicationId(applicationId);

		for (int i = 0; i < applicationUser.size(); i++) {
			ApplicationUserVO applicationUserVO = new ApplicationUserVO();
			applicationUserVO.setCreatedBy(applicationUser.get(i).getCreatedBy());
			applicationUserVO.setUpdatedBy(applicationUser.get(i).getCreatedBy());
			result.add(applicationUserVO);
		}
		return result;
	}

	@Override
	public ApplicationUser addApplicationUser(ApplicationUserVO applicationUserVO) {
		ApplicationUser applicationUser = new ApplicationUser();

		applicationUser.setApplicationId(applicationUserVO.getApplicationId());
		applicationUser.setIsActive(applicationUserVO.getIsActive());
		applicationUser.setUserName(applicationUserVO.getUserName());
		applicationUser.setCreatedBy(applicationUserVO.getCreatedBy());
		applicationUser.setCreatedOn(applicationUserVO.getCreatedOn());
		applicationUser.setUpdatedOn(applicationUserVO.getUpdatedOn());
		applicationUser.setUpdatedBy(applicationUserVO.getUpdatedBy());

		applicationUser = applicationUserRepo.save(applicationUser);

		return applicationUser;
	}

	@Override
	public ApplicationUser addApplication(ApplicationUserVO1 applicationUserVO1) throws Exception {

		Application application = applicationRepo.findByApplicationKey(applicationUserVO1.getAppkey());

		Integer appId = application.getApplicationId();

		List<User> user = applicationUserVO1.getUsers();

		List<ApplicationUser> applicationUser1 = applicationUserRepo.findByApplicationId(appId);

		if (applicationUser1 != null) {
			for (int i = 0; i < applicationUser1.size(); i++) {
				applicationUserRepo.delete(applicationUser1.get(i));
			}
		}
		for (User user2 : user) {
			UserInfo userInfo = userInfoRepo.getUserByUserName(user2.getUserName());
			if (userInfo != null) {
				ApplicationUser applicationUser = new ApplicationUser();
				applicationUser.setApplicationId(appId);
				applicationUser.setUserName(user2.getUserName());
				applicationUser.setIsActive('Y');
				applicationUser.setCreatedBy(userInfo.getCreatedBy());
				applicationUser.setCreatedOn(userInfo.getCreatedOn());
				applicationUser.setUpdatedBy(userInfo.getUpdatedBy());
				applicationUser.setUpdatedOn(userInfo.getUpdatedOn());
				applicationUserRepo.save(applicationUser);
				userInfo = null;
			} else {
				Exception exception = new Exception(user2.getUserName() + " is not present in the system !");
				throw exception;
			}
		}
		return null;

	}

}
