package com.demo.Dtos.Output;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.common.EProduct;
import com.google.gson.annotations.SerializedName;

public class AuctionHistoryOutput {
	@SerializedName("id")
	private int id;
	
	@SerializedName("accountname")	
	private String accountname;
	
	@SerializedName("productname")
	private String productname;
	
	@SerializedName("category")	
	private String category;
	@SerializedName("priceMin")
	private double priceMin;
	@SerializedName("image")
	private String image;
	@SerializedName("description")
	private String description;
	@SerializedName("status")
	private EProduct status;
	@SerializedName("hourStart")
	private String hourStart;
	@SerializedName("hourEnd")
	private String hourEnd;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@SerializedName("eventdate")
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

	public String getHourStart() {
		return hourStart;
	}

	public void setHourStart(String hourStart) {
		this.hourStart = hourStart;
	}

	public String getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(String hourEnd) {
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(double priceMin) {
		this.priceMin = priceMin;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EProduct getStatus() {
		return status;
	}

	public void setStatus(EProduct status) {
		this.status = status;
	}

	public AuctionHistoryOutput() {
		super();
	}

	public AuctionHistoryOutput(int id, String accountname, String productname, String hourStart, String hourEnd,
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

	public AuctionHistoryOutput(int id, String accountname, String productname, String category, double priceMin,
			String image, String description, EProduct status, String hourStart, String hourEnd, Date eventdate,
			Double price, Date time) {
		super();
		this.id = id;
		this.accountname = accountname;
		this.productname = productname;
		this.category = category;
		this.priceMin = priceMin;
		this.image = image;
		this.description = description;
		this.status = status;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.eventdate = eventdate;
		this.price = price;
		this.time = time;
	}

}
