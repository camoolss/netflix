package com.netflix.rest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflix.rest.model.TvShow;

/**
 * The Interface TvShowRepository.
 */
@Repository
@Qualifier("TvShowRepository")
public interface TvShowRepository extends JpaRepository<TvShow, Long> {

	/**
	 * Find by category id.
	 *
	 * @param categoryId the category id
	 * @return the list
	 */
	@Query(value = "SELECT * FROM TV_SHOWS WHERE TV_SHOWS.CATEGORY_ID =?1", nativeQuery = true)
	public List<TvShow> findByCategoryId(Long categoryId);

	@Query(value = "SELECT * FROM TV_SHOWS LEFT JOIN ACTORS_TVSHOWS ON"
			+ " TV_SHOWS.ID = ACTORS_TVSHOWS.TVSHOW_ID WHERE ACTORS_TVSHOWS.ACTOR_ID =?1", nativeQuery = true)
	List<TvShow> listTvShowByActorId(long actorId);
	
	@Query(value = "SELECT TV_SHOWS.ID FROM TV_SHOWS LEFT JOIN ACTORS_TVSHOWS ON"
			+ " TV_SHOWS.ID = ACTORS_TVSHOWS.TVSHOW_ID WHERE ACTORS_TVSHOWS.ACTOR_ID =?1", nativeQuery = true)
	List<Long> listTvShowIdByActorId(long actorId);
	
}