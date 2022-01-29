package com.demo.Dtos.Output;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.demo.common.EAuction;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AuctionOutput {
	private int id;
	private String fullname;
	@JsonFormat(pattern = "HH:mm:ss")
	@Temporal(TemporalType.TIME)
	private Date hourStart;
	@JsonFormat(pattern = "HH:mm:ss")
	@Temporal(TemporalType.TIME)
	private Date hourEnd;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date eventdate;
	private String description;
	private EAuction status;
	private Boolean isDel;
	private List<AuctionHistoryOutput> auctionHistoryOutputs;
	private List<ProductOutput> productOutputs;

	public List<ProductOutput> getProductOutputs() {
		return productOutputs;
	}

	public void setProductOutputs(List<ProductOutput> productOutputs) {
		this.productOutputs = productOutputs;
	}

	public AuctionOutput() {
		super();
	}

	public AuctionOutput(int id, Date hourStart, Date hourEnd, Date eventdate, String description, EAuction status,
			boolean isDel) {
		super();
		this.id = id;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.eventdate = eventdate;
		this.description = description;
		this.status = status;
		this.isDel = isDel;
	}

	public AuctionOutput(int id, Date hourStart, Date hourEnd, Date eventdate, String description, EAuction status) {
		super();
		this.id = id;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.eventdate = eventdate;
		this.description = description;
		this.status = status;
	}

	public AuctionOutput(int id, String fullname, Date hourStart, Date hourEnd, Date eventdate, String description,
			EAuction status) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.eventdate = eventdate;
		this.description = description;
		this.status = status;
	}

	public AuctionOutput(int id, Date eventdate) {
		super();
		this.id = id;
		this.eventdate = eventdate;
	}

	public List<AuctionHistoryOutput> getAuctionHistoryOutputs() {
		return auctionHistoryOutputs;
	}

	public void setAuctionHistoryOutputs(List<AuctionHistoryOutput> auctionHistoryOutputs) {
		this.auctionHistoryOutputs = auctionHistoryOutputs;
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

}
