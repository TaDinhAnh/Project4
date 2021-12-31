package com.demo.Dtos.Input;

import java.util.Date;

public class AuctionInput {
	private Date hourStart;
	private Date hourEnd;
	private Date eventdate;
	private String description;
	
	public AuctionInput() {
		super();
	}
	public AuctionInput(Date hourStart, Date hourEnd, Date eventdate, String description) {
		super();
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.eventdate = eventdate;
		this.description = description;
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
