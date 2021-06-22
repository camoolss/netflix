package com.netflix.rest.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Actor;
import com.netflix.rest.repository.ActorRepository;
import com.netflix.rest.service.ActorServiceI;

/**
 * The Class ActorServiceImpl.
 */
@Service
@Qualifier("ActorServiceImpl")
public class ActorServiceImpl implements ActorServiceI {

	
	/** The actor repository. */
	@Autowired
	@Qualifier("ActorRepository")
	private ActorRepository actorRepository;

	/**
	 * List all actor.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<Actor> listAllActor() throws NetflixException {
		return actorRepository.findAll();
	}

	/**
	 * Find by id.
	 *
	 * @param ActorId the actor id
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public Actor findById(Long ActorId) throws NetflixException {
		return actorRepository.findById(ActorId).get();
	}

	/**
	 * Adds the actor.
	 *
	 * @param id the id
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public Actor addActor(Actor actor) throws NetflixException {
		return actorRepository.save(actor);
	}

	/**
	 * Update actor.
	 *
	 * @param id the id
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public Actor updateActor(Actor actor) throws NetflixException {
		Actor aResult = null;
		if (actorRepository.findById(actor.getId()).isPresent()) 
			aResult = actorRepository.save(actor);
		return aResult;
	}

	/**
	 * Delete actor.
	 *
	 * @param actor the actor
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	@Override	
	public Actor deleteActor(Actor actor) {	
		actorRepository.delete(actor);
	 return actor;
	}

}
