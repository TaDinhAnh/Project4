package com.demo.services;

import org.springframework.stereotype.Service;
import com.demo.Dtos.Output.AuctionProductOutput;

@Service
public interface IAuctionProductService {
//	AuctionProductOutput getList(int productId, int auctionId);

	AuctionProductOutput findListSold(int accountId, int productid);
	
}
