package com.demo.models;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.demo.common.EAuction;

@Entity
@Table(name = "auction")
public class Auction implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Account account;
	private Date hourStart;
	private Date hourEnd;
	private Date eventdate;
	private String description;
	private EAuction status;
	private Boolean isDel = false;
	private Set orderses = new HashSet(0);
	private Set auctionhistories = new HashSet(0);
	private Set auctionproducts = new HashSet(0);

	public Auction() {
	}

	public Auction(Account account, Date hourStart, Date hourEnd, Date eventdate, String description, EAuction status,
			Boolean isDel, Set orderses, Set auctionhistories, Set auctionproducts) {
		this.account = account;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.eventdate = eventdate;
		this.description = description;
		this.status = status;
		this.isDel = isDel;
		this.orderses = orderses;
		this.auctionhistories = auctionhistories;
		this.auctionproducts = auctionproducts;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getHourStart() {
		return this.hourStart;
	}

	public void setHourStart(Date hourStart) {
		this.hourStart = hourStart;
	}

	public Date getHourEnd() {
		return this.hourEnd;
	}

	public void setHourEnd(Date hourEnd) {
		this.hourEnd = hourEnd;
	}

	public Date getEventdate() {
		return this.eventdate;
	}

	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EAuction getStatus() {
		return this.status;
	}

	public void setStatus(EAuction status) {
		this.status = status;
	}

	public Boolean getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getAuctionhistories() {
		return this.auctionhistories;
	}

	public void setAuctionhistories(Set auctionhistories) {
		this.auctionhistories = auctionhistories;
	}

	public Set getAuctionproducts() {
		return this.auctionproducts;
	}

	public void setAuctionproducts(Set auctionproducts) {
		this.auctionproducts = auctionproducts;
	}

}
