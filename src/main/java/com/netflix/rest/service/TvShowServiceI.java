package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.TvShow;

/**
 * The Interface TvShowServiceI.
 */
public interface TvShowServiceI {

	/**
	 * List tv show by category.
	 *
	 * @param category the category
	 * @return the list
	 */
	List<TvShow> listTvShowByCategory(Long category) throws NetflixException;

	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 */
	TvShow findById(Long tvShowId) throws NetflixException;

	/**
	 * Update tv show.
	 *
	 * @param tvShow the tv show
	 * @return the tv show
	 */
	TvShow updateTvShow(TvShow tvShow) throws NetflixException;
	
	/**
	 * Update tv show.
	 *
	 * @param tvShow the tv show
	 * @return the tv show
	 */
	TvShow updateTvShowName(Long id, String name) throws NetflixException;
	
	/**
	 * Update tv show.
	 *
	 * @param tvShow the tv show
	 * @return the tv show
	 */
	TvShow deleteTvShow(TvShow tvShow) throws NetflixException;

}
