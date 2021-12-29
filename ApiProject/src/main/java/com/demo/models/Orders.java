package com.demo.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.common.EOrder;


@Entity
@Table(name = "orders")
public class Orders implements java.io.Serializable {

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

	public Auction getAuction() {
		return this.auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getSuccessDate() {
		return this.successDate;
	}

	public void setSuccessDate(Date successDate) {
		this.successDate = successDate;
	}

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getPiad() {
		return this.piad;
	}

	public void setPiad(Double piad) {
		this.piad = piad;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public EOrder getStatus() {
		return this.status;
	}

	public void setStatus(EOrder status) {
		this.status = status;
	}

}
