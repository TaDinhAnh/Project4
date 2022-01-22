package com.demo.Dtos.Output;

import com.google.gson.annotations.SerializedName;

public class FeedBackOutput {
	@SerializedName("id")
	private int id;
	@SerializedName("accountName")
	private String accountName;
	@SerializedName("productName")
	private String productName;
	@SerializedName("imageAccount")
	private String imageAccount;
	@SerializedName("gmail")
	private String gmail;
	@SerializedName("content")
	private String content;
	@SerializedName("isDelete")
	private Boolean isDelete;

	public String getImageAccount() {
		return imageAccount;
	}

	public void setImageAccount(String imageAccount) {
		this.imageAccount = imageAccount;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public FeedBackOutput() {
		super();
	}

	
	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public FeedBackOutput(int id, String accountName, String imgAccount, String gmail, String productName,
			String content, Boolean isDelete) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.productName = productName;
		this.content = content;
		this.gmail = gmail;
		this.imageAccount = imgAccount;
		this.isDelete = isDelete;
	}

}
