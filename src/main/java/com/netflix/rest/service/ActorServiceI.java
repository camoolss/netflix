package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.restModel.ActorRestModel;

/**
 * The Interface ActorServiceI.
 */
public interface ActorServiceI {

	/**
	 * List all actors.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<ActorRestModel> listAllActor() throws NetflixException;

	/**
	 * Find by id.
	 *
	 * @param actorId the actor id
	 * @return the actor rest model
	 * @throws NetflixException the netflix exception
	 */
	ActorRestModel findById(Long id) throws NetflixException;

	/**
	 * Adds the actor.
	 *
	 * @param actor the actor
	 * @return the actor rest model
	 * @throws NetflixException the netflix exception
	 */
	ActorRestModel addActor(ActorRestModel actor) throws NetflixException;

	/**
	 * Update actor.
	 *
	 * @param actor   the actor
	 * @param actorId the actor id
	 * @return the actor rest model
	 * @throws NetflixException the netflix exception
	 */
	ActorRestModel updateActor(ActorRestModel actor, Long actorId) throws NetflixException;

	/**
	 * Delete by actor id.
	 *
	 * @param actorId the actor id
	 * @throws NetflixException the netflix exception
	 */
	void deleteByActorId(Long actorId) throws NetflixException;
	
	
}
