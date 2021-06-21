package com.netflix.rest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflix.rest.model.Chapter;

/**
 * The Interface ChapterRepository.
 */
@Repository
@Qualifier("ChapterRepository")
public interface ChapterRepository extends JpaRepository<Chapter, Long> {

	/**
	 * List tv show and number.
	 *
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@Query(value = "SELECT c.* FROM CHAPTERS c " + " LEFT JOIN SEASONS a ON c.season_id=a.id "
			+ " LEFT JOIN TV_SHOWS b ON a.tv_show_id=b.id " + " WHERE b.id=?1 and a.number=?2 ", nativeQuery = true)
	List<Chapter> listTvShowAndNumber(long tvShowId, int seasonNumber);
	
	/**
	 * Find chapter by tv show and number and chapter number.
	 *
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapter
	 */
	@Query(value = "SELECT c.* FROM CHAPTERS c " + " LEFT JOIN SEASONS a ON c.season_id=a.id "
			+ " LEFT JOIN TV_SHOWS b ON a.tv_show_id=b.id " + " WHERE b.id=?1 and a.number=?2 "
			+ " and c.number=?3", nativeQuery = true)
	Chapter findChapterByTvShowAndNumberAndChapterNumber(long tvShowId, int seasonNumber, int chapterNumber);
}
