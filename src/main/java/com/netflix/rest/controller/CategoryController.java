package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.response.NetflixResponse;
import com.netflix.rest.restModel.CategoryRestModel;
import com.netflix.rest.service.CategoryServiceI;
import com.netflix.rest.utils.constants.CommonConstants;
import com.netflix.rest.utils.constants.RestConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

/**
 * The Class CategoryController.
 */
@RestController
@SwaggerDefinition
@RequestMapping(RestConstants.RESOURCE_CATEGORY)
public class CategoryController {

	/** The category service. */
	@Autowired
	@Qualifier("CategoryServiceImpl")

	private CategoryServiceI categoryService;

	/**
	 * List all categories.
	 *
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos las categorias", 
			notes = "Este end point sirve para mostrar todas las categorias")
	@GetMapping
	public NetflixResponse<List<CategoryRestModel>> listAllCategory() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				categoryService.listAllCategory());
	}

}
