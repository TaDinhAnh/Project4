package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Product;
import com.demo.reponsitories.ProductReponsitory;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductReponsitory productReponsitory;
	@Override
	public Product findById(int id) {
		try {
			return productReponsitory.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

}
