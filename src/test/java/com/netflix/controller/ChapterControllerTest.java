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

import com.netflix.rest.exception.NotFoundException;
import com.netflix.rest.restModel.ChapterRestModel;
import com.netflix.rest.serviceImp.ChapterServiceImpl;
import com.netflix.rest.utils.constants.ExceptionConstants;

/**
 * The Class ChapterControllerTest.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ChapterControllerTest {

	/** The chapter service impl. */
	@MockBean
	private ChapterServiceImpl chapterServiceImpl;

	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;

	/**
	 * Testlist tv shows and number.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testlistTvShowAndNumber() throws Exception {

		List<ChapterRestModel> list = new ArrayList<ChapterRestModel>();
		list.add(new ChapterRestModel(1L, 1, "Prueba", 25));

		when(chapterServiceImpl.findByTvShowAndNumber(1, 1)).thenReturn(list);

		RequestBuilder request = MockMvcRequestBuilders.get("/tv-show/1/season/1/chapter");
		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[{\"id\":1,\"number\":1,\"name\":\"Esto es una prueba\",\"duration\":25}]}"))
				.andReturn();
	}

	/**
	 * Testlist tv shows and number not exist.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testlistTvShowAndNumberNotExist() throws Exception {

		when(chapterServiceImpl.findByTvShowAndNumber(1, 1))
				.thenThrow(new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));

		RequestBuilder request = MockMvcRequestBuilders.get("/tv-show/1/season/1/chapter");
		mockMvc.perform(request).andExpect(status().isNotFound()).andExpect(content().json(
				"{\"status\":\"ERROR\",\"code\":\"404\",\"message\":\"CHAPTER INEXISTENT - Chapter does not exist\",\"data\":[]}"))
				.andReturn();
	}

	/**
	 * Testlist tv show and number and chapter number.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testlistTvShowAndNumberAndChapterNumber() throws Exception {

		ChapterRestModel chapter = new ChapterRestModel();
		chapter.setId(1L);
		chapter.setName("FIN");
		chapter.setDuration(45);
		chapter.setNumber(25);

		when(chapterServiceImpl.findByTvShowAndNumberAndChapterNumber(1, 1, 1)).thenReturn(chapter);

		RequestBuilder request = MockMvcRequestBuilders.get("/tv-show/1/season/1/chapter/1");
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

		when(chapterServiceImpl.findByTvShowAndNumberAndChapterNumber(1, 1, 1))
				.thenThrow(new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));

		RequestBuilder request = MockMvcRequestBuilders.get("/tv-show/1/season/1/chapter/1");
		mockMvc.perform(request).andExpect(status().isNotFound()).andExpect(content().json(
				"{\"status\":\"ERROR\",\"code\":\"404\",\"message\":\"CHAPTER INEXISTENT - Chapter does not exist\",\"data\":[]}"))
				.andReturn();
	}
}
