package com.demo.Dtos.Output;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.demo.common.EProduct;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AuctionHistoryOutput {
	private int id;
	private String accountname;
	private String productname;
	private ProductOutput productOutput = new ProductOutput();
	public ProductOutput getProductOutput() {
		return productOutput;
	}
	public void setProductOutput(ProductOutput productOutput) {
		this.productOutput = productOutput;
	}

	@JsonFormat(pattern = "HH:mm:ss")
	@Temporal(TemporalType.TIME)
	private Date hourStart;
	@JsonFormat(pattern = "HH:mm:ss")
	@Temporal(TemporalType.TIME)
	private Date hourEnd;
	private Date eventdate;
	private Double price;
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

	public AuctionHistoryOutput(int id, String accountname, String productname, String category, Double priceMin,
			String image, String description, EProduct status, Date hourStart, Date hourEnd, Date eventdate,
			Double price, Date time) {
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

	public AuctionHistoryOutput(int id, String accountname, String productname, int productid, String category,
			Double priceMin, String image, String description, EProduct status, Date hourStart, Date hourEnd,
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
