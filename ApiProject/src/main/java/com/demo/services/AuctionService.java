package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.AuctionInput;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.common.EAuction;
import com.demo.models.Account;
import com.demo.models.Auction;
import com.demo.reponsitories.AuctionRepository;


@Service
public class AuctionService implements IAuctionService {
	
	@Autowired
	private AuctionRepository auctionRepositories;
	
	@Autowired IAccountService accountService;

	@Override
	public List<AuctionOutput> getListAuctionById(int idVendor) {
		return auctionRepositories.getAuctionByIdVendor(idVendor);
	}

	@Override
	public boolean createAuction(AuctionInput auctionInput) {
		Account account = accountService.findById(auctionInput.getVendorId());
		if(account == null) return false;
		Auction auction = new Auction();
		auction.setAccount(account);
		auction.setEventdate(auctionInput.getEventdate());
		auction.setHourEnd(auctionInput.getHourEnd());
		auction.setHourStart(auctionInput.getHourStart());
		auction.setDescription(auctionInput.getDescription());
		auction.setStatus(EAuction.comingsoon);
		auction.setIsDel(false);
		return auctionRepositories.save(auction) != null;
	}

	@Override
	public AuctionOutput updateAuction(AuctionInput auctionInput, int id) {
		Auction auction = find(id);
		if(auction == null)
			return null;
		auction.setEventdate(auctionInput.getEventdate());
		auction.setHourEnd(auctionInput.getHourEnd());
		auction.setHourStart(auctionInput.getHourStart());
		auction.setDescription(auctionInput.getDescription());
		auction = auctionRepositories.save(auction);
		return new AuctionOutput(auction.getId(), auction.getHourStart(), auction.getHourEnd(), 
				auction.getEventdate(), auction.getDescription(), auction.getStatus(), auction.getIsDel());
	}
	
	public Auction find(int id) {
		try {
			return auctionRepositories.findById(id).get();
		} catch (Exception e) {
			return null;
		}
		
	}
	@Override
	public AuctionOutput getDetailAuction(int id) {
		return auctionRepositories.getDetailAuction(id);		
	}

	@Override
	public List<AuctionOutput> getlistAuction() {
		return auctionRepositories.getlistAuction();
	}

	@Override
	public Auction findById(int id) {
		try {
			return auctionRepositories.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<AuctionOutput> getAll() {
		return auctionRepositories.getAll();
	}

	@Override
	public List<AuctionOutput> getlistAuctionOver() {
		return auctionRepositories.getlistAuctionOver();
	}

	@Override
	public List<AuctionOutput> getlistAuctionHappening() {
		return auctionRepositories.getlistAuctionHappening();
	}

	@Override
	public List<AuctionOutput> getlistAuctionComingsoon() {
		return auctionRepositories.getlistAuctionComingsoon();
	}

	@Override
	public List<AuctionOutput> getLimitAuctionHappening() {
		List<Auction>auctions = auctionRepositories.getLimitAuctionHappening();
		List<AuctionOutput> auctionOutputs = new ArrayList<AuctionOutput>();
		for(Auction auction :auctions) {
			AuctionOutput auctionOutput = new AuctionOutput();
			auctionOutput.setId(auction.getId());
			auctionOutput.setDescription(auction.getDescription());
			auctionOutput.setEventdate(auction.getEventdate());
			auctionOutput.setFullname(auction.getAccount().getFullname());
			auctionOutput.setHourEnd(auction.getHourEnd());
			auctionOutput.setHourStart(auction.getHourStart());
			auctionOutputs.add(auctionOutput);
		}
		return auctionOutputs;
	}

	@Override
	public List<AuctionOutput> getAuction(int accountid) {
		return auctionRepositories.getAuction(accountid);
	}

	@Override
	public boolean delAuction(int id) {
		Auction auction = auctionRepositories.findById(id).get();
		auction.setIsDel(true);		
		return auctionRepositories.save(auction) != null;
	}
}
