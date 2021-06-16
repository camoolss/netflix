package com.netflix.rest.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.model.Seasons;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.SeasonsRepository;
import com.netflix.rest.repository.TvShowRepository;
import com.netflix.rest.service.SeasonsServiceI;

/**
 * The Class SeasonsServiceImpl.
 */
@Service
@Qualifier("SeasonsServiceImpl")
public class SeasonsServiceImpl implements SeasonsServiceI {

	/** The seasons repository. */
	@Autowired
	@Qualifier("SeasonsRepository")
	private SeasonsRepository seasonsRepository;

	/** The tv shows repository. */
	@Autowired
	@Qualifier("TvShowsRepository")
	private TvShowRepository tvShowsRepository;

	/**
	 * List all seasons.
	 *
	 * @return the list
	 */
	@Override
	public List<Seasons> listAllSeasons() {
		return seasonsRepository.findAll();
	}

	/**
	 * Find by id.
	 *
	 * @param seriesId the series id
	 * @return the seasons
	 */
	@Override
	public Seasons findById(Long seriesId) {
		return seasonsRepository.findById(seriesId).get();
	}

	/**
	 * Find by tv shows.
	 *
	 * @param tvshow the tvshow
	 * @return the list
	 */
	@Override
	public List<Seasons> findByTvShows(TvShow tvshow) {
		return seasonsRepository.findByTvShows(tvshow);
	}

	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshow the tvshow
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@Override
	public List<Seasons> findByTvShowsAndNumber(TvShow tvshow, int seasonNumber) {
		return seasonsRepository.findByTvShowsAndNumber(tvshow, seasonNumber);
	}

}
