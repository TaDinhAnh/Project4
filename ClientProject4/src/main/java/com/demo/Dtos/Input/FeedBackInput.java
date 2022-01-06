package com.demo.Dtos.Input;


public class FeedBackInput {
	private int accountId;
	private int productId;
	private String content;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public FeedBackInput() {
		super();
	}

	public FeedBackInput(int accountId, int productId, String content) {
		super();
		this.accountId = accountId;
		this.productId = productId;
		this.content = content;
	}

}
