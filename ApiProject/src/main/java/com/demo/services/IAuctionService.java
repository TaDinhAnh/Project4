package com.demo.services;

import java.util.List;

import com.demo.Dtos.Input.AuctionInput;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.models.Auction;

public interface IAuctionService {
	AuctionOutput getDetailAuction(int id);

	List<AuctionOutput> getlistAuction();

	Auction findById(int id);

	List<AuctionOutput> getAll();

	List<AuctionOutput> getListAuctionById(int idVendor);

	boolean createAuction(AuctionInput auctionInput);

	AuctionOutput updateAuction(AuctionInput auctionInput, int id);

	List<AuctionOutput> getlistAuctionOver();

	List<AuctionOutput> getlistAuctionHappening();

	List<AuctionOutput> getlistAuctionComingsoon();

	List<AuctionOutput> getLimitAuctionHappening();

	List<AuctionOutput> getAuction(int accountid);

	boolean delAuction(int id);

	List<AuctionOutput> getAuctionByEventDate(String eventdate);

}
