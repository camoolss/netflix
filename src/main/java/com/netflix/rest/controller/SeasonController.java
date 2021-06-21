package com.netflix.rest.controller;

import java.util.List;

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
import com.netflix.rest.model.Season;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.service.SeasonServiceI;

import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class SeasonController.
 */
@RestController
public class SeasonController {

	/** The season service. */
	@Autowired
	@Qualifier("SeasonServiceImpl")
	private SeasonServiceI seasonService;

	/**
	 * List season by id.
	 *
	 * @param serieId the serie id
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	
	@ApiOperation(value = "Mostramos los capitulos de la serie elegida"
            ,notes = "Este end point sirve para listar todos los capitulos de la serie elegida, para ello le pasamos como"
            		+ "parámetro el tvShow-id de la serie")
	
	@GetMapping("/serie/{serieId}/season")
	public List<Season> listSeasonById(@PathVariable(value = "serieId") Long serieId) throws NetflixException {
		final TvShow tvShow = new TvShow();
		tvShow.setId(serieId);
		return seasonService.findByTvShow(tvShow);
	}

	/**
	 * List tv show and number.
	 *
	 * @param serieId the serie id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos el número de temporadas de la serie elegida"
            ,notes = "Este end point sirve para mostrar el número de temporadas de la serie elegida, para ello le pasamos como"
            		+ "parámetro el tvShow-id de la serie y el season-number de la temporada")
	
	@GetMapping("/serie/{serieId}/season/{seasonNumber}")
	public List<Season> listTvShowAndNumber(@PathVariable(value = "serieId") Long serieId,
			@PathVariable(value = "seasonNumber") int seasonNumber) throws NetflixException {
		final TvShow tvShow = new TvShow();
		tvShow.setId(serieId);
		return seasonService.findByTvShowAndNumber(tvShow, seasonNumber);
	}
	
	/**
	 * Update season.
	 *
	 * @param id the id
	 * @param name the name
	 * @return the response entity
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Actualizamos los nombres de los capitulos de la serie elegida"
            ,notes = "Este end point sirve para actualizar todos los nombres del capitulo elegido, para ello le pasamos como"
            		+ "parámetro el seasonId del capitulo")
	
	@PostMapping("/season/update/{seasonId}/")
	public ResponseEntity<String> updateSeason(@PathVariable(value = "seasonId") Long id, @RequestParam String name)
			throws NetflixException {
		seasonService.updateSeason(id, name);
		return ResponseEntity.status(HttpStatus.OK).body("Se a actualizado el nombre del capitulo correctamente");
	}

}
