package com.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Auctionhistory> auctionhistories = new HashSet<Auctionhistory>(0);
	private Set<Auctionproduct> auctionproducts = new HashSet<Auctionproduct>(0);

	public Auction() {
	}

	public Auction(Account account, Date hourStart, Date hourEnd, Date eventdate, String description, EAuction status,
			Boolean isDel, Set<Orders> orderses, Set<Auctionhistory> auctionhistories,
			Set<Auctionproduct> auctionproducts) {
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
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendorid")
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hourstart", length = 8)
	public Date getHourStart() {
		return this.hourStart;
	}

	public void setHourStart(Date hourStart) {
		this.hourStart = hourStart;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hourend", length = 8)
	public Date getHourEnd() {
		return this.hourEnd;
	}

	public void setHourEnd(Date hourEnd) {
		this.hourEnd = hourEnd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Eventdate", length = 10)
	public Date getEventdate() {
		return this.eventdate;
	}

	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}

	@Column(name = "Description", length = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Status")
	public EAuction getStatus() {
		return this.status;
	}

	public void setStatus(EAuction status) {
		this.status = status;
	}

	@Column(name = "isdel")
	public Boolean getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "auction")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "auction")
	public Set<Auctionhistory> getAuctionhistories() {
		return this.auctionhistories;
	}

	public void setAuctionhistories(Set<Auctionhistory> auctionhistories) {
		this.auctionhistories = auctionhistories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "auction")
	public Set<Auctionproduct> getAuctionproducts() {
		return this.auctionproducts;
	}

	public void setAuctionproducts(Set<Auctionproduct> auctionproducts) {
		this.auctionproducts = auctionproducts;
	}

}
