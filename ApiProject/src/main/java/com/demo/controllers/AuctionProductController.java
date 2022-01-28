package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		if (accountId <= 0 || productId <= 0)
			return new ResponseEntity<AuctionProductOutput>(HttpStatus.BAD_REQUEST);
		AuctionProductOutput auctionProductOutput = auctionProductService.findListSold(accountId, productId);
		if (auctionProductOutput == null) {
			return new ResponseEntity<AuctionProductOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AuctionProductOutput>(auctionProductOutput, HttpStatus.OK);
	}

	@RequestMapping(value = "getProduct/{auctionid}/{productid}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuctionProductOutput> getByIdProductAndAuction(@PathVariable("auctionid") int auctionid,
			@PathVariable("productid") int productid) {
		if (auctionid <= 0 || productid <= 0)
			return new ResponseEntity<AuctionProductOutput>(HttpStatus.BAD_REQUEST);
		AuctionProductOutput auctionProductOutput = auctionProductService.getByIdProductAndAuction(auctionid,
				productid);
		if (auctionProductOutput.getAuctionOutput() == null || auctionProductOutput.getProductOutput() == null) {
			return new ResponseEntity<AuctionProductOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AuctionProductOutput>(auctionProductOutput, HttpStatus.OK);
	}

}
