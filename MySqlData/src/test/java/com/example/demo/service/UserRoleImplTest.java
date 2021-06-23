package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repo.ApplicationRepo;
import com.example.demo.repo.RoleInfoRepo;
import com.example.demo.repo.UserInfoRepo;
import com.example.demo.repo.UserRoleRepo;
import com.example.demo.vo.UserInfoVO1;
import com.example.demo.vo.UserRoleVO2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleImplTest {

	@Autowired
	private UserRoleService service;

	@MockBean
	private UserInfoRepo repo;
	
	@MockBean
	private ApplicationRepo applicationRepo;

	@MockBean
	private RoleInfoRepo roleInfoRepo;
	
	@MockBean
	private UserRoleRepo userRoleRepo;

	private UserInfoVO1 getUserInfo() {
		UserInfoVO1 user = new UserInfoVO1();
		user.setUserId(4);
		user.setUserName("UT4");
		return user;
	}

	 UserRoleVO2 getUserRole() {

		UserRoleVO2 userRoleVO2 = new UserRoleVO2();
		userRoleVO2.setAppName("FACEBOOK");
		userRoleVO2.setAction("Anything");
		userRoleVO2.setRoleCode(1);

		return userRoleVO2;

	}

	@Test
	public void testAddUserRole() throws Exception {
		UserInfoVO1 userInfoVO1 = getUserInfo();
		UserRoleVO2 userRoleVO2 = getUserRole();

	//	when(applicationRepo.findByApplicationname("FACEBOOK"));
		//when(userRoleRepo.findByRoleCode(1));
		when(repo.findUserByUserName("UT4")).thenReturn(userInfoVO1);
        List<UserInfoVO1> user1 = service.getUserRoles(userRoleVO2);

		assertEquals(userInfoVO1, user1);

	}

}
