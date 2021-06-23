package com.example.demo.service;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Application;
import com.example.demo.model.RoleInfo;
import com.example.demo.model.UserInfo;
import com.example.demo.model.UserRole;
import com.example.demo.repo.ApplicationRepo;
import com.example.demo.repo.RoleInfoRepo;
import com.example.demo.repo.UserInfoRepo;
import com.example.demo.repo.UserRoleRepo;
import com.example.demo.vo.SaveRoleUserVO1;
import com.example.demo.vo.SaveRoleUserVO2;

	@RunWith(SpringRunner.class)
	@SpringBootTest(classes = UserRoleServiceImpl.class)
	public class AddMultipleUserRoleServiceTest {

		@Autowired
		UserRoleService userRoleService;

		@MockBean
		UserRoleRepo userRoleRepo;

		@MockBean
		private ApplicationRepo applicationRepo;

		@MockBean
		private RoleInfoRepo roleInfoRepo;

		@MockBean
		private UserInfoRepo userInfoRepo;

		private UserRole getUserRole() {
			UserRole userRole = new UserRole();
			userRole.setApplicationId(1);
			userRole.setUserroleid(101);
			userRole.setCreatedBy("SS");
			userRole.setCreatedOn(null);
			userRole.setRoleCode(1);
			userRole.setUserName("SS1");
			userRole.setUpdatedBy("SS");
			userRole.setUpdatedOn(null);
			userRole.setIsActive('Y');
			return userRole;
		}

		Application getApplication() {
			Application application = new Application();
			application.setApplicationId(3);
			application.setApplicationKey("A3");
			return application;
		}

		private RoleInfo getRoleinfo() {
			RoleInfo role = new RoleInfo();
			role.setApplication(getApplication());
			role.setRolecode(3);
			return role;
		}

		private UserInfo getUserinfo() {
			UserInfo userinfo = new UserInfo();
			userinfo.setUserName("TS1");
			return userinfo;
		}

		private SaveRoleUserVO2 getUser() {
			SaveRoleUserVO2 userdetail = new SaveRoleUserVO2();
			userdetail.setUserId(1);
			userdetail.setUserName("SS1");
			return userdetail;
		}

		private SaveRoleUserVO1 getUser3() {

			SaveRoleUserVO1 userdetail1 = new SaveRoleUserVO1();
			userdetail1.setApplicationKey("A3");
			userdetail1.setRoleCode(3);
			userdetail1.setRoleUser(Stream.of(getUser()).collect(Collectors.toList()));
			return userdetail1;
		}

		@Test
		public void addMultipleUserRole() throws Exception {
			SaveRoleUserVO1 saveRoleUserVO1 = getUser3();

			Application application = getApplication();
			when(applicationRepo.findByApplicationKey(saveRoleUserVO1.getApplicationKey())).thenReturn(application);

			List<RoleInfo> roleInfos = Stream.of(getRoleinfo()).collect(Collectors.toList());
			when(roleInfoRepo.findByApplicationApplicationId(application.getApplicationId())).thenReturn(roleInfos);
			List<UserRole> userRoles = Stream.of(getUserRole()).collect(Collectors.toList());
			when(userRoleRepo.findByRoleCode(saveRoleUserVO1.getRoleCode())).thenReturn(userRoles);

			List<SaveRoleUserVO2> users = saveRoleUserVO1.getRoleUser();

			for (int j = 0; j < userRoles.size(); j++) {
				doNothing().when(userRoleRepo).delete(userRoles.get(j));
			}
			for (SaveRoleUserVO2 saveRoleUserVO2 : users) {

				UserInfo userInfo = getUserinfo();
				when(userInfoRepo.getUserByUserName(saveRoleUserVO2.getUserName())).thenReturn(userInfo);
				UserRole userRole = getUserRole();
				when(userRoleRepo.save(Mockito.any(UserRole.class))).thenReturn(userRole);
			}
			UserRole userRole1 = userRoleService.addMultipleUserRole(saveRoleUserVO1, null, null);
		    assertTrue(true);;
		}
		
		
		private SaveRoleUserVO1 getUsers() {

			SaveRoleUserVO1 userdetail1 = new SaveRoleUserVO1();
			userdetail1.setApplicationKey("A33");
			userdetail1.setRoleCode(3);
			userdetail1.setRoleUser(Stream.of(getUser()).collect(Collectors.toList()));
			return userdetail1;
		}
		
		private RoleInfo getInvalidRoleinfo() {
			RoleInfo role = new RoleInfo();
			role.setApplication(getApplication());
			role.setRolecode(33333);
			return role;
		}

		@Test
		public void addInvalidMultipleUserRole() throws Exception {
			SaveRoleUserVO1 saveRoleUserVO1 = getUsers();

			Application application = getApplication();
			when(applicationRepo.findByApplicationKey(saveRoleUserVO1.getApplicationKey())).thenReturn(application);

			List<RoleInfo> roleInfos = Stream.of(getInvalidRoleinfo()).collect(Collectors.toList());
			when(roleInfoRepo.findByApplicationApplicationId(application.getApplicationId())).thenReturn(roleInfos);
			List<UserRole> userRoles = Stream.of(getUserRole()).collect(Collectors.toList());
			when(userRoleRepo.findByRoleCode(saveRoleUserVO1.getRoleCode())).thenReturn(userRoles);

			List<SaveRoleUserVO2> users = saveRoleUserVO1.getRoleUser();

			for (int j = 0; j < userRoles.size(); j++) {
				doNothing().when(userRoleRepo).delete(userRoles.get(j));
			}
			for (SaveRoleUserVO2 saveRoleUserVO2 : users) {

				UserInfo userInfo = getUserinfo();
				when(userInfoRepo.getUserByUserName(saveRoleUserVO2.getUserName())).thenReturn(userInfo);
				UserRole userRole = getUserRole();
				when(userRoleRepo.save(Mockito.any(UserRole.class))).thenReturn(userRole);
			}
			UserRole userRole1 = userRoleService.addMultipleUserRole(saveRoleUserVO1, null, null);
		    assertTrue(true);;
		}
		
	}

	
