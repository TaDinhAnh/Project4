package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.models.Category;
import com.demo.reponsitories.CategoryReponsitory;

import java.util.ArrayList;
import java.util.List;
import com.demo.Dtos.Input.CategoryInput;
import com.demo.Dtos.Output.CategoryOutput;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryReponsitory categoryReponsitory;

	@Override
	public boolean createCategory(CategoryInput categoryInput) {
		Category category = new Category();
		if (categoryInput != null && categoryInput.getPresentid() > 0) {
			Category categoryChild = findById(categoryInput.getPresentid());
			if (categoryChild == null)
				return false;
			category.setCategory(categoryChild);
		}
		category.setName(categoryInput.getName());
		return categoryReponsitory.save(category) != null;
	}

	@Override
	public boolean updateCategory(int id, CategoryInput categoryInput) {
		Category category = findById(id);
		if (category == null) {
			return false;
		}
		if (categoryInput != null && categoryInput.getPresentid() > 0) {
			Category categoryChild = findById(categoryInput.getPresentid());
			if (categoryChild == null )
				return false;
			category.setCategory(categoryChild);
		}else {
			category.setCategory(null);
		}	
		category.setName(categoryInput.getName());
		return categoryReponsitory.save(category) != null;
	}

	@Override
	public Category findById(int id) {
		try {
			return categoryReponsitory.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<CategoryOutput> getListCategory() {
		return categoryReponsitory.getListCategory();
	}

	@Override
	public List<CategoryOutput> findAllCategory() {
		List<Category> categories = categoryReponsitory.findAllCategory();
		if (categories == null)
			return null;
		List<CategoryOutput> categoryOutputs = new ArrayList<CategoryOutput>();
		for (Category item : categories) {
			CategoryOutput categoryOutput = new CategoryOutput();
			categoryOutput.setId(item.getId());
			categoryOutput.setName(item.getName());
			if (item.getCategory() != null) {
				categoryOutput.setPresentName(item.getCategory().getName());
				CategoryOutput present = new CategoryOutput();
				present.setId(item.getCategory().getId());
				present.setName(item.getCategory().getName());
				categoryOutput.setCategoryOutput(present);
			}
			categoryOutput.setIsDelete(item.getIsDelete());
			categoryOutputs.add(categoryOutput);
		}
		return categoryOutputs;
	}

	@Override
	public List<CategoryOutput> getCateNotDel() {
		return categoryReponsitory.getCateNotDel();
	}
}