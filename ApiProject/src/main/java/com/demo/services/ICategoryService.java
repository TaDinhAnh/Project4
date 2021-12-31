package com.demo.services;
import java.util.List;

import com.demo.Dtos.Input.CategoryInput;
import com.demo.Dtos.Output.CategoryOutput;
import com.demo.models.Category;


public interface ICategoryService {
	boolean createCategory(CategoryInput categoryInput);

	boolean updateCategory (int id,CategoryInput categoryInput);
	
	Category findById(int id);

	List<CategoryOutput> getListCategory();
}
