package com.demo.services;

import com.demo.models.Category;
import java.util.List;
import com.demo.Dtos.Input.CategoryInput;
import com.demo.Dtos.Output.CategoryOutput;

public interface ICategoryService {
	boolean createCategory(CategoryInput categoryInput);

	boolean updateCategory(int id, CategoryInput categoryInput);

	Category findById(int id);

	List<CategoryOutput> getListCategory();

}
