package com.netflix.rest.serviceImp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.model.Category;
import com.netflix.rest.repository.CategoryRepository;
import com.netflix.rest.service.CategoryServiceI;

/**
 * The Class CategoryServiceImpl.
 */

@Service
@Qualifier("CategoriesServiceImpl")
public class CategoryServiceImpl implements CategoryServiceI {

	/** The categories repository. */
	@Autowired
	@Qualifier("CategoriesRepository")
	private CategoryRepository categoryRepository;

	/**
	 * List all categories.
	 *
	 * @return the list
	 */
	@Override
	public List<Category> listAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Set<Category> listCategoriesByIds(Set<Long> listCategoriesIds) {
		return new HashSet<>(categoryRepository.findAllById(listCategoriesIds));
	}
}