package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
	 * List seasons by id.
	 *
	 * @param serieId the series id
	 * @return the list
	 */
	@GetMapping("/serie/{serieId}/season")
	public List<Season> listSeasonById(@PathVariable Long serieId) {
		final TvShow tvShow = new TvShow();
		tvShow.setId(serieId);
		return seasonService.findByTvShow(tvShow);
	}

	/**
	 * List tv shows and number.
	 *
	 * @param serieId the series id
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@GetMapping("/serie/{serieId}/season/{seasonNumber}")
	public List<Season> listTvShowAndNumber(@PathVariable Long serieId, @PathVariable int seasonNumber) {
		final TvShow tvShow = new TvShow();
		tvShow.setId(serieId);
		return seasonService.findByTvShowAndNumber(tvShow, seasonNumber);
	}

}
