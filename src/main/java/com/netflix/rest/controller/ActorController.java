package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Actor;
import com.netflix.rest.service.ActorServiceI;

import io.swagger.annotations.ApiOperation;

/**
 * The Class ActorController.
 */
@RestController
public class ActorController {

	/** The actor service. */
	@Autowired
	@Qualifier("ActorServiceImpl")

	private ActorServiceI actorService;

	/**
	 * List all actor.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos los actores", 
			notes = "Este end point sirve para mostrar todos los actores")

	@GetMapping("/actor")
	public List<Actor> listAllActor() throws NetflixException {
		return actorService.listAllActor();
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos el actor seleccionado", 
			notes = "Este end point sirve para obtener un actor pasandole como parámetro el actorId")

	@GetMapping("/actor/{actorId}")
	public Actor findById(@PathVariable(value = "actorId") Long id) throws NetflixException {
		return actorService.findById(id);
	}
	
	/**
	 * Adds the actor.
	 *
	 * @param actor the actor
	 * @return the response entity
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Añadimos un actor", 
			notes = "Este end point sirve para añadir un actor pasandole como parámetro el actor")
	
	@PostMapping("/addActor")
	public ResponseEntity<String> addActor(@RequestBody Actor actor) throws NetflixException {
		actorService.addActor(actor);
		return ResponseEntity.status(HttpStatus.OK).body("Se ha añadido el actor correctamente");
	}

	/**
	 * Update actor.
	 *
	 * @param actor the actor
	 * @param id the id
	 * @return the response entity
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Actualizamos el actor elegido", notes = "Este end point sirve para actualizar el actor elegido, para ello le pasamos como"
			+ "parámetro el actorId")

	@PostMapping("/actor/update/{actorId}/")
	public ResponseEntity<String> updateActor(@RequestBody Actor actor, @PathVariable(value = "actorId") Long id) throws NetflixException {
		actor.setId(id);
		actorService.updateActor(actor);
		return ResponseEntity.status(HttpStatus.OK).body("Se ha actualizado el actor correctamente");
	}

	/**
	 * Delete actor.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Borramos el actor elegido", notes = "Este end point sirve para borrar el actor elegido, para ello le pasamos como"
			+ "parámetro el actorId")

	@PostMapping("/actor/detete/{actorId}/")
	public ResponseEntity<String> deleteTvShow(@PathVariable(value = "actorId") Long id)
			throws NetflixException {
		Actor actor = actorService.findById(id);
		actorService.deleteActor(actor);
		return ResponseEntity.status(HttpStatus.OK).body("Se ha borrado la serie correctamente");
	}
}
