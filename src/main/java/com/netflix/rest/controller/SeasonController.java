package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.model.Seasons;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.service.SeasonsServiceI;

/**
 * The Class SeasonController.
 */
@RestController
public class SeasonController {

	/** The season service. */
	@Autowired
	@Qualifier("SeasonsServiceImpl")
	private SeasonsServiceI seasonService;

	/**
	 * List seasons by id.
	 *
	 * @param seriesId the series id
	 * @return the list
	 */
	@GetMapping("/series/{seriesId}/seasons")
	public List<Seasons> listSeasonsById(@PathVariable Long seriesId) {
		final TvShow tvShows = new TvShow();
		tvShows.setId(seriesId);
		return seasonService.findByTvShows(tvShows);
	}

	/**
	 * List tv shows and number.
	 *
	 * @param seriesId the series id
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@GetMapping("/series/{seriesId}/seasons/{seasonNumber}")
	public List<Seasons> listTvShowsAndNumber(@PathVariable Long seriesId, @PathVariable int seasonNumber) {
		final TvShow tvShows = new TvShow();
		tvShows.setId(seriesId);
		return seasonService.findByTvShowsAndNumber(tvShows, seasonNumber);
	}

}
