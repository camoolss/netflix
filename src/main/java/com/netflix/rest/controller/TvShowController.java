package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.model.TvShow;
import com.netflix.rest.service.TvShowServiceI;

/**
 * The Class TvShowController.
 */
@RestController
public class TvShowController {
	
	/** The tv show service. */
	@Autowired
	@Qualifier("TvShowServiceImpl")
	public TvShowServiceI tvShowService;

	/**
	 * List tv show by category id.
	 *
	 * @param categoryId the category id
	 * @return the list
	 */
	@GetMapping("/listTvShow/{categoryId}")
	public List<TvShow> listTvShowByCategoryId(@PathVariable Long categoryId) {
		return tvShowService.listTvShowByCategory(categoryId);
	}

}
