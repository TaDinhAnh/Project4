package com.demo.Dtos.Input;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class AuctionHistoryInput {
	private int accountid;
	private int auctionid;
	private int productid;
	private Double price;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date time;

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public AuctionHistoryInput(int accountid, int auctionid, int productid, Double price, Date time) {
		super();
		this.accountid = accountid;
		this.auctionid = auctionid;
		this.productid = productid;
		this.price = price;
		this.time = time;
	}

	public AuctionHistoryInput() {
		super();
	}

}
