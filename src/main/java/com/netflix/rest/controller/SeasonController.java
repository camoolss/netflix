package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Season;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.service.SeasonServiceI;

/**
 * The Class SeasonController.
 */
@RestController
public class SeasonController {

	/** The season service. */
	@Autowired
	@Qualifier("SeasonServiceImpl")
	private SeasonServiceI seasonService;

	/**
	 * List season by id.
	 *
	 * @param serieId the serie id
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@GetMapping("/serie/{serieId}/season")
	public List<Season> listSeasonById(@PathVariable(value = "tvShow-id") Long serieId) throws NetflixException {
		final TvShow tvShow = new TvShow();
		tvShow.setId(serieId);
		return seasonService.findByTvShow(tvShow);
	}

	/**
	 * List tv show and number.
	 *
	 * @param serieId the serie id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@GetMapping("/serie/{serieId}/season/{seasonNumber}")
	public List<Season> listTvShowAndNumber(@PathVariable(value = "tvShow-id") Long serieId,
			@PathVariable(value = "season-number") int seasonNumber) throws NetflixException {
		final TvShow tvShow = new TvShow();
		tvShow.setId(serieId);
		return seasonService.findByTvShowAndNumber(tvShow, seasonNumber);
	}

}
