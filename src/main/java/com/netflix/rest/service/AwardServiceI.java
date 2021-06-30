package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Award;

/**
 * The Interface AwardServiceI.
 */
public interface AwardServiceI {
	

	/**
	 * List all award.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<Award> listAwardByTvShowId(Long tvShowId) throws NetflixException;

}
