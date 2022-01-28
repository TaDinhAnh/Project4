package com.demo.Dtos.Output;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.common.EAuction;
import com.google.gson.annotations.SerializedName;

public class AuctionOutput {
	@SerializedName("id")
	private int id;
	@SerializedName("fullname")
	private String fullname;
	@SerializedName("hourStart")
	private String hourStart;
	@SerializedName("hourEnd")
	private String hourEnd;
	@SerializedName("eventdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date eventdate;
	@SerializedName("description")
	private String description;
	@SerializedName("status")
	private EAuction status;
	@SerializedName("isDel")
	private Boolean isDel;
	private List<ProductOutput> productOutputs;

	public List<ProductOutput> getProductOutputs() {
		return productOutputs;
	}

	public void setProductOutputs(List<ProductOutput> productOutputs) {
		this.productOutputs = productOutputs;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EAuction getStatus() {
		return status;
	}

	public void setStatus(EAuction status) {
		this.status = status;
	}

	public Boolean getIsDel() {
		return isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	public AuctionOutput() {
		super();
	}

	public AuctionOutput(int id, String fullname, String hourStart, String hourEnd, Date eventdate, String description,
			EAuction status, Boolean isDel, List<ProductOutput> productOutputs) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.eventdate = eventdate;
		this.description = description;
		this.status = status;
		this.isDel = isDel;
		this.productOutputs = productOutputs;
	}

}
