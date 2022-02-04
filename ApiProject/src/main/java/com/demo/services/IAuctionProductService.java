package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.AuctionproductInput;
import com.demo.Dtos.Output.AuctionProductOutput;

@Service
public interface IAuctionProductService {

	AuctionProductOutput findListSold(int accountId, int productid);
	Boolean create(AuctionproductInput auctionproductInput);
	
	List<AuctionProductOutput> findById(int accountId);
}
