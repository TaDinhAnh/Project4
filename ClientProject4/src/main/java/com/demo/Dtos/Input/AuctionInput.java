package com.demo.Dtos.Input;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class AuctionInput {
	private int vendorId;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date hourStart;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date hourEnd;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date eventdate;
	private String description;

	public AuctionInput() {
		super();
	}

	public AuctionInput(int vendorId, Date hourStart, Date hourEnd, Date eventdate, String description) {
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
