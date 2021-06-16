package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.model.Seasons;
import com.netflix.rest.model.TvShow;

/**
 * The Interface SeasonsServiceI.
 */
public interface SeasonsServiceI {

	/**
	 * List all seasons.
	 *
	 * @return the list
	 */
	List<Seasons> listAllSeasons();

	/**
	 * Find by id.
	 *
	 * @param seriesId the series id
	 * @return the seasons
	 */
	Seasons findById(Long seriesId);

	/**
	 * Find by tv shows.
	 *
	 * @param tvshow the tvshow
	 * @return the list
	 */
	List<Seasons> findByTvShows(TvShow tvshow);

	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshow the tvshow
	 * @param seasonNumber the season number
	 * @return the list
	 */
	List<Seasons> findByTvShowsAndNumber(TvShow tvshow, int seasonNumber);

}
