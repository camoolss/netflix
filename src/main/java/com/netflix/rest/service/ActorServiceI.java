package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Actor;

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
	List<Actor> listAllActor() throws NetflixException;

	/**
	 * Find by id.
	 *
	 * @param ActorId the actor id
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	Actor findById(Long ActorId) throws NetflixException;

	/**
	 * Adds the actor.
	 *
	 * @param actor the actor
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	Actor addActor(Actor actor) throws NetflixException;

	/**
	 * Update actor.
	 *
	 * @param id the id
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	Actor updateActor(Actor actor) throws NetflixException;

	/**
	 * Delete actor.
	 *
	 * @param actor the actor
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	Actor deleteActor(Actor actor) throws NetflixException;

}
