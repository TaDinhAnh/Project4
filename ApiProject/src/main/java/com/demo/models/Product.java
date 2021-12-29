package com.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.common.EProduct;

@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Account category;
	private String name;
	private Double priceMin;
	private String image;
	private String description;
	private Integer vendorId;
	private EProduct status;
	private Boolean isDelete = false;
	private Boolean isAccept;
	private Set auctionhistories = new HashSet(0);
	private Set feedbacks = new HashSet(0);
	private Set orderses = new HashSet(0);
	private Set auctionproducts = new HashSet(0);

	public Product() {
	}

	public Product(Account category, String name, Double priceMin, String image, String description, Integer vendorId,
			EProduct status, Boolean isDelete, Boolean isAccept, Set auctionhistories, Set feedbacks, Set orderses,
			Set auctionproducts) {
		this.category = category;
		this.name = name;
		this.priceMin = priceMin;
		this.image = image;
		this.description = description;
		this.vendorId = vendorId;
		this.status = status;
		this.isDelete = isDelete;
		this.isAccept = isAccept;
		this.auctionhistories = auctionhistories;
		this.feedbacks = feedbacks;
		this.orderses = orderses;
		this.auctionproducts = auctionproducts;
	}
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getCategory() {
		return this.category;
	}

	public void setCategory(Account category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPriceMin() {
		return this.priceMin;
	}

	public void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public EProduct getStatus() {
		return this.status;
	}

	public void setStatus(EProduct status) {
		this.status = status;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsAccept() {
		return this.isAccept;
	}

	public void setIsAccept(Boolean isAccept) {
		this.isAccept = isAccept;
	}

	public Set getAuctionhistories() {
		return this.auctionhistories;
	}

	public void setAuctionhistories(Set auctionhistories) {
		this.auctionhistories = auctionhistories;
	}

	public Set getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Set feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getAuctionproducts() {
		return this.auctionproducts;
	}

	public void setAuctionproducts(Set auctionproducts) {
		this.auctionproducts = auctionproducts;
	}

}
