package com.demo.Dtos.Input;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuctionInput {
	@Min(value = 1)
	private int vendorId;
	@JsonFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	private Date hourStart;
	@JsonFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	private Date hourEnd;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date eventdate;
	@NotEmpty
	private String description;

	public AuctionInput() {
		super();
	}

	public AuctionInput(@Min(1) int vendorId, Date hourStart, Date hourEnd, Date eventdate,
			@NotEmpty String description) {
		super();
		this.vendorId = vendorId;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.eventdate = eventdate;
		this.description = description;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
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

}
