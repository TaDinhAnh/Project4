package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Output.AuctionOutput;
import com.demo.models.Auction;
import com.demo.reponsitories.IAuctionResponsitory;

@Service
public class AuctionService implements IAuctionService {
	@Autowired
	private IAuctionResponsitory auctionResponsitory;

	@Override
	public AuctionOutput getDetailAuction(int id) {
		return auctionResponsitory.getDetailAuction(id);		
	}

	@Override
	public List<AuctionOutput> getlistAuction() {
		return auctionResponsitory.getlistAuction();
	}

	@Override
	public Auction findById(int id) {
		try {
			return auctionResponsitory.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<AuctionOutput> getAll() {
		return auctionResponsitory.getAll();
	}

}
