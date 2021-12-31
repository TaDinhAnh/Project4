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

import com.demo.Dtos.Input.CategoryInput;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.Dtos.Output.CategoryOutput;
import com.demo.services.IAuctionService;
import com.demo.services.ICategoryService;

@RequestMapping("api/category")
@RestController
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryOutput>> find() {
		List<CategoryOutput> categoryOutputs = categoryService.getListCategory();
		if (categoryOutputs == null || categoryOutputs.size() <= 0) {
			return new ResponseEntity<List<CategoryOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CategoryOutput>>(categoryService.getListCategory(), HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createCategory(@RequestBody CategoryInput categoryInput) {
		if(categoryInput == null) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		if (categoryService.createCategory(categoryInput)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT,  consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateCategory( @PathVariable("id") int id, @RequestBody CategoryInput categoryInput) {
		if(id <=0) {
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
		if (categoryInput == null) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<Boolean>(categoryService.updateCategory(id, categoryInput), HttpStatus.OK);



	}
	

}
