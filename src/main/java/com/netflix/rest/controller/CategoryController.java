package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.model.Category;
import com.netflix.rest.service.CategoryServiceI;

/**
 * The Class CategoryController.
 */
@RestController
public class CategoryController {

	/** The category service. */
	@Autowired
	@Qualifier("CategoryServiceImpl")
	private CategoryServiceI categoryService;

	/**
	 * List all category.
	 *
	 * @return the list
	 */
	@GetMapping("/categories")
	public List<Category> listAllCategory() {
		return categoryService.listAllCategories();
	}

}
