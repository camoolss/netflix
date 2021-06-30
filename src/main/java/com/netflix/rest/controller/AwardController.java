package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Award;
import com.netflix.rest.response.NetflixResponse;
import com.netflix.rest.service.AwardServiceI;
import com.netflix.rest.utils.constants.CommonConstants;
import com.netflix.rest.utils.constants.RestConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

/**
 * The Class AwardController.
 */
@RestController
@SwaggerDefinition
@RequestMapping(RestConstants.RESOURCE_AWARD)
public class AwardController {

	/** The award service. */
	@Autowired
	@Qualifier("AwardServiceImpl")
	private AwardServiceI awardService;

	/**
	 * List actor by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos los premios de una serie", 
			notes = "Este end point sirve para obtener los premios de una serie en concreto, le pasamos el parámetro del tvShowId")

	@GetMapping(value = RestConstants.RESOURCE_TVSHOW_ID)
	public NetflixResponse<List<Award>> listActorById(@PathVariable(value = "tvShowId") Long tvShowId)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				awardService.listAwardByTvShowId(tvShowId));
	}

}
