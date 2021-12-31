package com.demo.services;

import java.util.List;

import com.demo.Dtos.Output.AuctionOutput;
import com.demo.models.Auction;

public interface IAuctionService {
	AuctionOutput getDetailAuction(int id);

	List<AuctionOutput> getlistAuction();

	Auction findById(int id);

	List<AuctionOutput> getAll();

}
