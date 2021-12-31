package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Output.ProductOutput;
import com.demo.models.Product;
import com.demo.reponsitories.IProductResponsitory;

@Service
public class ProductService implements IProductService {
	@Autowired
	private IProductResponsitory productResponsitory;

	@Override
	public List<ProductOutput> getListProductByClient() {
		return productResponsitory.getListProductByClient();
	}

	@Override
	public List<ProductOutput> getListProduct(String name) {
		return productResponsitory.getListProduct(name);
	}

	@Override
	public Product findById(int id) {
		try {
			return productResponsitory.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean acceptProduct(int id) {
		Product product = findById(id);
		product.setIsAccept(true);
		return productResponsitory.save(product) != null;
	}

}
