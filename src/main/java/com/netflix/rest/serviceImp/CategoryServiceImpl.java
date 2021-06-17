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
	 */
	@Override
	public List<Category> listAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Set<Category> listCategoryById(Set<Long> listCategoryId) {
		return new HashSet<>(categoryRepository.findAllById(listCategoryId));
	}
}