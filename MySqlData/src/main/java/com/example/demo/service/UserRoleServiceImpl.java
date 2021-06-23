package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.model.Application;
import com.example.demo.model.ApplicationUser;
import com.example.demo.model.RoleInfo;
import com.example.demo.model.UserInfo;
import com.example.demo.model.UserRole;
import com.example.demo.repo.ApplicationRepo;
import com.example.demo.repo.ApplicationUserRepo;
import com.example.demo.repo.RoleInfoRepo;
import com.example.demo.repo.UserInfoRepo;
import com.example.demo.repo.UserRoleRepo;
import com.example.demo.vo.GetAppAccessVO1;
import com.example.demo.vo.GetAppAccessVO2;
import com.example.demo.vo.GetAppAccessVO3;
import com.example.demo.vo.SaveRoleUserVO1;
import com.example.demo.vo.SaveRoleUserVO2;
import com.example.demo.vo.UserInfoVO1;
import com.example.demo.vo.UserRoleVO;
import com.example.demo.vo.UserRoleVO1;
import com.example.demo.vo.UserRoleVO2;
import com.example.exception.RoleNotFoundException;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepo userRoleRepo;

	@Autowired
	private ApplicationRepo applicationRepo;

	@Autowired
	private RoleInfoRepo roleInfoRepo;

	@Autowired
	private UserInfoRepo userInfoRepo;
	
	@Autowired
	ApplicationUserRepo applicationUserRepo;
	
	@Autowired
	UserRoleService userRoleService;

	@Override
	public UserRole addUserRole(UserRoleVO userRoleVO) {
		UserRole userRole = new UserRole();
		userRole.setApplicationId(userRoleVO.getApplicationId());
		userRole.setUserName(userRoleVO.getUserName());
		userRole.setRoleCode(userRoleVO.getRoleCode());
		userRole.setIsActive(userRoleVO.getIsActive());
		userRole.setCreatedBy(userRoleVO.getCreatedBy());
		userRole.setCreatedOn(userRoleVO.getCreatedOn());
		userRole.setUpdatedBy(userRoleVO.getUpdatedBy());
		userRole.setUpdatedOn(userRoleVO.getUpdatedOn());
		userRole = userRoleRepo.save(userRole);
		return userRole;
	}

	@Override
	public List<UserRole> findUserRole(Integer applicationId) {

		List<UserRole> userRole = userRoleRepo.findByApplicationId(applicationId);

		List<UserRole> result = new ArrayList<>();

		for (int i = 0; i < userRole.size(); i++) {

			UserRole userRole2 = new UserRole();

			userRole2.setUserroleid(userRole.get(i).getUserroleid());
			userRole2.setApplicationId(userRole.get(i).getApplicationId());
			userRole2.setUserName(userRole.get(i).getUserName());
			userRole2.setRoleCode(userRole.get(i).getRoleCode());
			userRole2.setIsActive(userRole.get(i).getIsActive());
			userRole2.setCreatedBy(userRole.get(i).getCreatedBy());
			userRole2.setCreatedOn(userRole.get(i).getCreatedOn());
			userRole2.setUpdatedBy(userRole.get(i).getUpdatedBy());
			userRole2.setUpdatedOn(userRole.get(i).getUpdatedOn());

			result.add(userRole2);

		}
		return result;

	}

	@Override
	public void deleteUserRole(UserRoleVO1 userRoleVO1) {

		String appName;

		appName = userRoleVO1.getAppName();

		Application application = applicationRepo.findByApplicationname(appName);

		Integer appId = application.getApplicationId();

		String userName1 = userRoleVO1.getUserName();
		Integer roleCode1 = userRoleVO1.getRoleCode();

		List<UserRole> userRoles = userRoleRepo.findByApplicationId(appId);

		for (int i = 0; i < userRoles.size(); i++) {

			Integer roleCode2 = userRoles.get(i).getRoleCode();

			String userName2 = userRoles.get(i).getUserName();
			Integer userRoleId = userRoles.get(i).getUserroleid();

			if (roleCode1.equals(roleCode2)) {

				if (userName1.equals(userName2)) {

					userRoleRepo.deleteById(userRoleId);

					System.out.println("Its Done !");

				}
			}

		}

	}

	@Override
	public List<UserInfoVO1> getUserRoles(UserRoleVO2 userRoleVO2) throws RoleNotFoundException {

		String appName = userRoleVO2.getAppName();
		Application application = applicationRepo.findByApplicationname(appName);
		List<UserInfoVO1> result = new ArrayList<>();

		int counter = 0;
		try {
			if (application != null) {
				Integer appId = application.getApplicationId();
				List<RoleInfo> rolesInfo = roleInfoRepo.findByApplicationApplicationId(appId);
				if (!CollectionUtils.isEmpty(rolesInfo)) {
					for (RoleInfo roleInfo : rolesInfo) {
						Integer roleCode = roleInfo.getRolecode();
						if (roleCode.equals(userRoleVO2.getRoleCode())) {
							List<UserRole> userRoles = userRoleRepo.findByRoleCode(roleCode);
							if (!CollectionUtils.isEmpty(userRoles)) {
								result = userRoles.stream().map(userRole -> {
									UserInfo userInfo = userInfoRepo.getUserByUserName(userRole.getUserName());
									UserInfoVO1 userInfoVO1 = new UserInfoVO1();
									userInfoVO1.setUserId(userInfo.getUserid());
									userInfoVO1.setUserName(userRole.getUserName());
									return userInfoVO1;
								}).collect(Collectors.toList());
							}
							counter++;
						}
					}
				}
			}
			if (counter > 0) {
				return result;
			} else {
				throw new RoleNotFoundException("Role Not found !");
			}
		} catch (Exception e) {
			throw new RoleNotFoundException("Application Not found !");
		}

	}

	@Override
	public List<UserRole> findByRoleCode(Integer roleCode) {

		List<UserRole> result = new ArrayList<>();

		List<UserRole> userRole = userRoleRepo.findByRoleCode(roleCode);

		if (userRole != null) {

			for (int i = 0; i < userRole.size(); i++) {

				UserRole userRole2 = new UserRole();

				userRole2.setUserroleid(userRole.get(i).getUserroleid());
				userRole2.setApplicationId(userRole.get(i).getApplicationId());
				userRole2.setUserName(userRole.get(i).getUserName());
				userRole2.setRoleCode(userRole.get(i).getRoleCode());
				userRole2.setIsActive(userRole.get(i).getIsActive());
				userRole2.setCreatedBy(userRole.get(i).getCreatedBy());
				userRole2.setCreatedOn(userRole.get(i).getCreatedOn());
				userRole2.setUpdatedBy(userRole.get(i).getUpdatedBy());
				userRole2.setUpdatedOn(userRole.get(i).getUpdatedOn());

				result.add(userRole2);

			}
		}
		return result;
	}

	
	@Override
	public UserRole addMultipleUserRole(SaveRoleUserVO1 saveRoleUserVO1,String createdBy,String updatedBy) throws Exception {
		Application application = applicationRepo.findByApplicationKey(saveRoleUserVO1.getApplicationKey());

		Integer appId = application.getApplicationId();
		
		List<RoleInfo> roleInfo = roleInfoRepo.findByApplicationApplicationId(appId);
		
		Integer rCode = saveRoleUserVO1.getRoleCode();
        
		Integer counter = 0;
		
		for(int i =0;i<roleInfo.size();i++) {
			Integer arCode=roleInfo.get(i).getRolecode();
			if(arCode.equals(rCode)) {
				counter++;
			}
		}
		
		List<SaveRoleUserVO2> users = saveRoleUserVO1.getRoleUser();
		
		if(counter >= 1) {
			List<UserRole> userRoles = userRoleRepo.findByRoleCode(rCode);
			
			for(int j=0;j<userRoles.size();j++) {
				userRoleRepo.delete(userRoles.get(j));
			}
			
			for(SaveRoleUserVO2 userVO2:users) {
				UserInfo userInfo = userInfoRepo.getUserByUserName(userVO2.getUserName());
				if(userInfo != null) {
					UserRole userRole = new UserRole();
					userRole.setApplicationId(appId);
					userRole.setRoleCode(rCode);
					userRole.setUserName(userVO2.getUserName());
					userRole.setCreatedBy(createdBy);
					userRole.setCreatedOn(new Date());
					userRole.setUpdatedOn(new Date() );
					userRole.setUpdatedBy(updatedBy);
					userRole.setIsActive('Y');
					userRoleRepo.save(userRole);
					userInfo = null;
				}else {
					Exception exception = new Exception(userVO2.getUserName()+" "+"is wrong !");
					throw exception;
				}
			}
			
		}else {
			Exception exp = new Exception(rCode+" "+"is wrong !");
			throw exp;
		}
		return null;
		
	}

	@Override
	public GetAppAccessVO1 getAppAccess(String userName) {
		UserInfo userInfo = userInfoRepo.getUserByUserName(userName);
		
		GetAppAccessVO1 getAppAccessVO1 = new GetAppAccessVO1();
		getAppAccessVO1.setUserName(userName);
		getAppAccessVO1.setBusinessUnitId(userInfo.getBusinessUnitId());
		getAppAccessVO1.setContactNumber(userInfo.getContactNumber());
		getAppAccessVO1.setCurrentTimeZone(userInfo.getCurrentTimeZone());
		getAppAccessVO1.setDepartment(userInfo.getDepartment());
		getAppAccessVO1.setDesignation(userInfo.getDesignation());
		getAppAccessVO1.setEmailId(userInfo.getEmailId());
		getAppAccessVO1.setExternalUserId(userInfo.getExternalUserId());
		getAppAccessVO1.setDomicileCountryCode(userInfo.getDomicileCountryCode());
		getAppAccessVO1.setCreatedBy(userInfo.getCreatedBy());
		getAppAccessVO1.setCreatedOn(userInfo.getCreatedOn());
		getAppAccessVO1.setUpdatedBy(userInfo.getUpdatedBy());
		getAppAccessVO1.setUpdatedOn(userInfo.getUpdatedOn()); 
		getAppAccessVO1.setFirstName(userInfo.getFirstName());
		getAppAccessVO1.setMiddleName(userInfo.getMiddleName());
		getAppAccessVO1.setLastName(userInfo.getLastName());
		getAppAccessVO1.setReportingManager(userInfo.getReportingManager());
		getAppAccessVO1.setIsActive(userInfo.getIsActive());
		getAppAccessVO1.setRegionCode(userInfo.getRegionCode());
		
	    List<UserRole> userRoles = userRoleRepo.findUserByUserName(userName);
	  
	    List<ApplicationUser> applicationUsers = applicationUserRepo.findByUserName(userName);
	    
	    List<GetAppAccessVO2> answers = new ArrayList<GetAppAccessVO2>();
	    for(int i = 0 ;i<applicationUsers.size();i++) {
	    	Application application = applicationRepo.getOne(applicationUsers.get(i).getApplicationId());
	        String appName = application.getApplicationname();
	        List<UserRole> userRoles2 = userRoleService.getUserRoleByUserName(userName, application.getApplicationId()) ;
	        
	         List<GetAppAccessVO3> ans = new ArrayList<GetAppAccessVO3>();
	         for(int j=0;j<userRoles2.size();j++){
	        	 GetAppAccessVO3 getAppAccessVO3 = new GetAppAccessVO3();
	        	 getAppAccessVO3.setRoleCode(userRoles2.get(j).getRoleCode());
	        	 RoleInfo rCode = roleInfoRepo.getOne(userRoles2.get(j).getRoleCode());
	        	  getAppAccessVO3.setRoleName(rCode.getRolename());
	        	 ans.add(getAppAccessVO3);
	         }
	         GetAppAccessVO2 getAppAccessVO2 = new GetAppAccessVO2();
	         getAppAccessVO2.setApplicationName(appName);
	         getAppAccessVO2.setListOfRoles(ans);   
	         answers.add(getAppAccessVO2);
	     }
	     getAppAccessVO1.setListOfAllWorkingSets(answers);
	 
		return getAppAccessVO1;
	}

	@Override
	public List<UserRole> getUserRoleByUserName(String userName,Integer applicationId) {
		List<UserRole> userRole = userRoleRepo.findByApplicationId(applicationId);
		List<UserRole> ans = new ArrayList<>();
		for(int i =0;i<userRole.size();i++) {
			String uName=userRole.get(i).getUserName();
		if(uName.equals(userName)) {
	        UserRole userRole2 = new UserRole();
            userRole2.setUserroleid(userRole.get(i).getUserroleid());
			userRole2.setApplicationId(userRole.get(i).getApplicationId());
			userRole2.setUserName(userRole.get(i).getUserName());
			userRole2.setRoleCode(userRole.get(i).getRoleCode());
			userRole2.setIsActive(userRole.get(i).getIsActive());
			userRole2.setCreatedBy(userRole.get(i).getCreatedBy());
			userRole2.setCreatedOn(userRole.get(i).getCreatedOn());
			userRole2.setUpdatedBy(userRole.get(i).getUpdatedBy());
			userRole2.setUpdatedOn(userRole.get(i).getUpdatedOn());

			ans.add(userRole2);
		}
		}
 		return ans;
	}

}
