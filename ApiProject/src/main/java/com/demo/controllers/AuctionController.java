
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
import com.demo.services.IAuctionHistoryService;
import com.demo.services.IAuctionService;
import com.demo.validators.Validate;

@RestController
@RequestMapping("api/auction")
public class AuctionController {

	@Autowired
	private IAuctionService auctionService;

	@Autowired
	private IAuctionHistoryService auctionHistoryService;

	@Autowired
	private Validate validate;

	@RequestMapping(value = {
			"vendor/{idVendor}" }, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> getListAuctionByIdVendor(@PathVariable("idVendor") int idVendor) {
		if (idVendor <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.BAD_REQUEST);
		}
		List<AuctionOutput> auctionOutputs = auctionService.getListAuctionById(idVendor);
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createAuction(@RequestBody @Valid AuctionInput auctionInput, BindingResult bind) {
		validate.validate(auctionInput, bind);
		if (bind.hasErrors()) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}

		if (!auctionService.createAuction(auctionInput)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuctionOutput> updateAuction(@RequestBody @Valid AuctionInput auctionInput,
			@PathVariable int id, BindingResult bind) {
		validate.validate(auctionInput, bind);
		if (bind.hasErrors()) {
			return new ResponseEntity<AuctionOutput>(HttpStatus.BAD_REQUEST);
		}
		AuctionOutput auctionOutput = auctionService.updateAuction(auctionInput, id);
		if (auctionInput == null) {
			return new ResponseEntity<AuctionOutput>(HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<AuctionOutput>(auctionOutput, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> find() {
		List<AuctionOutput> auctionOutputs = auctionService.getlistAuction();
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuctionOutput> search(@PathVariable("id") int id) {
		if (id <= 0) {
			return new ResponseEntity<AuctionOutput>(HttpStatus.BAD_REQUEST);
		}
		AuctionOutput auctionOutput = auctionService.getDetailAuction(id);
		if (auctionOutput == null) {
			return new ResponseEntity<AuctionOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AuctionOutput>(auctionOutput, HttpStatus.OK);

	}

	@RequestMapping(value = "admin", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> findAll() {
		List<AuctionOutput> auctionOutputs = auctionService.getAll();
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "over", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> getlistAuctionOver() {
		List<AuctionOutput> auctionOutputs = auctionService.getlistAuctionOver();
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "happening", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> getlistAuctionHapping() {
		List<AuctionOutput> auctionOutputs = auctionService.getlistAuctionHappening();
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "comingsoon", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> getlistAuctionComingsoon() {
		List<AuctionOutput> auctionOutputs = auctionService.getlistAuctionComingsoon();
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "limit", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> getLimitAuctionHappening() {
		List<AuctionOutput> auctionOutputs = auctionService.getLimitAuctionHappening();
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = "getProduct/{auctionid}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuctionOutput> getProduct(@PathVariable("auctionid") int auctionId) {
		if (auctionId <= 0) {
			return new ResponseEntity<AuctionOutput>(HttpStatus.BAD_REQUEST);
		}
		AuctionOutput auctionOutput = auctionService.getListProductAuction(auctionId);
		if (auctionOutput == null) {
			return new ResponseEntity<AuctionOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AuctionOutput>(auctionOutput, HttpStatus.OK);
	}

	@RequestMapping(value = "getAuctionHistory/{accountid}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> getAuctionByIdCus(@PathVariable("accountid") int accountid) {
		if (accountid <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.BAD_REQUEST);
		}
		List<AuctionOutput> auctionOutput = auctionHistoryService.getAuctionByIdCustomer(accountid);
		return new ResponseEntity<List<AuctionOutput>>(auctionOutput, HttpStatus.OK);
	}

	@RequestMapping(value = "getAuction/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> getAuction(@PathVariable("id") int accountid) {
		if (accountid <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.BAD_REQUEST);
		}
		List<AuctionOutput> auctionOutput = auctionService.getAuction(accountid);
		if (auctionOutput == null || auctionOutput.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionOutput, HttpStatus.OK);

	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> Del(@PathVariable("id") int id) {
		if (id <= 0) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}

		if (auctionService.delAuction(id)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@RequestMapping(value = {"searchbyDate/{eventdate}" }, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AuctionOutput>> getListAuctionByIdVendor(@PathVariable("eventdate") String eventdate) {
		if (eventdate == null) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.BAD_REQUEST);
		}
		List<AuctionOutput> auctionOutputs = auctionService.getAuctionByEventDate(eventdate);
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<AuctionOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AuctionOutput>>(auctionOutputs, HttpStatus.OK);
	}

}
