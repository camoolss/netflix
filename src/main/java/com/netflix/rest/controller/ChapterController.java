package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Chapter;
import com.netflix.rest.service.ChapterServiceI;

import io.swagger.annotations.ApiOperation;

/**
 * The Class ChapterController.
 */
@RestController
public class ChapterController {

	/** The chapter service. */
	@Autowired
	@Qualifier("ChapterServiceImpl")

	private ChapterServiceI chapterService;

	/**
	 * List tv shows and number.
	 *
	 * @param serieId the series id
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@ApiOperation(value = "Mostramos todos los capítulos y temporadas de la serie elegida"
            ,notes = "Este end point sirve para mostrar todos los capitulos y temporadas de una serie en concreto que hemos elegido, para ello "
            		+ "le pasamos por parámetro el tvShow-id de la serie y el season-number de la temporada")
	
	@GetMapping("/tvShow/{serie-id}/season/{season-number}/chapter")
	public List<Chapter> listTvShowAndNumber(@PathVariable(value="serie-id") long serieId, @PathVariable(value="season-number") int seasonNumber) throws NetflixException {
		return chapterService.findByTvShowAndNumber(serieId,seasonNumber);
	}

	/**
	 * List tv show and number and chapter number.
	 *
	 * @param serieId the serie id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapter
	 */
	@ApiOperation(value = "Mostramos el capítulo y temporada de la serie elegida"
            ,notes = "Este end point sirve para mostrar el capítulo y temporada de la serie que hemos elegido, para ello "
            		+ "le pasamos por parámetro el tvShow-id de la serie, el season-number de las temporada y"
            		+ "el chapter-number de un capítulo")
	
	@GetMapping("/tvShow/{serie-id}/season/{season-number}/chapter/{chapter-number}")
	public Chapter listTvShowAndNumberAndChapterNumber(@PathVariable(value="serie-id") long serieId, 
			@PathVariable(value="season-number") int seasonNumber, @PathVariable(value="chapter-number") int chapterNumber) throws NetflixException {
		return chapterService.findByTvShowAndNumberAndChapterNumber(serieId,seasonNumber,chapterNumber);
	}

}
