package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.response.NetflixResponse;
import com.netflix.rest.restModel.ActorRestModel;
import com.netflix.rest.service.ActorServiceI;
import com.netflix.rest.service.TvShowServiceI;
import com.netflix.rest.utils.constants.CommonConstants;
import com.netflix.rest.utils.constants.RestConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

/**
 * The Class ActorController.
 */
@RestController
@SwaggerDefinition
@RequestMapping(RestConstants.RESOURCE_ACTOR)
public class ActorController {

	/** The actor service. */
	@Autowired
	@Qualifier("ActorServiceImpl")
	private ActorServiceI actorService;

	@Autowired
	@Qualifier("TvShowServiceImpl")
	private TvShowServiceI tvShowService;

	/**
	 * List all actor.
	 *
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos los actores", 
			notes = "Este end point sirve para mostrar todos los actores")
	@GetMapping
	public NetflixResponse<List<ActorRestModel>> listAllActors() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.listAllActor());
	}

	/**
	 * List tv shows by id.
	 *
	 * @param actorId the actor id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Mostramos el actor elegido", 
			notes = "Este end point sirve para obtener un actor en concreto, le pasamos el parámetro del actor-id")

	@GetMapping(value = RestConstants.RESOURCE_ID)
	public NetflixResponse<ActorRestModel> listActorById(@PathVariable(value = "id") Long id)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.findById(id));
	}

	@ApiOperation(value = "Añadimos un actor", 
			notes = "Este end point sirve para añadir un actor pasandole como parámetro el actor")

	@PostMapping(value = RestConstants.RESOURCE_ADD)
	public NetflixResponse<ActorRestModel> addActor(@RequestBody ActorRestModel actor) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.CREATED),
				CommonConstants.SUCCESS, actorService.addActor(actor));
	}

	/**
	 * Update actor.
	 *
	 * @param actorId the actor id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Actualizamos el actor", 
			notes = "Este end point sirve para actualizar el actor por su Id")

	@PatchMapping(value = RestConstants.RESOURCE_ACTOR_UPDATE, produces = MediaType.APPLICATION_JSON_VALUE)

	public NetflixResponse<ActorRestModel> updateActor(@RequestBody ActorRestModel actor, Long actorId)
			throws NetflixException {

		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.updateActor(actor, actorId));
	}

	/**
	 * Delete actor by id.
	 *
	 * @param actorId the actor id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Eliminamos un actor", 
			notes = "Este end point sirve para eliminar un actor, para ello debemos pasarle como parámetro su actorId")

	@DeleteMapping(value = RestConstants.RESOURCE_DELETE + RestConstants.RESOURCE_ID)
	public NetflixResponse<String> deleteActorById(@PathVariable(value = "id") Long actorId) throws NetflixException {
		actorService.deleteByActorId(actorId);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK);
	}

}
