package com.netflix.rest.serviceImp;

import java.util.List;

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
	public CategoryRepository categoryRepository;

	/**
	 * List all categories.
	 *
	 * @return the list
	 */
	@Override
	public List<Category> listAllCategories() {
		return this.categoryRepository.findAll();
	}

}
