package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.exception.NotFoundException;
import com.netflix.rest.model.Chapter;
import com.netflix.rest.repository.ChapterRepository;
import com.netflix.rest.restModel.ChapterRestModel;
import com.netflix.rest.service.ChapterServiceI;
import com.netflix.rest.utils.constants.ExceptionConstants;

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

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Find by tv show and number.
	 *
	 * @param tvshowId     the tvshow id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<ChapterRestModel> findByTvShowAndNumber(long tvshowId, int seasonNumber) throws NetflixException {

		List<Chapter> chapter = chapterRepository.listTvShowAndNumber(tvshowId, seasonNumber);
		if (chapter.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER);
		}
		return chapter.stream().map(chapters -> modelMapper.map(chapter, ChapterRestModel.class))
				.collect(Collectors.toList());
	}

	/**
	 * Find by tv show and number and chapter number.
	 *
	 * @param tvshowId      the tvshow id
	 * @param seasonNumber  the season number
	 * @param chapterNumber the chapter number
	 * @return the chapter rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ChapterRestModel findByTvShowAndNumberAndChapterNumber(long tvshowId, int seasonNumber, int chapterNumber)
			throws NetflixException {
		Chapter chapter = chapterRepository
				.findChapterByTvShowAndNumberAndChapterNumber(tvshowId, seasonNumber, chapterNumber)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
		return modelMapper.map(chapter, ChapterRestModel.class);
	}

	/**
	 * Update chapter name.
	 *
	 * @param chapterId   the chapter id
	 * @param chapterName the chapter name
	 * @return the chapters rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ChapterRestModel updateChapterName(Long chapterId, String chapterName) throws NetflixException {

		Chapter chapter = chapterRepository.findById(chapterId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
		chapter.setName(chapterName);
		chapterRepository.save(chapter);
		return modelMapper.map(chapter, ChapterRestModel.class);
	}

}
