package com.demo.services;

import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.ProductInput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.models.Product;

@Service
public interface IProductService {
	Product findById(int id);
	
	ProductOutput createProduct(ProductInput productInput);
	
	ProductOutput updateProduct(ProductInput productInput, int id);
}
