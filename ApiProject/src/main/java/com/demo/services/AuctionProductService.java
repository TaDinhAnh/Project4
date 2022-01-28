package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Output.AuctionProductOutput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.reponsitories.AuctionProductReponsitory;

@Service
public class AuctionProductService implements IAuctionProductService {

	@Autowired
	private AuctionProductReponsitory auctionProductReponsitory;

	@Override
	public AuctionProductOutput findListSold(int accountId, int productid) {
		return auctionProductReponsitory.findListSold(accountId, productid);
	}

	@Override
	public List<ProductOutput> getListProByAution(int auctionId) {
		return auctionProductReponsitory.getListProByAuction(auctionId);
	}

	@Override
	public AuctionProductOutput getByIdProductAndAuction(int auctionid, int productid) {
		return auctionProductReponsitory.getByIdProductAndAuction(auctionid, productid);
	}

}
