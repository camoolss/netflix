package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.rest.utils.constants.RestConstants;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.response.NetflixResponse;
import com.netflix.rest.restModel.SeasonRestModel;
import com.netflix.rest.service.SeasonServiceI;
import com.netflix.rest.utils.constants.CommonConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

/**
 * The Class SeasonController.
 */
@RestController
@SwaggerDefinition
@RequestMapping(RestConstants.RESOURCE_TV_SHOW)
public class SeasonController {

	/** The season service. */
	@Autowired
	@Qualifier("SeasonServiceImpl")
	private SeasonServiceI seasonService;

	/**
	 * List season by id.
	 *
	 * @param seriesId the series id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos los capitulos de una serie", 
			notes = "Este end point sirve para mostrar todos los capitulos de una serie, para ello le pasamos como"
			+ "parámetro el tvShow-id de la serie")

	@GetMapping(value = RestConstants.RESOURCE_SEASON)
	public NetflixResponse<List<SeasonRestModel>> listSeasonById(@PathVariable(value = "tvShowId") Long seriesId)
			throws NetflixException {
		final TvShow tvShow = new TvShow();
		tvShow.setId(seriesId);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				seasonService.findByTvShow(tvShow));
	}

	/**
	 * List tv show and number.
	 *
	 * @param tvShowId     the tv show id
	 * @param seasonNumber the season number
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos el número de temporadas de una serie en concreto", 
			notes = "Este end point sirve para mostrar el número de temporadas de una serie, para ello le pasamos como"
			+ "parámetro el tvShow-id de la serie y el season-number de la temporada")

	@GetMapping(value = RestConstants.RESOURCE_SEASON_NUMBER)
	public NetflixResponse<SeasonRestModel> listTvShowAndNumber(@PathVariable Long tvShowId,
			@PathVariable(value = "seasonNumber") int seasonNumber) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				seasonService.findByTvShowIdAndNumber(tvShowId, seasonNumber));

	}

}
