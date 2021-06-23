package com.example.demo.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.UserRole;
import com.example.demo.repo.ApplicationRepo;
import com.example.demo.repo.RoleInfoRepo;
import com.example.demo.repo.UserInfoRepo;
import com.example.demo.repo.UserRoleRepo;
import com.example.demo.vo.UserRoleVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserRoleServiceImpl.class)
public class UserRoleServiceTest {
	

	@Autowired
	UserRoleService service;

	@MockBean
	UserRoleRepo userRoleRepo;
	
	@MockBean
	ApplicationRepo applicationRepo;

	@MockBean
	RoleInfoRepo roleInfoRepo;

	@MockBean
	UserInfoRepo userInfoRepo;

	private UserRole getUserRole() {
		UserRole user = new UserRole();
		user.setUserroleid(1);
		user.setApplicationId(1);
		user.setCreatedBy("Sonal");
		user.setUpdatedBy("Sonal");
		user.setUserName("Sonal");
		return user;
	}
	@Test
	public void testAddUserRole() {
		UserRole userRole = getUserRole();
		UserRoleVO userRoleVO = new UserRoleVO();
        when(userRoleRepo.save(userRole)).thenReturn(userRole);
		assertEquals(userRole, service.addUserRole(userRoleVO));
	}
	
	
	
}
