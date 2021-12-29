package com.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autionproduct")
public class Auctionproduct implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AuctionproductId id;
	private Auction auction;
	private Product product;
	private Boolean status;

	public Auctionproduct() {
	}

	public Auctionproduct(AuctionproductId id, Auction auction, Product product) {
		this.id = id;
		this.auction = auction;
		this.product = product;
	}

	public Auctionproduct(AuctionproductId id, Auction auction, Product product, Boolean status) {
		this.id = id;
		this.auction = auction;
		this.product = product;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public AuctionproductId getId() {
		return this.id;
	}

	public void setId(AuctionproductId id) {
		this.id = id;
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

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
