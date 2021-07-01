package com.netflix.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.netflix.rest.exception.NotFoundException;
import com.netflix.rest.restModel.ChapterRestModel;
import com.netflix.rest.serviceImp.ChapterServiceImpl;
import com.netflix.rest.utils.constants.ExceptionConstants;
import com.netflix.rest.utils.constants.RestConstants;

/**
 * The Class ChapterControllerTest.
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ChapterControllerTest {

	/** The chapter service impl. */
	@MockBean
	private ChapterServiceImpl chapterService;

	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;

	/**
	 * Test list tv show and number.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testListTvShowAndNumber() throws Exception {
		List<ChapterRestModel> list = new ArrayList<ChapterRestModel>();
		list.add(new ChapterRestModel(1L, 1, "Prueba", 25));

		when(chapterService.findByTvShowAndNumber(1, 1)).thenReturn(list);

		RequestBuilder request = MockMvcRequestBuilders.get(RestConstants.RESOURCE_TV_SHOW + "/1/season/1/chapter");
		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[{\"id\":1,\"number\":1,\"name\":\"Prueba\",\"duration\":25}]}"))
				.andReturn();
	}

	/**
	 * Testlist tv show and number not exist.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testlistTvShowAndNumberNotExist() throws Exception {

		when(chapterService.findByTvShowAndNumber(1, 1))
				.thenThrow(new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));

		RequestBuilder request = MockMvcRequestBuilders.get(RestConstants.RESOURCE_TV_SHOW + "/1/season/1/chapter");
		mockMvc.perform(request).andExpect(status().isNotFound()).andExpect(content().json(
				"{\"status\":\"ERROR\",\"code\":\"404\",\"message\":\"CHAPTER INEXISTENT - Chapter does not exist\",\"data\":[]}"))
				.andReturn();
	}

	/**
	 * Test list tv show and number and chapter number.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testListTvShowAndNumberAndChapterNumber() throws Exception {
		ChapterRestModel chapter = new ChapterRestModel();
		chapter.setId(1L);
		chapter.setName("FIN");
		chapter.setDuration(45);
		chapter.setNumber(25);

		when(chapterService.findByTvShowAndNumberAndChapterNumber(1L, 1, 1)).thenReturn(chapter);

		RequestBuilder request = MockMvcRequestBuilders.get(RestConstants.RESOURCE_TV_SHOW + "/1/season/1/chapter/1");
		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":{\"id\":1,\"number\":25,\"name\":\"FIN\",\"duration\":45}}"))
				.andReturn();
	}

	/**
	 * Testlist tv show and number and chapter number not exist.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testlistTvShowAndNumberAndChapterNumberNotExist() throws Exception {

		when(chapterService.findByTvShowAndNumberAndChapterNumber(1, 1, 1))
				.thenThrow(new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));

		RequestBuilder request = MockMvcRequestBuilders.get(RestConstants.RESOURCE_TV_SHOW + "/1/season/1/chapter/1");
		mockMvc.perform(request).andExpect(status().isNotFound()).andExpect(content().json(
				"{\"status\":\"ERROR\",\"code\":\"404\",\"message\":\"CHAPTER INEXISTENT - Chapter does not exist\",\"data\":[]}"))
				.andReturn();
	}

}
