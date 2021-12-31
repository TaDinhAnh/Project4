package com.demo.Dtos.Input;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class FeedbackInput {
	@Min(value = 1)
	private int accountId;
	@Min(value = 1)
	private int productId;
	@NotEmpty
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
	public FeedbackInput(int accountId, int productId, String content) {
		super();
		this.accountId = accountId;
		this.productId = productId;
		this.content = content;
	}
	public FeedbackInput() {
		super();
	}
	
	
}
