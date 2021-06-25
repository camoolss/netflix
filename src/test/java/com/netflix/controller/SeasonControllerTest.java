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
import com.netflix.rest.model.TvShow;
import com.netflix.rest.restModel.SeasonRestModel;
import com.netflix.rest.serviceImp.SeasonServiceImpl;
import com.netflix.rest.utils.constants.ExceptionConstants;

/**
 * The Class SeasonControllerTest.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class SeasonControllerTest {

	/** The season service impl. */
	@MockBean
	private SeasonServiceImpl seasonServiceImpl;

	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;

	/**
	 * Testlist season by id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testlistSeasonById() throws Exception {

		List<SeasonRestModel> list = new ArrayList<SeasonRestModel>();
		list.add(new SeasonRestModel(1L, 1, "Test"));

		TvShow tvShow = new TvShow();
		tvShow.setId(2L);
		tvShow.setName("Lucifer");
		tvShow.setShortDescription("Lucifer el demoni sale del infierno para cambiar de aires");
		tvShow.setLongDescription("Lucifer el demoni sale del infierno para cambiar de aires y se hace asesor de la policia");
		tvShow.setYear(2005);
		tvShow.setRecommendedAge(16);
		tvShow.setAdvertising("Serie recomendada para mayores de 16 años");

		when(seasonServiceImpl.findByTvShow(tvShow)).thenReturn(list);

		RequestBuilder request = MockMvcRequestBuilders.get("/tv-show/1/season");
		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(
						content().json("{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[]}"))
				.andReturn();
	}

	/**
	 * Testlist season by id not exist.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testlistSeasonByIdNotExist() throws Exception {

		TvShow tvShow = new TvShow();
		when(seasonServiceImpl.findByTvShow(tvShow))
				.thenThrow(new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON));

		RequestBuilder request = MockMvcRequestBuilders.get("/tv-show/1/season");
		mockMvc.perform(request).andExpect(status().isNotFound()).andExpect(content().json("")).andReturn();
	}

	/**
	 * Test seasons.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testSeason() throws Exception {

		SeasonRestModel season = new SeasonRestModel();
		season.setId(1L);
		season.setName("FIN");
		season.setNumber(25);

		when(seasonServiceImpl.findByTvShowIdAndNumber(1L, 1)).thenReturn(season);

		RequestBuilder request = MockMvcRequestBuilders.get("/tv-show/1/season/1");
		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":{\"ID\":1,\"NUMBER\":25,\"NAME\":\"FIN\"}}"))
				.andReturn();
	}

	/**
	 * Test season not exist.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testSeasonNotExist() throws Exception {

		when(seasonServiceImpl.findByTvShowIdAndNumber(1L, 1))
				.thenThrow(new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON));

		RequestBuilder request = MockMvcRequestBuilders.get("/tv-show/1/season/1");
		mockMvc.perform(request).andExpect(status().isNotFound()).andExpect(content().json(
				"{\"status\":\"ERROR\",\"code\":\"404\",\"message\":\"SEASON INEXISTENT - Season does not exist\",\"data\":[]}"))
				.andReturn();

	}

}
