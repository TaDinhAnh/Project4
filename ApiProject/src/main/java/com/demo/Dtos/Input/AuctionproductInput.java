package com.demo.Dtos.Input;

public class AuctionproductInput {

	private int auctionid;
	private int productid;

	public int getAuctionid() {
		return auctionid;
	}

	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public AuctionproductInput(int auctionid, int productid) {
		super();
		this.auctionid = auctionid;
		this.productid = productid;
	}

	public AuctionproductInput() {
		super();
	}

}
