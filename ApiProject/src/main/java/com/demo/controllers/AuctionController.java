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

@RequestMapping("api/auction")
@RestController
public class AuctionController {

	@Autowired
	private IAuctionService auctionService;

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
