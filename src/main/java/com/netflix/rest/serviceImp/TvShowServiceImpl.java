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

	/** The tv show repository. */
	@Autowired
	@Qualifier("TvShowRepository")
	public TvShowRepository tvShowRepository;

	/** The category repository. */
	@Autowired
	@Qualifier("CategoryRepository")
	public CategoryRepository categoryRepository;

	/**
	 * List tv show by category.
	 *
	 * @param categoryId the category id
	 * @return the list
	 */
	@Override
	public List<TvShow> listTvShowByCategory(Long categoryId) {
		return tvShowRepository.findByCategory(categoryRepository.findById(categoryId).get());
	}

}
