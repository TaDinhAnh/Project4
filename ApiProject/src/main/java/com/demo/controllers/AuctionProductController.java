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

import com.demo.Dtos.Input.AuctionproductInput;
import com.demo.Dtos.Output.AuctionProductOutput;
import com.demo.services.IAuctionProductService;

@RestController
@RequestMapping("api/auctionProduct")
public class AuctionProductController {
	@Autowired
	private IAuctionProductService auctionProductService;

	@RequestMapping(value = "findListSold/{accountId}/{productId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuctionProductOutput> findListSold(@PathVariable("accountId") int accountId,
			@PathVariable("productId") int productId) {
		AuctionProductOutput auctionProductOutput = auctionProductService.findListSold(accountId, productId);
		if(accountId <=0 || productId <=0) {
			return new ResponseEntity<AuctionProductOutput>(HttpStatus.BAD_REQUEST);
		}
		if (auctionProductOutput == null) {
			return new ResponseEntity<AuctionProductOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AuctionProductOutput>(auctionProductOutput, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> create(@RequestBody AuctionproductInput auctionproductInput) {
		if (!auctionProductService.create(auctionproductInput)) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{accountId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionProductOutput>> findById(@PathVariable("accountId") int accountId) {
		List<AuctionProductOutput> auctionProductOutput = auctionProductService.findById(accountId);
		if(accountId <=0) {
			return new ResponseEntity<List<AuctionProductOutput>>(HttpStatus.BAD_REQUEST);
		}
		if (auctionProductOutput == null || auctionProductOutput.size() <=0) {
			return new ResponseEntity<List<AuctionProductOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionProductOutput>>(auctionProductOutput, HttpStatus.OK);
	}
<<<<<<< HEAD
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> create(@RequestBody AuctionproductInput auctionproductInput) {
		if (!auctionProductService.create(auctionproductInput)) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
=======
>>>>>>> vendorCUProduct
}
