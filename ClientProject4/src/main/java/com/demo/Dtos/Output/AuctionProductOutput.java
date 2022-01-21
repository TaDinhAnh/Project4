package com.demo.Dtos.Output;

import java.util.Date;

import com.demo.common.EAuction;
import com.demo.common.EProduct;
import com.google.gson.annotations.SerializedName;

public class AuctionProductOutput {
	@SerializedName("proId")
	private int proId;
	@SerializedName("auctionid")
	private int auctionid;
	@SerializedName("auctionOutput")
	private AuctionOutput auctionOutput = new AuctionOutput();
	@SerializedName("productOutput")
	private ProductOutput productOutput = new ProductOutput();
	@SerializedName("status")
	private boolean status;

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getAuctionid() {
		return auctionid;
	}

	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public AuctionOutput getAuctionOutput() {
		return auctionOutput;
	}

	public void setAuctionOutput(AuctionOutput auctionOutput) {
		this.auctionOutput = auctionOutput;
	}

	public ProductOutput getProductOutput() {
		return productOutput;
	}

	public void setProductOutput(ProductOutput productOutput) {
		this.productOutput = productOutput;
	}

	public AuctionProductOutput() {
		super();
	}

	public AuctionProductOutput(int auctionid, int proId, String fullname, String hourStart, String hourEnd, Date eventdate,
			String descriptionAuc, EAuction statusAuc,  String productname, String category,
			Double priceMin, String image, String descriptionPro, EProduct statusPro, boolean status) {
		this.proId = proId;
		this.auctionid = auctionid;
		this.auctionOutput.setId(auctionid);
		this.auctionOutput.setFullname(fullname);
		this.auctionOutput.setHourStart(hourStart);
		this.auctionOutput.setHourEnd(hourEnd);
		this.auctionOutput.setEventdate(eventdate);
		this.auctionOutput.setDescription(descriptionAuc);
		this.auctionOutput.setStatus(statusAuc);
		this.productOutput.setId(proId);
		this.productOutput.setName(productname);
		this.productOutput.setCategory(category);
		this.productOutput.setDescription(descriptionPro);
		this.productOutput.setPriceMin(priceMin);
		this.productOutput.setImage(image);
		this.productOutput.setStatus(statusPro);
		this.status = status;
	}
}
