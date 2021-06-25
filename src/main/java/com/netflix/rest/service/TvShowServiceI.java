package com.netflix.rest.service;

import java.util.List;
import java.util.Set;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.restModel.TvShowRestModel;

/**
 * The Interface TvShowServiceI.
 */
public interface TvShowServiceI {

	/**
	 * Find by category id.
	 *
	 * @param categoryId the category id
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<TvShowRestModel> findByCategoryId(Long categoryId) throws NetflixException;

	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv show rest model
	 * @throws NetflixException the netflix exception
	 */
	TvShowRestModel findById(Long tvShowId) throws NetflixException;

	/**
	 * Adds the category.
	 *
	 * @param tvShowId the tv show id
	 * @param listCategories the list categories
	 * @return the tv show rest model
	 * @throws NetflixException the netflix exception
	 */
	TvShowRestModel addCategory(Long tvShowId, Set<Long> listCategories) throws NetflixException;

	/**
	 * Update tv shows.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv show rest model
	 * @throws NetflixException the netflix exception
	 */
	TvShowRestModel updateTvShow(Long tvShowId) throws NetflixException;

	/**
	 * Update tv show name.
	 *
	 * @param tvShowId the tv show id
	 * @param tvShowName the tv show name
	 * @return the tv show rest model
	 * @throws NetflixException the netflix exception
	 */
	TvShowRestModel updateTvShowName(Long tvShowId, String tvShowName) throws NetflixException;
	
	/**
	 * Delete by tv show id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows rest model
	 * @throws NetflixException the netflix exception
	 */
	void deleteByTvShowId(Long tvShowId) throws NetflixException;
}
