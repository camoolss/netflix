package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Season;
import com.netflix.rest.model.TvShow;

/**
 * The Interface SeasonServiceI.
 */
public interface SeasonServiceI {

	/**
	 * List all seasons.
	 *
	 * @return the list
	 */
	List<Season> listAllSeason() throws NetflixException;

	/**
	 * Find by id.
	 *
	 * @param serieId the series id
	 * @return the seasons
	 */
	Season findById(Long serieId) throws NetflixException;

	/**
	 * Find by tv shows.
	 *
	 * @param tvshow the tvshow
	 * @return the list
	 */
	List<Season> findByTvShow(TvShow tvshow) throws NetflixException;

	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshow the tvshow
	 * @param seasonNumber the season number
	 * @return the list
	 */
	List<Season> findByTvShowAndNumber(TvShow tvshow, int seasonNumber) throws NetflixException;

}
