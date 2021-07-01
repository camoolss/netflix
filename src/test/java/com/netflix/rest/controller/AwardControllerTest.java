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

import com.netflix.rest.model.Award;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.serviceImp.AwardServiceImpl;
import com.netflix.rest.utils.constants.RestConstants;

/**
 * The Class AwardControllerTest.
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AwardControllerTest {

	/** The award service. */
	@MockBean
	private AwardServiceImpl awardService;

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * Test list actor by id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testListActorById() throws Exception {
		List<Award> award = new ArrayList<Award>();
		TvShow tvShow = new TvShow();
		tvShow.setId(2L);
		tvShow.setName("Lucifer");
		tvShow.setShortDescription("Lucifer el demoni sale del infierno para cambiar de aires");
		tvShow.setLongDescription(
				"Lucifer, el demonio sale del infierno para cambiar de aires y se hace asesor de la policia");
		tvShow.setYear(2005);
		tvShow.setRecommendedAge(16);
		tvShow.setAdvertising("Serie recomendada para mayores de 16 años");

		award.add(new Award(1L, "Test", 1, tvShow));

		when(awardService.listAwardByTvShowId(2L)).thenReturn(award);

		RequestBuilder request = MockMvcRequestBuilders.get(RestConstants.RESOURCE_AWARD + "/2");
		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[{\"name\":\"Test\",\"year\":1}]}"))
				.andReturn();
	}

}
