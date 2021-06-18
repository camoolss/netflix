package com.netflix.rest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.service.CategoryServiceI;
import com.netflix.rest.service.TvShowServiceI;

import io.swagger.annotations.ApiOperation;

/**
 * The Class TvShowController.
 */
@RestController
public class TvShowController {

	/** The tv show service. */
	@Autowired
	@Qualifier("TvShowServiceImpl")

	private TvShowServiceI tvShowService;

	/** The category service. */
	@Autowired
	@Qualifier("CategoryServiceImpl")

	private CategoryServiceI categoryService;

	/**
	 * List tv show by name.
	 *
	 * @param categoryId the category id
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos las series por el Id selecionado de la categoria"
            ,notes = "Este end point sirve para obtener una lista de las series pasandole como parámetro el category-id")
	
	@GetMapping("/category/{categoryId}")
	public List<TvShow> listTvShowByName(@PathVariable(value="categoryId") Long categoryId) throws NetflixException {
		return tvShowService.listTvShowByCategory(categoryId);
	}

	/**
	 * List tv show by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv show
	 * @throws NetflixException the netflix exception
	 */
	
	@ApiOperation(value = "Mostramos las series por el tvShow-id de la serie elegida"
            ,notes = "Este end point sirve para obtener las series, le pasamos el parámetro del tvShow-id")
	
	@GetMapping("/tvShow/{serieId}")
	public TvShow listTvShowById(@PathVariable(value = "serieId") Long tvShowId) throws NetflixException {
		return tvShowService.findById(tvShowId);
	}

	/**
	 * Adds the category to tv show.
	 *
	 * @param tvShowId the tv show id
	 * @param listCategory the list category
	 * @return the response entity
	 * @throws NetflixException the netflix exception
	 */
	
	@ApiOperation(value = "Añadimos una categoria nueva a una serie especificada por nosotros"
            ,notes = "Este end point sirve añadir una categoria nueva a una serie, para ello debemos pasarle "
            		+ "los parametros de listCategories y tvShowId")
	
	@PostMapping("/tvShow/addCategory/{serieId}/")
	public ResponseEntity<String> addCategoryToTvShow(@PathVariable(value = "serieId") Long tvShowId,
			@RequestParam Set<Long> listCategory) throws NetflixException {
		Set<Category> category = categoryService.listCategoryById(listCategory);
		TvShow tvShow = tvShowService.findById(tvShowId);
		tvShow.getCategory().addAll(category);
		tvShowService.updateTvShow(tvShow);
		return ResponseEntity.status(HttpStatus.OK).body("La categoria se ha insertado correctamente");
	}

}
