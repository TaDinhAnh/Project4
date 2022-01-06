package com.demo.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AuctionproductId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int proId;
	private int auctionId;

	public AuctionproductId() {
	}

	public AuctionproductId(int proId, int auctionId) {
		this.proId = proId;
		this.auctionId = auctionId;
	}

	@Column(name = "ProId", nullable = false)
	public int getProId() {
		return this.proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	@Column(name = "auctionid", nullable = false)
	public int getAuctionId() {
		return this.auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AuctionproductId))
			return false;
		AuctionproductId castOther = (AuctionproductId) other;

		return (this.getProId() == castOther.getProId()) && (this.getAuctionId() == castOther.getAuctionId());
	}

	public int hashCode() {
		int result = 17;
		result = 37 * result + this.getProId();
		result = 37 * result + this.getAuctionId();
		return result;
	}

}
