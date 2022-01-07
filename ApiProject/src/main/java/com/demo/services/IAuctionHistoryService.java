package com.demo.services;

import java.util.List;


import com.demo.Dtos.Input.AuctionHistoryInput;
import com.demo.Dtos.Output.AuctionHistoryOutput;

public interface IAuctionHistoryService {
	List<AuctionHistoryOutput> getlistAuctionHistory();;

	boolean createAuctionHistory(AuctionHistoryInput auctionHistoryInput);

	List<AuctionHistoryOutput> getAuctionHistoryByCustomer(int accountid);

	List<AuctionHistoryOutput> getAuctionHistoryById(int id);
}
