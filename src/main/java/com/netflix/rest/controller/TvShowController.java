package com.netflix.rest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.response.NetflixResponse;
import com.netflix.rest.restModel.TvShowRestModel;
import com.netflix.rest.service.CategoryServiceI;
import com.netflix.rest.service.ChapterServiceI;
import com.netflix.rest.service.TvShowServiceI;
import com.netflix.rest.utils.constants.CommonConstants;
import com.netflix.rest.utils.constants.RestConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

/**
 * The Class TvShowController.
 */
@RestController
@SwaggerDefinition
@RequestMapping(RestConstants.RESOURCE_TV_SHOW)
public class TvShowController {

	/** The tv shows service. */
	@Autowired
	@Qualifier("TvShowServiceImpl")

	private TvShowServiceI tvShowService;

	/** The categories service. */
	@Autowired
	@Qualifier("CategoryServiceImpl")

	private CategoryServiceI categoryService;
	
	@Autowired
	@Qualifier("ChapterServiceImpl")

	private ChapterServiceI chapterService;


	/**
	 * List tv show by name.
	 *
	 * @param categoryId the category id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos las series por el Id de la categoria", 
			notes = "Este end point sirve para obtener una lista de las series pasandole como parámetro el category-id")

	@GetMapping("/category/{categoryId}")
	public NetflixResponse<List<TvShowRestModel>> listTvShowByCategoryId(@PathVariable Long categoryId)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.findByCategoryId(categoryId));
	}

	/**
	 * List tv shows by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos las series por el tvShow-id de la serie", 
			notes = "Este end point sirve para obtener las series, le pasamos el parámetro del tvShow-id")

	@GetMapping("/{tvShow-id}")
	public NetflixResponse<TvShowRestModel> listTvShowsById(@PathVariable(value = "tvShow-id") Long tvShowId)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.findById(tvShowId));
	}

	/**
	 * Adds the categories to tv show.
	 *
	 * @param tvShowId       the tv show id
	 * @param listCategories the list categories
	 * @return the response entity
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Añadimos una categoria nueva a una serie", 
			notes = "Este end point sirve añadir una categoria nueva a una serie, para ello debemos pasarle "
			+ "los parametros de listCategories y tvShowId")

	@PostMapping("/{tvShow-id}/category")
	public ResponseEntity<String> addCategoriesToTvShow(@PathVariable(value = "tvShow-id") Long tvShowId,
			@RequestParam Set<Long> listCategories) throws NetflixException {
		return ResponseEntity.status(HttpStatus.OK).body("La categoria se ha insertado correctamente");
	}

	/**
	 * Update tv show name.
	 *
	 * @param tvShowId   the tv show id
	 * @param tvShowName the tv show name
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Actualizamos el nombre de una serie", 
			notes = "Este end point sirve para actualizar el nombre de una serie por su Id")

	@PatchMapping(value = RestConstants.RESOURCE_TV_SHOW_UPDATE_NAME, produces = MediaType.APPLICATION_JSON_VALUE)

	public NetflixResponse<TvShowRestModel> updateTvShowName(@PathVariable Long tvShowId,
			@PathVariable String tvShowName) throws NetflixException {

		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.updateTvShowName(tvShowId, tvShowName));
	}

	/**
	 * Delete tv show by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Eliminamos una serie", 
			notes = "Este end point sirve para eliminar una serie, para ello debemos pasarle como parámetro su tvShowId")

	@DeleteMapping(value = RestConstants.RESOURCE_ID)
	public NetflixResponse<String> deleteTvShowById(@PathVariable(value = "id") Long tvShowId) throws NetflixException {
		tvShowService.deleteByTvShowId(tvShowId);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK);
	}
	
	@ApiOperation(value = "Mostramos las series en las que aparece el actor", 
			notes = "Este end point sirve para mostrar todas las series que aparezca el actor,"
					+ " para ello debemos pasarle como parámetro su actorId")
	@GetMapping("/{actorId}/TvShowAndChapter")
	public NetflixResponse<List<TvShow>> listTvShowAndChapterById(@PathVariable(value = "actorId") Long actorId)
			throws NetflixException {
		List<TvShow> tvShow  = tvShowService.listTvShowByActorid(actorId);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShow);
	}
}
