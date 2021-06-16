package com.netflix.rest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.rest.model.Seasons;
import com.netflix.rest.model.TvShow;

/**
 * The Interface SeasonsRepository.
 */
@Repository
@Qualifier("SeasonsRepository")
public interface SeasonsRepository extends JpaRepository<Seasons, Long> {

	/**
	 * Find by tv shows.
	 *
	 * @param tvShow the tv show
	 * @return the list
	 */
	List<Seasons> findByTvShows(TvShow tvShow);

	/**
	 * Find by tv shows and number.
	 *
	 * @param tvShow the tv show
	 * @param seasonNumber the season number
	 * @return the list
	 */
	List<Seasons> findByTvShowsAndNumber(TvShow tvShow, int seasonNumber);
}
