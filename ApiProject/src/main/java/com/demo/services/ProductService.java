package com.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.Dtos.Input.ProductInput;
import com.demo.Dtos.Input.SendMailInput;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.Dtos.Output.OrdersOutput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.common.EProduct;
import com.demo.common.MailHelper;
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
	private IOrdersService ordersService;

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
	public List<ProductOutput> getListProductByClient() {
		return productReponsitory.getListProductByClient();
	}

	@Override
	public List<ProductOutput> getListProduct(String name) {
		return productReponsitory.getListProduct(name);
	}

	@Override
	public ProductOutput createProduct(ProductInput productInput) {
		Product product = new Product();
		Account account = accountService.findById(productInput.getVendorId());
		Category category = categoryService.findById(productInput.getCategoryId());
		if (category == null || account == null)
			return null;
		product.setCategory(category);
		product.setDescription(productInput.getDescription());
		product.setImage(productInput.getImage());
		product.setName(productInput.getName());
		product.setPriceMin(productInput.getPriceMin());
		product.setVendorId(productInput.getVendorId());
		product.setIsDelete(false);
		product.setStatus(EProduct.unsold);
		product = productReponsitory.save(product);
		return new ProductOutput(product.getId(), product.getCategory().getName(), product.getName(),
				product.getPriceMin(), product.getImage(), product.getDescription(), product.getStatus(),
				product.getIsAccept());
	}

	@Override
	public Boolean updateProduct(ProductInput productInput, int id) {
		Product product = findById(id);
		Category category = categoryService.findById(productInput.getCategoryId());
		if (category == null ||product == null)
			return false;
		product.setCategory(category);
		product.setDescription(productInput.getDescription());
		product.setName(productInput.getName());
		product.setPriceMin(productInput.getPriceMin());
		return productReponsitory.save(product) != null;
	}

	@Override
	public boolean acceptProduct(int id) {
		Product product = findById(id);
		if (product == null)
			return false;
		product.setIsAccept(true);
		return productReponsitory.save(product) != null;
	}

	@Override
	public List<ProductOutput> getProductByIdCategory(int categoryId) {
		return productReponsitory.getProductByIdCategory(categoryId);
	}

	@Override
	public List<ProductOutput> getListLimit() {
		List<Product> products = productReponsitory.getListLimit();
		List<ProductOutput> outputs = new ArrayList<ProductOutput>();
		for (Product product : products) {
			ProductOutput productOutput = new ProductOutput();
			productOutput.setCategory(product.getCategory().getName());
			productOutput.setDescription(product.getDescription());
			productOutput.setId(product.getId());
			productOutput.setImage(product.getImage());
			productOutput.setName(product.getName());
			productOutput.setPriceMin(product.getPriceMin());
			outputs.add(productOutput);
		}
		return outputs;
	}

	@Override
	public List<ProductOutput> getListProductAccept(int vendorId) {
		return productReponsitory.getListProductAccept(vendorId);
	}

	@Override
	public List<ProductOutput> getListProductUnsold(int vendorId) {
		return productReponsitory.getListProductUnsold(vendorId);
	}

	@Override
	public List<ProductOutput> getListProductSold(int vendorId) {
		return productReponsitory.getListProductSold(vendorId);
	}

	public List<ProductOutput> findAllProduct() {
		return productReponsitory.findAllProduct();
	}

	@Override
	public ProductOutput find2(int id) {
		ProductOutput productOutput = productReponsitory.find2(id);
		if (productOutput == null) {
			return null;
		}
		AccountOutput account = accountService.find(productOutput.getVendorId());
		OrdersOutput ordersOutput = ordersService.find(id);
		productOutput.setOrders(ordersOutput);
		productOutput.setVendor(account);
		return productOutput;
	}

	@Override
	public boolean cancelProduct(int id, SendMailInput sendMailInput) {
		Product product = findById(id);
		if (product == null)
			return false;
		if (!MailHelper.sendMail(sendMailInput.getToEmail(), sendMailInput.getContent(), sendMailInput.getSubject()))
			return false;
		product.setIsDelete(true);
		return productReponsitory.save(product) == null;
	}

	@Override
	public ProductOutput find(int id) {
		return productReponsitory.find(id);
	}

	@Override
	public List<ProductOutput> getListProductNotAccept(int vendorId) {
		return productReponsitory.getListProductNotAccept(vendorId);
	}

	@Override
	public ProductOutput findByVendorId(int productId, int vendorId) {
		return productReponsitory.findByVendorId(productId, vendorId);
	}

	@Override
	public Boolean updateImg(int id, String img) {
		Product product = findById(id);
		if (product == null) {
			return false;
		}
		product.setImage(img);
		return productReponsitory.save(product) != null;
	}

	@Override
	public List<ProductOutput> getListMinPrice(Double priceMin) {
		return productReponsitory.getListMinPrice(priceMin);
	}

}
