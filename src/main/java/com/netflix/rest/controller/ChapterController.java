package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.model.Chapters;
import com.netflix.rest.service.ChaptersServiceI;

/**
 * The Class ChapterController.
 */
@RestController
public class ChapterController {

	/** The chapter service. */
	@Autowired
	@Qualifier("ChaptersServiceImpl")

	private ChaptersServiceI chapterService;

	/**
	 * List tv shows and number.
	 *
	 * @param seriesId the series id
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@GetMapping("/series/{seriesId}/seasons/{seasonNumber}/chapters")
	public List<Chapters> listTvShowsAndNumber(@PathVariable long seriesId, @PathVariable int seasonNumber) {
		return chapterService.findByTvShowsAndNumber(seriesId, seasonNumber);
	}

	/**
	 * List tv shows and number and chapter number.
	 *
	 * @param seriesId the series id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapters
	 */
	@GetMapping("/series/{seriesId}/seasons/{seasonNumber}/chapters/{chapterNumber}")
	public Chapters listTvShowsAndNumberAndChapterNumber(@PathVariable long seriesId, @PathVariable int seasonNumber,
			@PathVariable int chapterNumber) {
		return chapterService.findByTvShowsAndNumberAndChapterNumber(seriesId, seasonNumber, chapterNumber);
	}

}
