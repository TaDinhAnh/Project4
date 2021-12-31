package com.demo.services;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.AuctionHistoryInput;
import com.demo.Dtos.Output.AuctionHistoryOutput;
import com.demo.models.Account;
import com.demo.models.Auction;
import com.demo.models.Auctionhistory;
import com.demo.models.Product;
import com.demo.reponsitories.IAuctionHistoryResponsitory;

@Service
public class AuctionHistoryService implements IAuctionHistoryService {
	@Autowired
	private IAuctionHistoryResponsitory auctionHistoryResponsitory;

	@Autowired
	private IAccountService accountService;

	@Autowired
	private IProductService productService;

	@Autowired
	private IAuctionService auctionService;

	@Override
	public List<AuctionHistoryOutput> getlistAuctionHistory() {
		return auctionHistoryResponsitory.getlistAuctionHistory();
	}

	@Override
	public boolean createAuctionHistory(AuctionHistoryInput auctionHistoryInput) {
		Auctionhistory auctionhistory = new Auctionhistory();
		Account account =accountService.findById(auctionHistoryInput.getAccountid());
		Auction auction = auctionService.findById(auctionHistoryInput.getAuctionid());
		Product product =productService.findById(auctionHistoryInput.getProductid());
		if(account == null || auction == null|| product == null) {
			return false;
		}
		auctionhistory.setAccount(account);
		auctionhistory.setAuction(auction);
		auctionhistory.setProduct(product);
		auctionhistory.setPrice(auctionHistoryInput.getPrice());
		auctionhistory.setTime(new Date());
		return auctionHistoryResponsitory.save(auctionhistory) != null;
	}

	@Override
	public List<AuctionHistoryOutput> getAuctionHistoryByCustomer(int accountid) {
			return auctionHistoryResponsitory.getAuctionHistoryByCustomer(accountid);
	}

}
