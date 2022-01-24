package com.demo.Dtos.Output;

public class FeedBackOutput {

	private int id;
	private String accountName;
	private String imageAccount;
	private String gmail;
	private String productName;
	private String content;
	private Boolean isDelete;
	

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
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

	public FeedBackOutput(int id, String accountName, String productName, String content) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.productName = productName;
		this.content = content;
	}

	public FeedBackOutput(int id, String accountName, String imageAccount, String gmail, String productName,
			String content, Boolean isDelete) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.imageAccount = imageAccount;
		this.gmail = gmail;
		this.productName = productName;
		this.content = content;
		this.isDelete = isDelete;
	}
	
	
	

}
