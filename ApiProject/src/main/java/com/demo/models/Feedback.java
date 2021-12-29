package com.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Account account;
	private Product product;
	private String content;
	private Boolean isDel = false;

	public Feedback() {
	}

	public Feedback(Account account, Product product, String content, Boolean isDel) {
		this.account = account;
		this.product = product;
		this.content = content;
		this.isDel = isDel;
	}

	public Integer getId() {
		return this.id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

}
