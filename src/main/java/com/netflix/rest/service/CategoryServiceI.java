package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.model.Category;

/**
 * The Interface CategoryServiceI.
 */
public interface CategoryServiceI {
	
	/**
	 * List all categories.
	 *
	 * @return the list
	 */
	List<Category> listAllCategories();
}
