package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.demo.Dtos.Input.ProductInput;
import com.demo.Dtos.Input.SendMailInput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.models.Product;

@Service
public interface IProductService {
	List<ProductOutput> getListProductByClient();

	List<ProductOutput> findAllProduct();

	List<ProductOutput> getListProduct(String name);

	Product findById(int id);

	ProductOutput find(int id);

	boolean acceptProduct(int id);

	boolean cancelProduct(int id, SendMailInput sendMailInput);

	ProductOutput createProduct(ProductInput productInput);

	ProductOutput updateProduct(ProductInput productInput, int id);

	ProductOutput find2(int id);

}
