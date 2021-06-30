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
import com.netflix.rest.service.ChapterServiceI;
import com.netflix.rest.service.TvShowServiceI;
import com.netflix.rest.utils.constants.ExceptionConstants;

/**
 * The Class ActorServiceImpl.
 */
@Service
@Qualifier("ActorServiceImpl")
public class ActorServiceImpl implements ActorServiceI {

	/** The actors repository. */
	@Autowired
	@Qualifier("ActorRepository")
	private ActorRepository actorRepository;

	/** The tv show service. */
	@Autowired
	@Qualifier("TvShowServiceImpl")
	private TvShowServiceI tvShowService;
	
	@Autowired
	@Qualifier("ChapterServiceImpl")
	private ChapterServiceI chapterService;

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
		return actor.stream().map(actors -> modelMapper.map(actors, ActorRestModel.class)).collect(Collectors.toList());
	}

	/**
	 * Find by id.
	 *
	 * @param actorId the actor id
	 * @return the actor rest model
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
	 * @param actors the actors
	 * @return the actor rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ActorRestModel addActor(ActorRestModel actors) throws NetflixException {
		Actor actor = modelMapper.map(actors, Actor.class);
		actorRepository.save(actor);
		return actors;
	}

	/**
	 * Update actor.
	 *
	 * @param actorRestModel the actor rest model
	 * @param actorId the actor id
	 * @return the actor rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ActorRestModel updateActor(ActorRestModel actorRestModel, Long actorId) throws NetflixException {

		Actor actor = actorRepository.findById(actorId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR));
		actor.setName(actorRestModel.getName());
		actor.setId(actorRestModel.getActorId());
		actor.setYear(actorRestModel.getYear());
		actorRepository.save(actor);
		return actorRestModel;
	}

	/**
	 * Delete actor by id.
	 *
	 * @param actorId the actor id
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public void deleteByActorId(Long actorId) throws NetflixException {

		actorRepository.deleteById(actorRepository.findById(actorId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR)).getId());

	}
	
}
