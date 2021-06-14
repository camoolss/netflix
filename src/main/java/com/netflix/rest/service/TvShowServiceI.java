package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.model.Category;
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

}
