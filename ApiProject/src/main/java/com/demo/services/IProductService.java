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

	boolean acceptProduct(int id);

	ProductOutput createProduct(ProductInput productInput);

	ProductOutput updateProduct(ProductInput productInput, int id);

	ProductOutput find(int id);

	List<ProductOutput> getProductByIdCategory(int categoryId);

	List<ProductOutput> getListLimit();

	List<ProductOutput> getListProductAccept(int vendorId);

	List<ProductOutput> getListProductUnsold(int vendorId);

	List<ProductOutput> getListProductSold(int vendorId);

	List<ProductOutput> getListProductNotAccept(int vendorId);

	boolean cancelProduct(int id, SendMailInput sendMailInput);

	ProductOutput find2(int id);
	
	ProductOutput findByVendorId(int productId , int vendorId);


}
