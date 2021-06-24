package com.netflix.rest.service;

import java.util.List;
import java.util.Set;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Category;
import com.netflix.rest.restModel.CategoryRestModel;

/**
 * The Interface CategoryServiceI.
 */
public interface CategoryServiceI {
	
	/**
	 * List all categories.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<CategoryRestModel> listAllCategory() throws NetflixException;

	/**
	 * List categories by ids.
	 *
	 * @param listCategoriesIds the list categories ids
	 * @return the sets the
	 * @throws NetflixException the netflix exception
	 */
	Set<Category> listCategoryById(Set<Long> listCategoryId) throws NetflixException;
}
