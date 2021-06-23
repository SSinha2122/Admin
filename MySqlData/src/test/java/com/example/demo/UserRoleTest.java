package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.example.demo.vo.UserRoleVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserRoleController.class)
public class UserRoleTest {
	
    @Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserRoleService service;

	@Test
	public void addUserRole() throws Exception {

		UserRole mockuserrole = new UserRole();

		mockuserrole.setApplicationId(1);
		mockuserrole.setUserName("JK3");
		mockuserrole.setRoleCode(1);
		
		mockuserrole.setCreatedBy("Anubhab");
		mockuserrole.setCreatedOn(null);
		mockuserrole.setUpdatedBy("Anubhab");
		mockuserrole.setUpdatedOn(null);
		mockuserrole.setIsActive('Y');

		System.out.println("its done");

		String inputInJson = this.mapToJson(mockuserrole);
		

		Mockito.when(service.addUserRole(Mockito.any(UserRoleVO.class))).thenReturn(mockuserrole);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addUserRole").accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}