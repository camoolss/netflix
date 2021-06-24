package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.restModel.SeasonRestModel;

/**
 * The Interface SeasonServiceI.
 */
public interface SeasonServiceI {

	/**
	 * List all season.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<SeasonRestModel> listAllSeason() throws NetflixException;

	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the season rest model
	 * @throws NetflixException the netflix exception
	 */
	SeasonRestModel findById(Long tvShowId) throws NetflixException;

	/**
	 * Find by tv shows.
	 *
	 * @param tvshow the tvshow
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<SeasonRestModel> findByTvShow(TvShow tvshow) throws NetflixException;

	/**
	 * Find by tv show id and number.
	 *
	 * @param tvshowId the tvshow id
	 * @param seasonNumber the season number
	 * @return the season rest model
	 * @throws NetflixException the netflix exception
	 */
	SeasonRestModel findByTvShowIdAndNumber(Long tvshowId, int seasonNumber) throws NetflixException;

}
