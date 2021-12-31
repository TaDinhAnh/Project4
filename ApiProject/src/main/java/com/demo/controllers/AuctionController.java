package com.demo.controllers;

import java.util.List;
import javax.validation.Valid;
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
import com.demo.Dtos.Input.AuctionInput;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.services.IAuctionService;
import com.demo.validators.Validate;

@RestController
@RequestMapping("api/auction")
public class AuctionController {
	
	@Autowired
	private IAuctionService auctionService;
	
	@Autowired
	private Validate validate;
	
	@RequestMapping(value = {"/{idVendor}" }, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> getListAuctionByIdVendor(@PathVariable("idVendor") int idVendor) {
		if(idVendor <=0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.BAD_REQUEST);
		}
		List<AuctionOutput> auctionOutputs = auctionService.getListAuctionById(idVendor);
		if(auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionService.getListAuctionById(idVendor), HttpStatus.OK);
	}
	@RequestMapping( method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createAuction(@RequestBody @Valid AuctionInput auctionInput, BindingResult bind) {
		validate.validate(auctionInput, bind);
		if(bind.hasErrors()) {
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
		if(auctionService.createAuction(auctionInput)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}else {		
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.PUT, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuctionOutput> updateAuction(@RequestBody @Valid AuctionInput auctionInput, @PathVariable int id, BindingResult bind) {
		validate.validate(auctionInput, bind);
		if(bind.hasErrors() || id <=0) {
			return new ResponseEntity<AuctionOutput>(HttpStatus.BAD_REQUEST);
		}
		AuctionOutput auctionOutput = auctionService.updateAuction(auctionInput, id);
		if(auctionInput != null) {
			return new ResponseEntity<AuctionOutput>(auctionOutput, HttpStatus.OK);
		}else {		
			return new ResponseEntity<AuctionOutput>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> find() {
		List<AuctionOutput> auctionOutputs = auctionService.getlistAuction();
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionService.getlistAuction(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuctionOutput> search(@PathVariable("id") int id) {
		if (id <= 0) {
			return new ResponseEntity<AuctionOutput>(HttpStatus.BAD_REQUEST);
		}
		AuctionOutput auctionOutput = auctionService.getDetailAuction(id);
		if (auctionOutput == null) {
			return new ResponseEntity<AuctionOutput>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AuctionOutput>(auctionService.getDetailAuction(id), HttpStatus.OK);

	}
	
	@RequestMapping(value = "admin", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> findAll() {
		List<AuctionOutput> auctionOutputs = auctionService.getAll();
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionService.getlistAuction(), HttpStatus.OK);
	}

}
