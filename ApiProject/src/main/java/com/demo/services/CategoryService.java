package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Category;
import com.demo.reponsitories.CategoryReponsitory;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	private CategoryReponsitory categoryReponsitory;

	@Override
	public Category findById(int id) {
		try {
			return categoryReponsitory.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

}
