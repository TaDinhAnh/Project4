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
	public ResponseEntity<List<OrdersOutput>> getLimit() {
		List<OrdersOutput> ordersOutputs = ordersService.getListLimit(5);
		if (ordersOutputs == null || ordersOutputs.size() <= 0) {
			return new ResponseEntity<List<OrdersOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<OrdersOutput>>(ordersOutputs, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "findAll" }, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdersOutput>> findAll() {
		List<OrdersOutput> auctionOutputs = ordersService.getAll();
		if (auctionOutputs == null || auctionOutputs.size() <= 0) {
			return new ResponseEntity<List<OrdersOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<OrdersOutput>>(auctionOutputs, HttpStatus.OK);
	}

}
