package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.ProductInput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.models.Account;
import com.demo.models.Category;
import com.demo.models.Product;
import com.demo.reponsitories.ProductReponsitory;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductReponsitory productReponsitory;
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private ICategoryService categoryService;
	@Override
	public Product findById(int id) {
		try {
			return productReponsitory.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public ProductOutput createProduct(ProductInput productInput) {
		Product product = new Product();
		Account account = accountService.findById(productInput.getVendorId());
		Category category = categoryService.findById(productInput.getCategoryId());
		if(category == null || account == null)
			return null;
		product.setCategory(category);
		product.setDescription(productInput.getDescription());
		product.setImage(productInput.getImage());
		product.setName(productInput.getName());
		product.setPriceMin(productInput.getPriceMin());
		product.setVendorId(productInput.getVendorId());
		product = productReponsitory.save(product);
		return new ProductOutput(product.getId(), product.getCategory().getName(), 
				product.getName(), product.getPriceMin(), product.getImage(), product.getDescription(),
				product.getStatus(), product.getIsAccept());
	}
	@Override
	public ProductOutput updateProduct(ProductInput productInput, int id) {
		Product product = findById(id);
		Account account = accountService.findById(productInput.getVendorId());
		Category category = categoryService.findById(productInput.getCategoryId());
		if(category == null || account == null || product == null)
			return null;
		product.setCategory(category);
		product.setDescription(productInput.getDescription());
		product.setImage(productInput.getImage());
		product.setName(productInput.getName());
		product.setPriceMin(productInput.getPriceMin());
		product.setVendorId(productInput.getVendorId());
		product = productReponsitory.save(product);
		return new ProductOutput(product.getId(), product.getCategory().getName(), 
				product.getName(), product.getPriceMin(), product.getImage(), product.getDescription(),
				product.getStatus(), product.getIsAccept());
	}

}
