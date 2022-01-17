package com.demo.Dtos.Output;

import java.util.Date;
import com.demo.common.EProduct;

import com.google.gson.annotations.SerializedName;

public class AuctionHistoryOutput {
	@SerializedName("id")
	private int id;
	@SerializedName("accountname")
	private String accountname;
	@SerializedName("productname")
	private String productname;
	@SerializedName("productOutput")
	private ProductOutput productOutput = new ProductOutput();

	public ProductOutput getProductOutput() {
		return productOutput;
	}

	public void setProductOutput(ProductOutput productOutput) {
		this.productOutput = productOutput;
	}

	@SerializedName("hourStart")
	private String hourStart;
	@SerializedName("hourEnd")
	private String hourEnd;
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

	public AuctionHistoryOutput(int id, String accountname, String productname, String category, Double priceMin,
			String image, String description, EProduct status, String hourStart, String hourEnd, Date eventdate,
			Double price, Date time) {
		this.id = id;
		this.accountname = accountname;
		this.productname = productname;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.eventdate = eventdate;
		this.price = price;
		this.time = time;
	}

	public AuctionHistoryOutput(int id, String accountname, String productname, int productid, String category,
			Double priceMin, String image, String description, EProduct status, String hourStart, String hourEnd,
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
		this.productOutput.setId(id);
		this.productOutput.setName(productname);
		this.productOutput.setCategory(category);
		this.productOutput.setDescription(description);
		this.productOutput.setPriceMin(priceMin);
		this.productOutput.setImage(image);
		this.productOutput.setStatus(status);
	}

}
