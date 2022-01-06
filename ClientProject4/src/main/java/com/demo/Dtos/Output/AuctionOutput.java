package com.demo.Dtos.Output;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.common.EAuction;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AuctionOutput {
	private int id;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date hourStart;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date hourEnd;
	private Date eventdate;
	private String description;
	private EAuction status;
	private Boolean isDel;

	public AuctionOutput() {
		super();
	}

	public AuctionOutput(int id, Date hourStart, Date hourEnd, Date eventdate, String description, EAuction status, boolean isDel) {
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
