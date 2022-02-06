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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.Dtos.Input.ProductInput;
import com.demo.Dtos.Input.SendMailInput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.common.UploadImg;
import com.demo.services.IProductService;
import com.demo.validators.Validate;

@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private Validate validate;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProductOutput> createProduct(@RequestParam("filePro") MultipartFile file,
			@RequestParam("namePro") String namePro, @RequestParam("proDesc") String proDesc,
			@RequestParam("pricePro") Double pricePro, @RequestParam("idVendor") int idVendor,
			@RequestParam("idCate") int idCate) {
		if (file == null) {
			return new ResponseEntity<ProductOutput>(HttpStatus.BAD_REQUEST);
		}
		String filename = UploadImg.Upload(file, "product");
		if (filename == null) {
			return new ResponseEntity<ProductOutput>(HttpStatus.BAD_REQUEST);
		}
		ProductInput productInput = new ProductInput();
		productInput.setCategoryId(idCate);
		productInput.setName(namePro);
		productInput.setPriceMin(pricePro);
		productInput.setDescription(proDesc);
		productInput.setVendorId(idVendor);
		productInput.setImage(filename);
		ProductOutput product = productService.createProduct(productInput);
		if (product == null) {
			return new ResponseEntity<ProductOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ProductOutput>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateProduct(@RequestBody @Valid ProductInput productInput, @PathVariable int id,
			BindingResult bind) {
		validate.validate(productInput, bind);
		if (bind.hasErrors() || id <= 0) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		if (!productService.updateProduct(productInput, id)) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
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

	@RequestMapping(value = "find/{productId}/{vendorId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOutput> findByVendor(@PathVariable("productId") int productId,
			@PathVariable("vendorId") int vendorId) {
		if (vendorId <= 0 || productId <= 0) {
			return new ResponseEntity<ProductOutput>(HttpStatus.BAD_REQUEST);
		}
		ProductOutput productOutput = productService.findByVendorId(productId, vendorId);
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
	
	@RequestMapping(value = "searchbyPrice/{priceMin}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductOutput>> searchByPrice(@PathVariable("priceMin") int priceMin) {
		if (priceMin <=0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.BAD_REQUEST);
		}
		List<ProductOutput> productOutputs = productService.getListMinPrice(priceMin);
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

	@RequestMapping(value = "listNotAccept/{vendorId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductOutput>> getListProductNotAccept(@PathVariable("vendorId") int vendorId) {
		List<ProductOutput> productOutputs = productService.getListProductNotAccept(vendorId);
		if (vendorId <= 0) {
			return new ResponseEntity<List<ProductOutput>>(HttpStatus.BAD_REQUEST);
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

	@RequestMapping(value = { "changeImg/{id}/{imgOld}" }, method = RequestMethod.POST, produces = {
			MimeTypeUtils.IMAGE_PNG_VALUE, MimeTypeUtils.IMAGE_JPEG_VALUE, MimeTypeUtils.IMAGE_GIF_VALUE })
	public ResponseEntity<Void> changeAvatar(@RequestParam("fileImg") MultipartFile file, @PathVariable("id") int id,
			@PathVariable("imgOld") String imgOld) {
		if (file == null || id <= 0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		String filename = UploadImg.Upload(file, "product");
		if (filename == null) {
			UploadImg.DelFile(imgOld, "product");
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!productService.updateImg(id, filename)) {
			UploadImg.DelFile(filename, "avatar");
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		UploadImg.DelFile(imgOld, "product");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
