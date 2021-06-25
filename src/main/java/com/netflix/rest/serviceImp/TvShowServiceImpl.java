package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.exception.NotFoundException;
import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.TvShowRepository;
import com.netflix.rest.restModel.TvShowRestModel;
import com.netflix.rest.service.CategoryServiceI;
import com.netflix.rest.service.TvShowServiceI;
import com.netflix.rest.utils.constants.ExceptionConstants;

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

	/** The categories repository. */
	@Autowired
	@Qualifier("CategoryServiceImpl")
	private CategoryServiceI categoryService;

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Find by category id.
	 *
	 * @param categoryId the category id
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<TvShowRestModel> findByCategoryId(Long categoryId) throws NetflixException {

		List<TvShow> tvShow = tvShowRepository.findByCategoryId(categoryId);
		if (tvShow.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW);
		}
		return tvShow.stream().map(tvShows -> modelMapper.map(tvShow, TvShowRestModel.class))
				.collect(Collectors.toList());
	}

	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv show rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public TvShowRestModel findById(Long tvShowId) throws NetflixException {

		TvShow tvShow = tvShowRepository.findById(tvShowId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW));
		return modelMapper.map(tvShow, TvShowRestModel.class);
	}

	/**
	 * Adds the category.
	 *
	 * @param tvShowId the tv show id
	 * @param listCategory the list category
	 * @return the tv show rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public TvShowRestModel addCategory(Long tvShowId, Set<Long> listCategory) throws NetflixException {

		Set<Category> category = categoryService.listCategoryById(listCategory);
		TvShow tvShow = tvShowRepository.findById(tvShowId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW));
		tvShow.getCategory().addAll(category);
		tvShowRepository.save(tvShow);
		return modelMapper.map(tvShow, TvShowRestModel.class);
	}

	/**
	 * Update tv shows.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv show rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public TvShowRestModel updateTvShow(Long tvShowId) throws NetflixException {

		TvShow tvShow = tvShowRepository.findById(tvShowId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW));
		tvShowRepository.save(tvShow);
		return modelMapper.map(tvShow, TvShowRestModel.class);
	}

	/**
	 * Update tv show name.
	 *
	 * @param tvShowId the tv show id
	 * @param tvShowName the tv show name
	 * @return the tv show rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public TvShowRestModel updateTvShowName(Long tvShowId, String tvShowName) throws NetflixException {

		TvShow tvShow = tvShowRepository.findById(tvShowId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW));
		tvShow.setName(tvShowName);
		tvShowRepository.save(tvShow);
		return modelMapper.map(tvShow, TvShowRestModel.class);
	}
	
	/**
	 * Delete by id.
	 *
	 * @param tvShowId the tv show id
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public void deleteByTvShowId(Long tvShowId) throws NetflixException {
		
		tvShowRepository.deleteById(tvShowRepository.findById(tvShowId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW)).getId());
	}

}
