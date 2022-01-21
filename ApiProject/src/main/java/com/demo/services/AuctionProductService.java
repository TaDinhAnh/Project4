package com.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Output.AuctionProductOutput;
import com.demo.reponsitories.AuctionProductReponsitory;

@Service
public class AuctionProductService implements IAuctionProductService {

	@Autowired
	private AuctionProductReponsitory auctionProductReponsitory;

//	@Override
//	public AuctionProductOutput getList(int productId, int auctionId) {
////		Auctionproduct auctionproduct = new Auctionproduct()
//		Optional<Auctionproduct> auctionproduct = auctionProductReponsitory
//				.findById(new AuctionproductId(productId, auctionId));
//		System.out.println(auctionproduct.get().getId().getAuctionId());
////		AuctionProductOutput auctionProductOutput = new AuctionProductOutput();
//		return null;
//	}



	@Override
	public AuctionProductOutput findListSold(int accountId, int productid) {
		return auctionProductReponsitory.findListSold(accountId, productid);
	}

}
