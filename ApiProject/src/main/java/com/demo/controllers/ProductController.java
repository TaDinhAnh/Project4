package com.demo.controllers;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.Dtos.Input.ProductInput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.services.IProductService;
import com.demo.validators.Validate;

@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private Validate validate;

	@RequestMapping(method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOutput> ceateProduct(@RequestBody @Valid ProductInput productInput,
			BindingResult bind) {
		validate.validate(productInput, bind);
		if (bind.hasErrors()) {
			return new ResponseEntity<ProductOutput>(HttpStatus.BAD_REQUEST);
		}
		ProductOutput product = productService.createProduct(productInput);
		if (product == null) {
			return new ResponseEntity<ProductOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ProductOutput>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOutput> updateProduct(@RequestBody @Valid ProductInput productInput,
			@PathVariable int id, BindingResult bind) {
		validate.validate(productInput, bind);
		if (bind.hasErrors() || id <= 0) {
			return new ResponseEntity<ProductOutput>(HttpStatus.BAD_REQUEST);
		}
		ProductOutput product = productService.updateProduct(productInput, id);
		if (product == null) {
			return new ResponseEntity<ProductOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ProductOutput>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductOutput>> findList() {
		List<ProductOutput> productOutputs = productService.getListProductByClient();
		if (productOutputs == null || productOutputs.size() <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductOutput>>(productService.getListProductByClient(), HttpStatus.OK);
	}

	@RequestMapping(value = "search/{name}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductOutput>> search(@PathVariable("name") String name) {
		if (name == null) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.BAD_REQUEST);
		}
		List<ProductOutput> productOutputs = productService.getListProduct(name);
		if (productOutputs == null || productOutputs.size() <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductOutput>>(productService.getListProduct(name), HttpStatus.OK);

	}

	@RequestMapping(value = "accept/{id}", method = RequestMethod.PATCH, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> acceptProduct(@PathVariable("id") int id) {
		if (id <= 0) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		if (productService.acceptProduct(id)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);

		} else {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}

	}

}
