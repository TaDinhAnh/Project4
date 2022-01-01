package com.demo.Dtos.Input;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuctionHistoryInput {
	@Min(value = 1)
	private int accountid;
	@Min(value = 1)
	private int auctionid;
	@Min(value = 1)
	private int productid;
	@Min(value = 1)
	private Double price;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.DATE)
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
