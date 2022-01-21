package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.Dtos.Output.OrdersOutput;
import com.demo.services.IOrdersService;

@RequestMapping("api/orders")
@RestController
public class OrdersControllers {
	@Autowired
	private IOrdersService ordersService;

	@RequestMapping(value = { "limit" }, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdersOutput>> getListAuctionByIdVendor() {
		List<OrdersOutput> auctionOutputs = ordersService.getListLimit(5);
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<OrdersOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<OrdersOutput>>(auctionOutputs, HttpStatus.OK);
	}

}
