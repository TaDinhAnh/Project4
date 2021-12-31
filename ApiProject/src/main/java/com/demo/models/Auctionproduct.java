package com.demo.models;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auctionproduct")
public class Auctionproduct implements java.io.Serializable {

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

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "proId", column = @Column(name = "ProId", nullable = false)),
			@AttributeOverride(name = "auctionId", column = @Column(name = "AuctionId", nullable = false)) })
	public AuctionproductId getId() {
		return this.id;
	}

	public void setId(AuctionproductId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AuctionId", nullable = false, insertable = false, updatable = false)
	public Auction getAuction() {
		return this.auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProId", nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "Status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
