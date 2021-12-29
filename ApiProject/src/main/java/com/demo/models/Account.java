package com.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.common.ERole;
@Entity
@Table(name = "account")
public class Account implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String gmail;
	private String password;
	private String fullname;
	private String phone;
	private Date dob;
	private String image;
	private ERole role;
	private Boolean isDelete = false;
	private Set orderses = new HashSet(0);
	private Set auctions = new HashSet(0);
	private Set feedbacks = new HashSet(0);
	private Set auctionhistories = new HashSet(0);
	private Set products = new HashSet(0);

	public Account() {
	}

	public Account(String gmail, String password, String fullname, String phone, Date dob, String image, ERole role,
			Boolean isDelete, Set orderses, Set auctions, Set feedbacks, Set auctionhistories, Set products) {
		this.gmail = gmail;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
		this.dob = dob;
		this.image = image;
		this.role = role;
		this.isDelete = isDelete;
		this.orderses = orderses;
		this.auctions = auctions;
		this.feedbacks = feedbacks;
		this.auctionhistories = auctionhistories;
		this.products = products;
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

	public String getGmail() {
		return this.gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ERole getRole() {
		return this.role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getAuctions() {
		return this.auctions;
	}

	public void setAuctions(Set auctions) {
		this.auctions = auctions;
	}

	public Set getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Set feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Set getAuctionhistories() {
		return this.auctionhistories;
	}

	public void setAuctionhistories(Set auctionhistories) {
		this.auctionhistories = auctionhistories;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

}
