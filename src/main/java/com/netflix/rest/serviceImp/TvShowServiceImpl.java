package com.netflix.rest.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.CategoryRepository;
import com.netflix.rest.repository.TvShowRepository;
import com.netflix.rest.service.TvShowServiceI;

/**
 * The Class TvShowServiceImpl.
 */
@Service
@Qualifier("TvShowServiceImpl")
public class TvShowServiceImpl implements TvShowServiceI {

	/** The tv shows repository. */
	@Autowired
	@Qualifier("TvShowRepository")
	private TvShowRepository tvShowRepository;

	/** The category repository. */
	@Autowired
	@Qualifier("CategoryRepository")
	private CategoryRepository categoryRepository;

	/**
	 * Find by category id.
	 *
	 * @param categoryId the category id
	 * @return the list
	 */
	@Override
	public List<TvShow> listTvShowByCategory(Long categoryId) {
		return tvShowRepository.findByCategory(categoryRepository.findById(categoryId).get());
	}

	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 */
	@Override
	public TvShow findById(Long tvShowId) {
		return tvShowRepository.findById(tvShowId).get();
	}

	/**
	 * Update tv shows.
	 *
	 * @param tvShow the tv show
	 * @return the tv show
	 */
	@Override
	public TvShow updateTvShow(TvShow tvShow) {
		return tvShowRepository.save(tvShow);
	}

}