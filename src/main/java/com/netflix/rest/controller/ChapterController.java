package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.model.Chapter;
import com.netflix.rest.service.ChapterServiceI;

/**
 * The Class ChapterController.
 */
@RestController
public class ChapterController {

	/** The chapter service. */
	@Autowired
	@Qualifier("ChapterServiceImpl")

	private ChapterServiceI chapterService;

	/**
	 * List tv shows and number.
	 *
	 * @param serieId the series id
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@GetMapping("/serie/{serieId}/season/{seasonNumber}/chapter")
	public List<Chapter> listTvShowAndNumber(@PathVariable long serieId, @PathVariable int seasonNumber) {
		return chapterService.findByTvShowAndNumber(serieId, seasonNumber);
	}

	/**
	 * List tv shows and number and chapter number.
	 *
	 * @param serieId the series id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapters
	 */
	@GetMapping("/serie/{serieId}/season/{seasonNumber}/chapter/{chapterNumber}")
	public Chapter listTvShowAndNumberAndChapterNumber(@PathVariable long serieId, @PathVariable int seasonNumber,
			@PathVariable int chapterNumber) {
		return chapterService.findByTvShowAndNumberAndChapterNumber(serieId, seasonNumber, chapterNumber);
	}

}
