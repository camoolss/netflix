package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.exception.NotFoundException;
import com.netflix.rest.model.Season;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.SeasonRepository;
import com.netflix.rest.restModel.SeasonRestModel;
import com.netflix.rest.service.SeasonServiceI;
import com.netflix.rest.utils.constants.ExceptionConstants;


/**
 * The Class SeasonServiceImpl.
 */
@Service
@Qualifier("SeasonServiceImpl")
public class SeasonServiceImpl implements SeasonServiceI {

	/** The season repository. */
	@Autowired
	@Qualifier("SeasonRepository")
	private SeasonRepository seasonRepository;

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * List all season.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<SeasonRestModel> listAllSeason() throws NetflixException {

		List<Season> season = seasonRepository.findAll();

		if (season.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON);
		}
		return season.stream().map(seasons -> modelMapper.map(season, SeasonRestModel.class))
				.collect(Collectors.toList());
	}

	
	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the season rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public SeasonRestModel findById(Long tvShowId) throws NetflixException {

		Season season = seasonRepository.findById(tvShowId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON));
		return modelMapper.map(season, SeasonRestModel.class);
	}

	/**
	 * Find by tv show.
	 *
	 * @param tvshow the tvshow
	 * @return the list
	 * @throws NotFoundException the not found exception
	 */
	@Override
	public List<SeasonRestModel> findByTvShow(TvShow tvshow) throws NotFoundException {

		List<Season> season = seasonRepository.findByTvShow(tvshow);

		if (season.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON);
		}
		return season.stream().map(seasons -> modelMapper.map(season, SeasonRestModel.class))
				.collect(Collectors.toList());
	}

	/**
	 * Find by tv show id and number.
	 *
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the season rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public SeasonRestModel findByTvShowIdAndNumber(Long tvShowId, int seasonNumber) throws NetflixException {

		Season season = seasonRepository.findByTvShowIdAndNumber(tvShowId, seasonNumber);
		return modelMapper.map(season, SeasonRestModel.class);

	}

}
