package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.response.NetflixResponse;
import com.netflix.rest.restModel.ChapterRestModel;
import com.netflix.rest.service.ChapterServiceI;
import com.netflix.rest.utils.constants.CommonConstants;
import com.netflix.rest.utils.constants.RestConstants;
import org.springframework.http.MediaType;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

/**
 * The Class ChapterController.
 */
@RestController
@SwaggerDefinition
@RequestMapping(RestConstants.RESOURCE_CHAPTER)
public class ChapterController {

	/** The chapter service. */
	@Autowired
	@Qualifier("ChapterServiceImpl")

	private ChapterServiceI chapterService;

	/**
	 * List tv shows and number.
	 *
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listamos todos los capítulos y temporadas de una serie", notes = "Este end point sirve para listar todos los capitulos y temporadas de una serie en concreto, para ello "
			+ "le pasamos por parámetro el tvShow-id de la serie y el season-number de la temporada")

	@GetMapping("/tvShow/{tvShowId}/season/{seasonNumber}/chapter")
	public NetflixResponse<List<ChapterRestModel>> listTvShowsAndNumber(@PathVariable long tvShowId,
			@PathVariable(value = "seasonNumber") int seasonNumber) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				chapterService.findByTvShowAndNumber(tvShowId, seasonNumber));
	}

	/**
	 * List tv shows and number and chapter number.
	 *
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos el capítulo y temporada de una serie", 
			notes = "Este end point sirve para mostrar el capítulo y temporada de una serie, para ello "
			+ "le pasamos por parámetro el tvShow-id de la serie, el season-number de las temporada y"
			+ "el chapter-number de un capítulo")

	@GetMapping("/tvShow/{tvShowId}/season/{seasonNumber}/chapter/{chapterNumber}")
	public NetflixResponse<ChapterRestModel> listTvShowsAndNumberAndChapterNumber(@PathVariable long tvShowId,
			@PathVariable int seasonNumber, @PathVariable int chapterNumber) throws NetflixException {

		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				chapterService.findByTvShowAndNumberAndChapterNumber(tvShowId, seasonNumber, chapterNumber));
	}

	/**
	 * Update chapter name.
	 *
	 * @param chapterId the chapter id
	 * @param chapterName the chapter name
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Actualizamos el nombre de un capitulo", 
			notes = "Este end point sirve para actualizar el nombre de un capitulo por su Id")

	@PatchMapping(value = RestConstants.RESOURCE_CHAPTER_UPDATE_NAME, produces = MediaType.APPLICATION_JSON_VALUE)

	public NetflixResponse<ChapterRestModel> updateChapterName(@PathVariable Long chapterId,
			@PathVariable String chapterName) throws NetflixException {

		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				chapterService.updateChapterName(chapterId, chapterName));
	}

}
