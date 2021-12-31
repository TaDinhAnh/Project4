package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.CategoryInput;
import com.demo.Dtos.Output.CategoryOutput;
import com.demo.models.Category;

import com.demo.reponsitories.ICategoryResponsitory;

;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryResponsitory categoryResponsitory;

	@Override
	public boolean createCategory(CategoryInput categoryInput) {
		Category category = new Category();
		category.setName(categoryInput.getName());
		category.setCategory(findById(categoryInput.getPresentid()));
		return categoryResponsitory.save(category) != null;
	}

	@Override
	public boolean updateCategory(int id, CategoryInput categoryInput) {
		Category category = findById(id);
		if(category == null) {
			return false;
		}
		category.setName(categoryInput.getName());
		category.setCategory(findById(categoryInput.getPresentid()));
		return categoryResponsitory.save(category) != null;
	}

	@Override
	public Category findById(int id) {
		try {
			return categoryResponsitory.findById(id).get();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<CategoryOutput> getListCategory() {
		return categoryResponsitory.getListCategory();
	}

}
