package com.netflix.rest.service;

import java.util.List;

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
	List<TvShow> listTvShowByCategory(Long category);

	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 */
	TvShow findById(Long tvShowId);

	/**
	 * Update tv show.
	 *
	 * @param tvShow the tv show
	 * @return the tv shows
	 */
	TvShow updateTvShow(TvShow tvShow);

}
