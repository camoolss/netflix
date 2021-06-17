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

import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.service.CategoryServiceI;
import com.netflix.rest.service.TvShowServiceI;

/**
 * The Class TvShowController.
 */
@RestController
public class TvShowController {

	/** The tv shows service. */
	@Autowired
	@Qualifier("TvShowServiceImpl")

	private TvShowServiceI tvShowService;

	/** The category service. */
	@Autowired
	@Qualifier("CategoryServiceImpl")

	private CategoryServiceI categoryService;

	/**
	 * List tv shows by name.
	 *
	 * @param categoryId the category id
	 * @return the list
	 */
	@GetMapping("/category/{categoryId}")
	public List<TvShow> listTvShowByName(@PathVariable Long categoryId) {
		return tvShowService.listTvShowByCategory(categoryId);
	}

	/**
	 * List tv shows by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 */
	@GetMapping("/tvShow/{tvShowId}")
	public TvShow listTvShowsById(@PathVariable Long tvShowId) {
		return tvShowService.findById(tvShowId);
	}

	/**
	 * Adds the category to tv show.
	 *
	 * @param tvShowId       the tv show id
	 * @param listCategory the list category
	 * @return the response entity
	 */
	@PostMapping("/tvShow/addCategory/{tvShowId}/")
	public ResponseEntity<String> addCategoryToTvShow(@PathVariable Long tvShowId,
			@RequestParam Set<Long> listCategory) {
		Set<Category> category = categoryService.listCategoryById(listCategory);
		TvShow tvShow = tvShowService.findById(tvShowId);
		tvShow.getCategory().addAll(category);
		tvShowService.updateTvShow(tvShow);
		return ResponseEntity.status(HttpStatus.OK).body("Se ha añadido la categoria correctamente");
	}

}
