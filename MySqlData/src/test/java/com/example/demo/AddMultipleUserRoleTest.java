package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.UserRoleController;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserRoleService;
import com.example.demo.vo.SaveRoleUserVO1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserRoleController.class)
public class AddMultipleUserRoleTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserRoleService userRoleService;

	private UserRole getUserRole() {

		UserRole userRole = new UserRole();

		userRole.setApplicationId(1);
		userRole.setUserName("AC1");
		userRole.setRoleCode(1);
		userRole.setIsActive('Y');
		userRole.setCreatedBy("TANUMOY");
		userRole.setCreatedOn(null);
		userRole.setUpdatedBy("TANUMOY");
		userRole.setUpdatedOn(null);

		return userRole;

	}

	@Test
	public void testAddMultipleUserRole() throws Exception {
		UserRole mockUserRole = getUserRole();

		String inputInJson = this.mapToJson(mockUserRole);

		when(userRoleService.addMultipleUserRole(Mockito.any(SaveRoleUserVO1.class), null, null)).thenReturn(mockUserRole);
		RequestBuilder requestbuilder = MockMvcRequestBuilders.post("/userrole/addMultipleUserRole")
				.accept(MediaType.APPLICATION_JSON).content(inputInJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestbuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(outputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	private String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);

	}

}
