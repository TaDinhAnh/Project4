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
import com.demo.Dtos.Input.AuctionHistoryInput;
import com.demo.Dtos.Output.AuctionHistoryOutput;
import com.demo.models.Auctionhistory;
import com.demo.services.IAuctionHistoryService;
import com.demo.validators.Validate;

@RequestMapping("api/auctionhistory")
@RestController
public class AuctionHistoryController {

	@Autowired
	private IAuctionHistoryService auctionHistoryService;
	
	@Autowired
	private Validate validate;
	@RequestMapping(value = { "" }, method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> create(@RequestBody @Valid AuctionHistoryInput auctionhistoryInput, BindingResult bind) {
		validate.validate(auctionhistoryInput, bind);
		if(bind.hasErrors()) {
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
		if (auctionHistoryService.createAuctionHistory(auctionhistoryInput)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);

		} else {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionHistoryOutput>> findList() {
		List<AuctionHistoryOutput> auctionHistoryOutputs = auctionHistoryService.getlistAuctionHistory();
		if (auctionHistoryOutputs == null || auctionHistoryOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionHistoryOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionHistoryOutput>>(auctionHistoryService.getlistAuctionHistory(),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{accountid}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionHistoryOutput>> getAuctionHistoryByCustomer(
			@PathVariable("accountid") int accountid) {
		if (accountid <= 0) {
			return new ResponseEntity<List<AuctionHistoryOutput>>(HttpStatus.BAD_REQUEST);
		}
		List<AuctionHistoryOutput> auctionHistoryOutputs = auctionHistoryService.getAuctionHistoryByCustomer(accountid);
		if (auctionHistoryOutputs == null || auctionHistoryOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionHistoryOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionHistoryOutput>>(
				auctionHistoryOutputs, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/auction/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionHistoryOutput>> getAuctionHistoryById(
			@PathVariable("id") int id) {
		if (id <= 0) {
			return new ResponseEntity<List<AuctionHistoryOutput>>(HttpStatus.BAD_REQUEST);
		}
		List<AuctionHistoryOutput> auctionHistoryOutputs = auctionHistoryService.getAuctionHistoryById(id);
		if (auctionHistoryOutputs == null ) {
			return new ResponseEntity<List<AuctionHistoryOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionHistoryOutput>>(
				auctionHistoryOutputs, HttpStatus.OK);

	}
	@RequestMapping(value = "/auction2/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Auctionhistory>> getAuctionHistoryById2(
			@PathVariable("id") int id) {
		if (id <= 0) {
			return new ResponseEntity<List<Auctionhistory>>(HttpStatus.BAD_REQUEST);
		}
		List<Auctionhistory> auctionHistoryOutputs = auctionHistoryService.getAuctionHistoryById2(id);
		if (auctionHistoryOutputs == null ) {
			return new ResponseEntity<List<Auctionhistory>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Auctionhistory>>(
				auctionHistoryOutputs, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/count/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> countAuctionHistoryById(
			@PathVariable("id") int id) {
		if (id <= 0) {
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		Integer count = auctionHistoryService.countAuctionHistoryById(id);
		if (count <= 0 || count == null ) {
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(
				count, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/maxprice/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> maxPriceAuctionHistoryById(
			@PathVariable("id") int id) {
		if (id <= 0) {
			return new ResponseEntity<Double>(HttpStatus.BAD_REQUEST);
		}
		Double auctionHistoryOutputs = auctionHistoryService.maxPriceAuctionHistoryById(id);
		if (auctionHistoryOutputs <=0 ) {
			return new ResponseEntity<Double>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Double>(
				auctionHistoryOutputs, HttpStatus.OK);

	}

}
