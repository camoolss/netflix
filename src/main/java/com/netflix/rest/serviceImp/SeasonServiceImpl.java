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

// TODO: Auto-generated Javadoc
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

	/** The tv show repository. */
	@Autowired
	@Qualifier("TvShowRepository")
	private TvShowRepository tvShowRepository;

	/**
	 * List all season.
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
	 * @param serieId the serie id
	 * @return the season
	 */
	@Override
	public Season findById(Long serieId) {
		return seasonRepository.findById(serieId).get();
	}

	/**
	 * Find by tv show.
	 *
	 * @param tvshow the tvshow
	 * @return the list
	 */
	@Override
	public List<Season> findByTvShow(TvShow tvshow) {
		return seasonRepository.findByTvShow(tvshow);
	}

	/**
	 * Find by tv show and number.
	 *
	 * @param tvshow       the tvshow
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@Override
	public List<Season> findByTvShowAndNumber(TvShow tvshow, int seasonNumber) {
		return seasonRepository.findByTvShowAndNumber(tvshow, seasonNumber);
	}

	/**
	 * Update season.
	 *
	 * @param id the id
	 * @param name the name
	 * @return the season
	 */
	@Override
	public Season updateSeason(Long id, String name) {
		Season season = seasonRepository.findById(id).get();
		season.setName(name);
		return seasonRepository.save(season);
	}
	
	/**
	 * Delete season.
	 *
	 * @param season the season
	 * @return the season
	 */
	@Override	
	public Season deleteSeason(Season season) {	
		seasonRepository.delete(season);
	 return season;
	}

}
