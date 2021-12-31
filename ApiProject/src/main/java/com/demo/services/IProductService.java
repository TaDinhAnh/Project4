package com.demo.services;

import java.util.List;

import com.demo.Dtos.Output.ProductOutput;
import com.demo.models.Product;

public interface IProductService {
	List<ProductOutput> getListProductByClient();

	List<ProductOutput> getListProduct(String name);

	Product findById(int id);
	
	boolean acceptProduct(int id);


}
