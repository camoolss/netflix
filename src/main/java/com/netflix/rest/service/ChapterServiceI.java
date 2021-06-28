package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.restModel.ChapterRestModel;

/**
 * The Interface ChapterServiceI.
 */
public interface ChapterServiceI {

	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshowId     the tvshow id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<ChapterRestModel> findByTvShowAndNumber(long tvshowId, int seasonNumber) throws NetflixException;

	/**
	 * Find by tv shows and number and chapter number.
	 *
	 * @param tvshowId      the tvshow id
	 * @param seasonNumber  the season number
	 * @param chapterNumber the chapter number
	 * @return the chapter rest model
	 * @throws NetflixException the netflix exception
	 */
	ChapterRestModel findByTvShowAndNumberAndChapterNumber(long tvshowId, int seasonNumber, int chapterNumber)
			throws NetflixException;

	/**
	 * Update chapter name.
	 *
	 * @param chapterId   the chapter id
	 * @param chapterName the chapter name
	 * @return the chapter rest model
	 * @throws NetflixException the netflix exception
	 */
	ChapterRestModel updateChapterName(Long chapterId, String chapterName) throws NetflixException;

}
