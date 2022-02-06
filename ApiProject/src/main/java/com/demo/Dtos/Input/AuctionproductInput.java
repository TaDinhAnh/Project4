package com.demo.Dtos.Input;

public class AuctionproductInput {

	private int proId;
	private int auctionId;
	

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public AuctionproductInput() {
		super();
	}

	public AuctionproductInput(int proId, int auctionId) {
		super();
		this.proId = proId;
		this.auctionId = auctionId;
	}

}
