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
import com.demo.Dtos.Input.SendMailInput;
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
	public ResponseEntity<ProductOutput> createProduct(@RequestBody @Valid ProductInput productInput,
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE,
			MimeTypeUtils.IMAGE_JPEG_VALUE })
	public ResponseEntity<ProductOutput> findById(@PathVariable int id) {
		if (id <= 0) {
			return new ResponseEntity<ProductOutput>(HttpStatus.BAD_REQUEST);
		}
		ProductOutput product = productService.find(id);
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
		return new ResponseEntity<List<ProductOutput>>(productOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOutput> find(@PathVariable("id") int id) {
		if (id <= 0) {
			return new ResponseEntity<ProductOutput>(HttpStatus.BAD_REQUEST);
		}
		ProductOutput productOutput = productService.find2(id);
		if (productOutput == null) {
			return new ResponseEntity<ProductOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ProductOutput>(productOutput, HttpStatus.OK);
	}

	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductOutput>> findAll() {
		List<ProductOutput> productOutputs = productService.findAllProduct();
		if (productOutputs == null || productOutputs.size() <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductOutput>>(productOutputs, HttpStatus.OK);
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
		return new ResponseEntity<List<ProductOutput>>(productOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "accept/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Boolean> acceptProduct(@PathVariable("id") int id) {
		if (id <= 0) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		if (productService.acceptProduct(id)) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);

	}

	@RequestMapping(value = "limit", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductOutput>> getListLimit() {
		List<ProductOutput> productOutputs = productService.getListLimit();
		if (productOutputs == null || productOutputs.size() <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductOutput>>(productOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "sold/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductOutput>> getListProductSold(@PathVariable("id") int vendorId) {
		List<ProductOutput> productOutputs = productService.getListProductSold(vendorId);
		if (vendorId <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.BAD_REQUEST);
		}
		if (productOutputs == null || productOutputs.size() <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductOutput>>(productOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "unSold/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductOutput>> getListProductUnsold(@PathVariable("id") int vendorId) {
		List<ProductOutput> productOutputs = productService.getListProductUnsold(vendorId);
		if (vendorId <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.BAD_REQUEST);
		}
		if (productOutputs == null || productOutputs.size() <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductOutput>>(productOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "listAccept/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductOutput>> getListProductAccept(@PathVariable("id") int vendorId) {
		List<ProductOutput> productOutputs = productService.getListProductAccept(vendorId);
		if (vendorId <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.BAD_REQUEST);
		}
		if (productOutputs == null || productOutputs.size() <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductOutput>>(productOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "listNotAccept/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductOutput>> getListProductNotAccept(@PathVariable("id") int vendorId) {
		List<ProductOutput> productOutputs = productService.getListProductNotAccept(vendorId);
		if (vendorId <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.BAD_REQUEST);
		}
		if (productOutputs == null || productOutputs.size() <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductOutput>>(productOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "cancel/{id}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> cancelProduct(@PathVariable("id") int id,
			@RequestBody @Valid SendMailInput sendMailInput, BindingResult bind) {
		validate.validate(sendMailInput, bind);
		if (bind.hasErrors() || id <= 0) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		if (productService.cancelProduct(id, sendMailInput)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
