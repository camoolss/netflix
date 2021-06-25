package com.netflix.rest.serviceImp;

import java.util.HashSet;
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
import com.netflix.rest.repository.CategoryRepository;
import com.netflix.rest.restModel.CategoryRestModel;
import com.netflix.rest.service.CategoryServiceI;
import com.netflix.rest.utils.constants.ExceptionConstants;

/**
 * The Class CategoryServiceImpl.
 */
@Service
@Qualifier("CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryServiceI {

	/** The category repository. */
	@Autowired
	@Qualifier("CategoryRepository")
	private CategoryRepository categoryRepository;

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * List all category.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<CategoryRestModel> listAllCategory() throws NetflixException {

		List<Category> category = categoryRepository.findAll();
		if (category.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CATEGORY);
		}

		return category.stream().map(categories -> modelMapper.map(category, CategoryRestModel.class))
				.collect(Collectors.toList());
	}

	/**
	 * List category by id.
	 *
	 * @param listCategoryId the list category id
	 * @return the sets the
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public Set<Category> listCategoryById(Set<Long> listCategoryId) throws NetflixException {

		Set<Category> category = new HashSet<>(categoryRepository.findAllById(listCategoryId));

		if (category.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CATEGORY);
		}
		return category;
	}
}
