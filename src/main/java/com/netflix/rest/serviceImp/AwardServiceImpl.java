package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.exception.NotFoundException;
import com.netflix.rest.model.Award;
import com.netflix.rest.repository.AwardRepository;
import com.netflix.rest.service.AwardServiceI;
import com.netflix.rest.utils.constants.ExceptionConstants;

/**
 * The Class AwardServiceImpl.
 */
@Service
@Qualifier("AwardServiceImpl")
public class AwardServiceImpl implements AwardServiceI {

	/** The award repository. */
	@Autowired
	@Qualifier("AwardRepository")
	private AwardRepository awardRepository;

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * List award by tv show id.
	 *
	 * @param tvShowId the tv show id
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<Award> listAwardByTvShowId(Long tvShowId) throws NetflixException {

		List<Award> award = awardRepository.findByTvShowId(tvShowId);
		if (award.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_AWARD);
		}
		return award.stream().map(awards -> modelMapper.map(awards, Award.class)).collect(Collectors.toList());
	}

}
