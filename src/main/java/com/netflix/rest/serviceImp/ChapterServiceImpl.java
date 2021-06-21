package com.netflix.rest.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Chapter;
import com.netflix.rest.repository.ChapterRepository;
import com.netflix.rest.service.ChapterServiceI;

/**
 * The Class ChapterServiceImpl.
 */
@Service
@Qualifier("ChapterServiceImpl")
public class ChapterServiceImpl implements ChapterServiceI {

	/** The chapters repository. */
	@Autowired
	@Qualifier("ChapterRepository")
	private ChapterRepository chapterRepository;

	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshowId the tvshow id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<Chapter> findByTvShowAndNumber(long tvshowId, int seasonNumber) throws NetflixException {
		return chapterRepository.listTvShowAndNumber(tvshowId, seasonNumber);
	}

	/**
	 * Find by tv shows and number and chapter number.
	 *
	 * @param tvshowId the tvshow id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapter
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public Chapter findByTvShowAndNumberAndChapterNumber(long tvshowId, int seasonNumber, int chapterNumber) throws NetflixException{
		return chapterRepository.findChapterByTvShowAndNumberAndChapterNumber(tvshowId, seasonNumber, chapterNumber);
	}
	
	/**
	 * Delete chapter.
	 *
	 * @param chapter the chapter
	 * @return the chapter
	 */
//	@Override	
//	public Chapter deleteChapter(Chapter chapter) {	
//		chapterRepository.delete(chapter);
//	 return chapter;
//	}

}
