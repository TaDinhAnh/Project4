package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.AuctionproductInput;
import com.demo.Dtos.Output.AuctionProductOutput;
import com.demo.models.Auction;
import com.demo.models.Auctionproduct;
import com.demo.models.AuctionproductId;
import com.demo.models.Product;
import com.demo.reponsitories.AuctionProductReponsitory;

@Service
public class AuctionProductService implements IAuctionProductService {

	@Autowired
	private AuctionProductReponsitory auctionProductReponsitory;
	@Autowired
	private ProductService productService;
	@Autowired
	private AuctionService auctionService;

	@Override
	public List<AuctionProductOutput> findById(int accountId) {
		return auctionProductReponsitory.findById(accountId);
	}

	@Override
	public AuctionProductOutput findListSold(int accountId, int productid) {
		return auctionProductReponsitory.findListSold(accountId, productid);
	}

	@Override
	public Boolean create(AuctionproductInput auctionproductInput) {
		Auctionproduct auctionproduct = new Auctionproduct();
		AuctionproductId auctionproductId = new AuctionproductId();
		auctionproductId.setAuctionId(auctionproductInput.getAuctionId());
		auctionproductId.setProId(auctionproductInput.getProId());
		auctionproduct.setId(auctionproductId);

		return auctionProductReponsitory.save(auctionproduct) != null;
	}

}
