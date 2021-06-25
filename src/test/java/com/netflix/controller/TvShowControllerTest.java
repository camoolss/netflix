package com.netflix.controller;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.netflix.rest.serviceImp.TvShowServiceImpl;

/**
 * The Class TvShowsControllerTest.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class TvShowControllerTest {

	/** The tv show service impl. */
	@MockBean
	private TvShowServiceImpl tvShowServiceImpl;

	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;

}
