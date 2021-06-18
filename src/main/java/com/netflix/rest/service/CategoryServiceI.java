package com.netflix.rest.service;

import java.util.List;
import java.util.Set;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Category;

/**
 * The Interface CategoryServiceI.
 */
public interface CategoryServiceI {

	/**
	 * List all category.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<Category> listAllCategory() throws NetflixException;

	/**
	 * List category by id.
	 *
	 * @param listCategoryId the list category id
	 * @return the sets the
	 * @throws NetflixException the netflix exception
	 */
	Set<Category> listCategoryById(Set<Long> listCategoryId) throws NetflixException;
}
