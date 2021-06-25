package com.netflix.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.netflix.rest.restModel.CategoryRestModel;
import com.netflix.rest.serviceImp.CategoryServiceImpl;
import com.netflix.rest.utils.constants.RestConstants;

/**
 * The Class CategoryControllerTest.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerTest {

	/** The category service impl. */
	@MockBean
	private CategoryServiceImpl categoryServiceImpl;

	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;

	/**
	 * Test categories.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testCategories() throws Exception {

		List<CategoryRestModel> list = new ArrayList<CategoryRestModel>();
		list.add(new CategoryRestModel(1L, "Test"));

		when(categoryServiceImpl.listAllCategory()).thenReturn(list);

		RequestBuilder request = MockMvcRequestBuilders.get(RestConstants.RESOURCE_CATEGORY);
		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[{\"id\":1,\"name\":\"Test\"}]}"))
				.andReturn();
	}

}
