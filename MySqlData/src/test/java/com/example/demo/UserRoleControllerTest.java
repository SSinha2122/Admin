package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.UserRoleController;
import com.example.demo.service.UserRoleService;
import com.example.demo.vo.UserInfoVO1;
import com.example.demo.vo.UserRoleVO2;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserRoleController.class)
public class UserRoleControllerTest {
	

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRoleService userinfoservice;

	private UserInfoVO1 getUserInfo() {
		UserInfoVO1 user = new UserInfoVO1();
		user.setUserId(1);
		user.setUserName("SS1");
		return user;
	}

	@SuppressWarnings("unused")
	@Test
	public void testAddUserRole() throws Exception {
		UserInfoVO1 userInfoVO1 = getUserInfo();

		List<UserInfoVO1> result = new ArrayList<>();
		result.add(userInfoVO1);
		
		Mockito.when(userinfoservice.getUserRoles(Mockito.any(UserRoleVO2.class))).thenReturn(result);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getUserRoles")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult results = mockMvc.perform(requestBuilder).andReturn();

	}

}
