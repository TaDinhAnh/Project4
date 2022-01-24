package com.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.Dtos.Input.CategoryInput;
import com.demo.Dtos.Output.CategoryOutput;
import com.demo.services.ICategoryService;
import com.demo.validators.Validate;

@RequestMapping("api/category")
@RestController
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private Validate validate;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryOutput>> find() {
		List<CategoryOutput> categoryOutputs = categoryService.getListCategory();
		if (categoryOutputs == null || categoryOutputs.size() <= 0) {
			return new ResponseEntity<List<CategoryOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CategoryOutput>>(categoryService.getListCategory(), HttpStatus.OK);
	}

	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryOutput>> findAll() {
		List<CategoryOutput> categoryOutputs = categoryService.findAllCategory();
		if (categoryOutputs == null || categoryOutputs.size() <= 0) {
			return new ResponseEntity<List<CategoryOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CategoryOutput>>(categoryOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createCategory(@RequestBody @Valid CategoryInput categoryInput, BindingResult bind) {
		validate.validate(categoryInput, bind);
		if (bind.hasErrors()) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		if (!categoryService.createCategory(categoryInput)) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);

	}
	@CrossOrigin(origins = "http://localhost:8088")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateCategory(@PathVariable("id") int id,
			@RequestBody @Valid CategoryInput categoryInput, BindingResult bind) {
		validate.validate(categoryInput, bind);
		if (bind.hasErrors() || id <= 0) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		if (!categoryService.updateCategory(id, categoryInput)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}