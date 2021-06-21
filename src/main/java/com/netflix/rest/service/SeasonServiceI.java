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
	 * @throws NetflixException the netflix exception
	 */
	List<Season> listAllSeason() throws NetflixException;

	/**
	 * Find by id.
	 *
	 * @param serieId the series id
	 * @return the seasons
	 * @throws NetflixException the netflix exception
	 */
	Season findById(Long serieId) throws NetflixException;

	/**
	 * Find by tv shows.
	 *
	 * @param tvshow the tvshow
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<Season> findByTvShow(TvShow tvshow) throws NetflixException;

	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshow the tvshow
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<Season> findByTvShowAndNumber(TvShow tvshow, int seasonNumber) throws NetflixException;

	/**
	 * Update season.
	 *
	 * @param id the id
	 * @param name the name
	 * @return the season
	 * @throws NetflixException the netflix exception
	 */
	Season updateSeason(Long id, String name) throws NetflixException;
		
	/**
	 * Delete season.
	 *
	 * @param season the season
	 * @return the season
	 * @throws NetflixException the netflix exception
	 */
	Season deleteSeason(Season season) throws NetflixException;

}
