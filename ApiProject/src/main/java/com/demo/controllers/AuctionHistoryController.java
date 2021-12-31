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
import com.demo.Dtos.Input.AuctionHistoryInput;
import com.demo.Dtos.Output.AuctionHistoryOutput;
import com.demo.services.IAuctionHistoryService;

@RequestMapping("api/auctionhistory")
@RestController
public class AuctionHistoryController {

	@Autowired
	private IAuctionHistoryService auctionHistoryService;

	@RequestMapping(value = { "" }, method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> create(@RequestBody AuctionHistoryInput auctionhistoryInput) {
		if (auctionhistoryInput == null) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
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
				auctionHistoryService.getAuctionHistoryByCustomer(accountid), HttpStatus.OK);

	}

}
