package com.demo.Dtos.Output;

public class FeedBackOutput {

	private int id;
	private String accountName;
	private String productName;
	private String content;
	

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

	public FeedBackOutput(int id, String accountName, String productName, String content) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.productName = productName;
		this.content = content;
	}
	
	

}
