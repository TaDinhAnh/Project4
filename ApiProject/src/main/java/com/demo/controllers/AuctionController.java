package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.services.IAuctionService;

@RestController
@RequestMapping("api/auction")
public class AuctionController {
	
	@Autowired
	private IAuctionService auctionService;
	
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
	
	
}
