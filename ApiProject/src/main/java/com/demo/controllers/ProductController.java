package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.models.Account;
import com.demo.services.IAccountService;
import com.demo.services.IProductService;

@RequestMapping("api/product")
@RestController
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductOutput>> findList() {
		List<ProductOutput> productOutputs = productService.getListProductByClient();
		if (productOutputs == null || productOutputs.size() <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductOutput>>(productService.getListProductByClient(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> acceptProduct(@PathVariable("id") int id) {
		if (id<=0) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		if (productService.acceptProduct(id)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);

		} else {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}

	}

}
