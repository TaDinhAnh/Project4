package com.demo.services;

import java.util.List;

import com.demo.Dtos.Input.AuctionInput;
import com.demo.Dtos.Output.AuctionOutput;

public interface IAuctionService {
	List<AuctionOutput> getListAuctionById(int idVendor);
	boolean createAuction(AuctionInput auctionInput);
	AuctionOutput updateAuction(AuctionInput auctionInput, int id);  
}
