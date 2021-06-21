package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Chapter;

/**
 * The Interface ChapterServiceI.
 */
public interface ChapterServiceI {

	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshowId the tvshow id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<Chapter> findByTvShowAndNumber(long tvshowId, int seasonNumber) throws NetflixException;
	
	/**
	 * Find by tv shows and number and chapter number.
	 *
	 * @param tvshowId the tvshow id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapter
	 * @throws NetflixException the netflix exception
	 */
	Chapter findByTvShowAndNumberAndChapterNumber(long tvshowId, int seasonNumber, int chapterNumber) throws NetflixException;
	
}
