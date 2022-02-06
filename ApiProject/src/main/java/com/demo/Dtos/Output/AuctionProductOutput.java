package com.demo.Dtos.Output;

import java.util.Date;
import com.demo.common.EAuction;
import com.demo.common.EProduct;

public class AuctionProductOutput {
	private int proId;
	private int auctionid;
	private AuctionOutput auctionOutput = new AuctionOutput();
	private ProductOutput productOutput = new ProductOutput();
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

	public AuctionProductOutput(int auctionid, int proId, String fullname, Date hourStart, Date hourEnd, Date eventdate,
			String descriptionAuc, EAuction statusAuc, String productname, String category, Double priceMin,
			String image, String descriptionPro, EProduct statusPro, boolean isAccept, boolean status) {
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
		this.productOutput.setIsAccept(isAccept);
		this.status = status;
	}

	public AuctionProductOutput(int auctionid, int proId, Date hourStart, Date hourEnd, Date eventdate,
			String productname, String category, Double priceMin, String image, String descriptionPro,
			String fullName, EAuction statusAuction) {
		this.auctionOutput.setId(auctionid);
		this.auctionOutput.setHourStart(hourStart);
		this.auctionOutput.setHourEnd(hourEnd);
		this.auctionOutput.setEventdate(eventdate);
		this.auctionOutput.setFullname(fullName);
		this.auctionOutput.setStatus(statusAuction);
		this.productOutput.setId(proId);
		this.productOutput.setName(productname);
		this.productOutput.setCategory(category);
		this.productOutput.setDescription(descriptionPro);
		this.productOutput.setPriceMin(priceMin);
		this.productOutput.setImage(image);
	}

	public AuctionProductOutput(int proId, int auctionid, boolean status) {
		super();
		this.proId = proId;
		this.auctionid = auctionid;
		this.status = status;
	}

}
