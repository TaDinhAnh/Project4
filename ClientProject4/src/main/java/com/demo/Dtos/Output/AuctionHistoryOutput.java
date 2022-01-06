package com.demo.Dtos.Output;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.annotations.SerializedName;

public class AuctionHistoryOutput {
	@SerializedName("id")
	private int id;
	@SerializedName("accountname")
	private String accountname;
	@SerializedName("productname")
	private String productname;
	@SerializedName("hourStart")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date hourStart;
	@SerializedName("hourEnd")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date hourEnd;
	@SerializedName("eventdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date eventdate;
	@SerializedName("price")
	private Double price;
	@SerializedName("time")
	private Date time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHourStart() {
		return hourStart;
	}

	public void setHourStart(Date hourStart) {
		this.hourStart = hourStart;
	}

	public Date getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(Date hourEnd) {
		this.hourEnd = hourEnd;
	}

	public Date getEventdate() {
		return eventdate;
	}

	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
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

	public AuctionHistoryOutput() {
		super();
	}

	public AuctionHistoryOutput(int id, String accountname, String productname, Date hourStart, Date hourEnd,
			Date eventdate, Double price, Date time) {
		super();
		this.id = id;
		this.accountname = accountname;
		this.productname = productname;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.eventdate = eventdate;
		this.price = price;
		this.time = time;
	}

}
