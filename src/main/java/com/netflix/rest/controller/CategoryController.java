package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Category;
import com.netflix.rest.service.CategoryServiceI;

import io.swagger.annotations.ApiOperation;

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
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos las categorias", notes = "Este end point sirve para mostrar todas las categorias")

	@GetMapping("/category")
	public List<Category> listAllCategory() throws NetflixException {
		return categoryService.listAllCategory();
	}

}
