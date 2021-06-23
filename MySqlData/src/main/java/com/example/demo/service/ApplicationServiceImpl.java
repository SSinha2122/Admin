package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Application;
import com.example.demo.model.ApplicationUser;
import com.example.demo.model.RoleInfo;
import com.example.demo.model.UserInfo;
import com.example.demo.repo.ApplicationRepo;
import com.example.demo.repo.ApplicationUserRepo;
import com.example.demo.repo.RoleInfoRepo;
import com.example.demo.repo.UserInfoRepo;
import com.example.demo.vo.RoleInfoVO;
import com.example.demo.vo.UserInfoVO;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationRepo applicationRepo;

	@Autowired
	RoleInfoRepo roleInfoRepo;

	@Autowired
	UserInfoRepo userInfoRepo;

	@Autowired
	ApplicationUserRepo applicationUserRepo;

	@Override
	public List<RoleInfoVO> getByApplicationKey(String applicationKey) {

		Application application = applicationRepo.findByApplicationKey(applicationKey);
		List<RoleInfoVO> result = new ArrayList<>();

		if (application != null) {
			int appId = application.getApplicationId();
			List<RoleInfo> roleInfo = roleInfoRepo.findByApplicationApplicationId(appId);

			for (RoleInfo role : roleInfo) {
				RoleInfoVO roleInfoVO = new RoleInfoVO();
				roleInfoVO.setRoleCode(role.getRolecode());
				roleInfoVO.setRoleName(role.getRolename());
				roleInfoVO.setRoleId(role.getId());
				Character s = role.getIsactive();
				if (s == 'Y') {
					roleInfoVO.setStatus("true");
				} else {
					roleInfoVO.setStatus("false");
				}
				result.add(roleInfoVO);
			}
		}

		return result;

	}

	@Override
	public List<UserInfoVO> getUserByApplicationKey(String applicationKey) {
		Application application = applicationRepo.findByApplicationKey(applicationKey);

		List<UserInfoVO> result = new ArrayList<>();

		int appId = application.getApplicationId();

		List<ApplicationUser> applicationUser = applicationUserRepo.findByApplicationId(appId);

		for (ApplicationUser applicationUser2 : applicationUser) {
			String uName = applicationUser2.getUserName();
			if (uName != null) {
				UserInfo userInfo = userInfoRepo.getUserByUserName(uName);
				UserInfoVO userInfoVO = new UserInfoVO();
				userInfoVO.setExternalUserId(userInfo.getExternalUserId());
				userInfoVO.setUserName(userInfo.getUserName());
				userInfoVO.setFirstName(userInfo.getFirstName());
				userInfoVO.setMiddleName(userInfo.getMiddleName());
				userInfoVO.setLastName(userInfo.getLastName());
				userInfoVO.setDepartment(userInfo.getDepartment());
				userInfoVO.setDomicileCountryCode(userInfo.getDomicileCountryCode());
				userInfoVO.setBusinessUnitId(userInfo.getBusinessUnitId());
				userInfoVO.setRegionCode(userInfo.getRegionCode());
				userInfoVO.setDesignation(userInfo.getDesignation());
				userInfoVO.setCurrentTimeZone(userInfo.getCurrentTimeZone());
				userInfoVO.setReportingManager(userInfo.getReportingManager());
				userInfoVO.setEmailId(userInfo.getEmailId());
				userInfoVO.setContactNumber(userInfo.getContactNumber());
				userInfoVO.setIsActive(userInfo.getIsActive());
				userInfoVO.setCreatedBy(userInfo.getCreatedBy());
				userInfoVO.setCreatedOn(userInfo.getCreatedOn());
				userInfoVO.setUpdatedBy(userInfo.getUpdatedBy());
				userInfoVO.setUpdatedOn(userInfo.getUpdatedOn());
				result.add(userInfoVO);
			}

		}

		return result;
	}

	@Override
	public Application findByApplicationName(String applicationname) {

		
		Application application = applicationRepo.findByApplicationname(applicationname);
		
		Application application2 = new Application();
		
		application2.setApplicationId(application.getApplicationId());
		application2.setApplicationKey(application.getApplicationKey());
		application2.setApplicationname(application.getApplicationname());
		application2.setCreated_by(application.getCreated_by());
		application2.setCreated_on(application.getCreated_on());
        application2.setUpdated_by(application.getUpdated_by());
        application2.setUpdated_on(application.getUpdated_on());
		
		return application2;
	}

}
