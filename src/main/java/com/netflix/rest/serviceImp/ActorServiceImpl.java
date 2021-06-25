package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.exception.NotFoundException;
import com.netflix.rest.model.Actor;
import com.netflix.rest.repository.ActorRepository;
import com.netflix.rest.restModel.ActorRestModel;
import com.netflix.rest.service.ActorServiceI;
import com.netflix.rest.utils.constants.ExceptionConstants;

// TODO: Auto-generated Javadoc
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

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * List all actor.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<ActorRestModel> listAllActor() throws NetflixException {

		List<Actor> actor = actorRepository.findAll();
		if (actor.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR);
		}

		return actor.stream().map(actors -> modelMapper.map(actor, ActorRestModel.class)).collect(Collectors.toList());
	}

	/**
	 * Find by id.
	 *
	 * @param actorId the actor id
	 * @return the sets the
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ActorRestModel findById(Long actorId) throws NetflixException {

		Actor actor = actorRepository.findById(actorId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR));
		return modelMapper.map(actor, ActorRestModel.class);
	}
	
	/**
	 * Adds the actor.
	 *
	 * @param actor the actor
	 * @return the actor
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ActorRestModel addActor(Actor actor) throws NetflixException {
		actorRepository.save(actor);
		return modelMapper.map(actor, ActorRestModel.class);
	}

	/**
	 * Update actor.
	 *
	 * @param actorId the actor id
	 * @param actor the actor
	 * @return the actor rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ActorRestModel updateActor(Actor actor, Long actorId) throws NetflixException {

		Actor actors = actorRepository.findById(actorId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR));
		String actorName = actor.getName();
		actors.setName(actorName);
		int actorYear = actor.getYear();
		actors.setYear(actorYear);
		actorRepository.save(actors);
		return modelMapper.map(actors, ActorRestModel.class);
	}

	/**
	 * Delete actor by id.
	 *
	 * @param actorId the actor id
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public void deleteActorById(Long actorId) throws NetflixException {

		actorRepository.deleteById(actorRepository.findById(actorId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR)).getId());
	}
}
