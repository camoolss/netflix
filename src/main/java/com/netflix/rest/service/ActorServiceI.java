package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Actor;
import com.netflix.rest.restModel.ActorRestModel;

/**
 * The Interface ActorServiceI.
 */
public interface ActorServiceI {

	/**
	 * List all actor.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<ActorRestModel> listAllActor() throws NetflixException;

	/**
	 * Find by id.
	 *
	 * @param actorId the actor id
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	ActorRestModel findById(Long actorId) throws NetflixException;
	
	/**
	 * Adds the actor.
	 *
	 * @param actor the actor
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	ActorRestModel addActor(Actor actor) throws NetflixException;

	/**
	 * Update actor.
	 *
	 * @param actorId the actor id
	 * @return the actor rest model
	 * @throws NetflixException the netflix exception
	 */
	ActorRestModel updateActor(Actor actor, Long actorId) throws NetflixException;
	
	/**
	 * Delete actor by id.
	 *
	 * @param actorId the actor id
	 * @throws NetflixException the netflix exception
	 */
	void deleteActorById(Long actorId) throws NetflixException;

}
