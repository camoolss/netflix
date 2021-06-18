package com.netflix.rest.serviceImp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Category;
import com.netflix.rest.repository.CategoryRepository;
import com.netflix.rest.service.CategoryServiceI;

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

	/**
	 * List all category.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<Category> listAllCategory() throws NetflixException {
		return categoryRepository.findAll();
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
		return new HashSet<>(categoryRepository.findAllById(listCategoryId));
	}
}