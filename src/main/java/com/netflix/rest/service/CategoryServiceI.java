package com.netflix.rest.service;

import java.util.List;
import java.util.Set;

import com.netflix.rest.model.Category;

/**
 * The Interface CategoryServiceI.
 */
public interface CategoryServiceI {
	
	/**
	 * List all category.
	 *
	 * @return the list
	 */
	List<Category> listAllCategory();
	

	/**
	 * List category by ids.
	 *
	 * @param listCategoryId the list category ids
	 * @return the sets the
	 */
	Set<Category> listCategoryById(Set<Long> listCategoryId);
}
