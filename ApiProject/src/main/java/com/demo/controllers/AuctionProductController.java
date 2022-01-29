package com.demo.controllers;

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
}
