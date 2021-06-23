package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserInfo;
import com.example.demo.repo.UserInfoRepo;
import com.example.demo.vo.UserInfoVO;
import com.example.demo.vo.UserInfoVO1;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoRepo userInfoRepo;

	@Override
	public UserInfoVO getUserByEmailId(String emailId) {
		UserInfo userInfo = userInfoRepo.findByEmailId(emailId);
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
		return userInfoVO;
	}

	@Override
	public UserInfo addUserInfo(UserInfoVO userInfoVO) {
		UserInfo users = userInfoRepo.findByEmailId(userInfoVO.getEmailId());
		if (users == null) {
			users = setUserInfo(userInfoVO);
			UserInfo userInfo = userInfoRepo.save(users);
			userInfo.setUserName(("" + userInfo.getFirstName().charAt(0)) + (userInfo.getLastName().charAt(0))
					+ (String.valueOf(userInfo.getUserid())));
			users = userInfoRepo.save(userInfo);
		} else {
			users.setBusinessUnitId(userInfoVO.getBusinessUnitId());
			users.setContactNumber(userInfoVO.getContactNumber());
			users.setCreatedBy(userInfoVO.getCreatedBy());
			users.setCreatedOn(userInfoVO.getCreatedOn());
			users.setCurrentTimeZone(userInfoVO.getCurrentTimeZone());
			users.setDepartment(userInfoVO.getDepartment());
			users.setDesignation(userInfoVO.getDesignation());
			users.setDomicileCountryCode(userInfoVO.getDomicileCountryCode());
			users.setEmailId(userInfoVO.getEmailId());
			users.setExternalUserId(userInfoVO.getExternalUserId());
			users.setFirstName(userInfoVO.getFirstName());
			users.setLastName(userInfoVO.getLastName());
			users.setMiddleName(userInfoVO.getMiddleName());
			users.setIsActive(userInfoVO.getIsActive());
			users.setRegionCode(userInfoVO.getRegionCode());
			users.setReportingManager(userInfoVO.getReportingManager());
			users.setUpdatedBy(userInfoVO.getUpdatedBy());
			users.setUpdatedOn(userInfoVO.getUpdatedOn());
			users.setUserName(userInfoVO.getUserName());
			String s=""+users.getFirstName().charAt(0)+users.getLastName().charAt(0)+String.valueOf(users.getUserid());
			users.setUserName(s);
			users = userInfoRepo.save(users);
		
		}
		return users;
	}		
	
	private UserInfo setUserInfo(UserInfoVO userInfoVO) {
		UserInfo userInfo = new UserInfo();
		userInfo.setBusinessUnitId(userInfoVO.getBusinessUnitId());
		userInfo.setContactNumber(userInfoVO.getContactNumber());
		userInfo.setCreatedBy(userInfoVO.getCreatedBy());
		userInfo.setCreatedOn(userInfoVO.getCreatedOn());
		userInfo.setCurrentTimeZone(userInfoVO.getCurrentTimeZone());
		userInfo.setDepartment(userInfoVO.getDepartment());
		userInfo.setDesignation(userInfoVO.getDesignation());
		userInfo.setDomicileCountryCode(userInfoVO.getDomicileCountryCode());
		userInfo.setEmailId(userInfoVO.getEmailId());
		userInfo.setExternalUserId(userInfoVO.getExternalUserId());
		userInfo.setFirstName(userInfoVO.getFirstName());
		userInfo.setLastName(userInfoVO.getLastName());
		userInfo.setMiddleName(userInfoVO.getMiddleName());
		userInfo.setIsActive(userInfoVO.getIsActive());
		userInfo.setRegionCode(userInfoVO.getRegionCode());
		userInfo.setReportingManager(userInfoVO.getReportingManager());
		userInfo.setUpdatedBy(userInfoVO.getUpdatedBy());
		userInfo.setUpdatedOn(userInfoVO.getUpdatedOn());
		userInfo.setUserName(userInfoVO.getUserName());
		return userInfoRepo.save(userInfo);
	}

	@Override
	public void deleteUser(String emailId) {

		UserInfo userInfo = userInfoRepo.findByEmailId(emailId);
		userInfoRepo.save(userInfo);
		userInfoRepo.delete(userInfo);

	}

	@Override
	public UserInfoVO getUserByUserName(String userName) {
		UserInfo userInfo = userInfoRepo.getUserByUserName(userName);
		UserInfoVO userInfoVO = new UserInfoVO();
		if(userInfo != null) {
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
	
		}
		return userInfoVO;
	}

	@Override
	public void deleteUserByUserName(String userName) {

		UserInfo userInfo = userInfoRepo.getUserByUserName(userName);
		userInfoRepo.save(userInfo);
		userInfoRepo.delete(userInfo);

	}

	@Override
	public String deleteAll() {
		userInfoRepo.deleteAll();
		return "Deleted All";
	}

	@Override
	public UserInfoVO1 findUserByUserName(String userName) {
		UserInfo userInfo = userInfoRepo.getUserByUserName(userName);
		UserInfoVO1 userInfoVO1 = new UserInfoVO1();
		userInfo.setUserName(userInfoVO1.getUserName());
		userInfo.setUserid(userInfoVO1.getUserId());
		return userInfoVO1;
	}

	
	
	
	
	
}
