package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.AuctionproductInput;
import com.demo.Dtos.Output.AuctionProductOutput;
import com.demo.Dtos.Output.ProductOutput;

@Service
public interface IAuctionProductService {

	AuctionProductOutput findListSold(int accountId, int productid);

	List<ProductOutput> getListProByAution(int auctionId);

	AuctionProductOutput getByIdProductAndAuction(int auctionid, int productid);

	Boolean create(AuctionproductInput auctionproductInput);

	List<AuctionProductOutput> findById(int accountId);

}
