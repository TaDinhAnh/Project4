package com.demo.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.demo.common.EOrder;

@Entity
@Table(name = "orders")
public class Orders implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Account account;
	private Auction auction;
	private Product product;
	private Date successDate;
	private Double total;
	private Double piad;
	private String address;
	private EOrder status;

	public Orders() {
	}

	public Orders(Account account, Auction auction, Product product, Date successDate, Double total, Double piad,
			String address, EOrder status) {
		this.account = account;
		this.auction = auction;
		this.product = product;
		this.successDate = successDate;
		this.total = total;
		this.piad = piad;
		this.address = address;
		this.status = status;
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
	@JoinColumn(name = "accountid")
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auctionid")
	public Auction getAuction() {
		return this.auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proid")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "successdate", length = 10)
	public Date getSuccessDate() {
		return this.successDate;
	}

	public void setSuccessDate(Date successDate) {
		this.successDate = successDate;
	}

	@Column(name = "Total", precision = 22, scale = 0)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Column(name = "Piad", precision = 22, scale = 0)
	public Double getPiad() {
		return this.piad;
	}

	public void setPiad(Double piad) {
		this.piad = piad;
	}

	@Column(name = "Address", length = 250)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Status")
	public EOrder getStatus() {
		return this.status;
	}

	public void setStatus(EOrder status) {
		this.status = status;
	}

}
