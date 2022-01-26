package com.demo.services;

import org.springframework.stereotype.Service;
import com.demo.Dtos.Output.AuctionProductOutput;

@Service
public interface IAuctionProductService {

	AuctionProductOutput findListSold(int accountId, int productid);
	
}
