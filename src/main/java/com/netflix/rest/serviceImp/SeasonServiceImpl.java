package com.netflix.rest.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.model.Season;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.SeasonRepository;
import com.netflix.rest.repository.TvShowRepository;
import com.netflix.rest.service.SeasonServiceI;

/**
 * The Class SeasonServiceImpl.
 */
@Service
@Qualifier("SeasonServiceImpl")
public class SeasonServiceImpl implements SeasonServiceI {

	/** The seasons repository. */
	@Autowired
	@Qualifier("SeasonRepository")
	private SeasonRepository seasonRepository;

	/** The tv shows repository. */
	@Autowired
	@Qualifier("TvShowRepository")
	private TvShowRepository tvShowRepository;

	/**
	 * List all seasons.
	 *
	 * @return the list
	 */
	@Override
	public List<Season> listAllSeason() {
		return seasonRepository.findAll();
	}

	/**
	 * Find by id.
	 *
	 * @param serieId the series id
	 * @return the seasons
	 */
	@Override
	public Season findById(Long serieId) {
		return seasonRepository.findById(serieId).get();
	}

	/**
	 * Find by tv shows.
	 *
	 * @param tvshow the tvshow
	 * @return the list
	 */
	@Override
	public List<Season> findByTvShow(TvShow tvshow) {
		return seasonRepository.findByTvShow(tvshow);
	}

	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshow the tvshow
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@Override
	public List<Season> findByTvShowAndNumber(TvShow tvshow, int seasonNumber) {
		return seasonRepository.findByTvShowAndNumber(tvshow, seasonNumber);
	}

}
