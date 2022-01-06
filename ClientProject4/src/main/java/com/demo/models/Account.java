package com.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Auction> auctions = new HashSet<Auction>(0);
	private Set<Feedback> feedbacks = new HashSet<Feedback>(0);
	private Set<Auctionhistory> auctionhistories = new HashSet<Auctionhistory>(0);
	private Set<Product> products = new HashSet<Product>(0);

	public Account() {
	}

	public Account(String gmail, String password, String fullname, String phone, Date dob, String image, ERole role,
			Boolean isDelete, Set<Orders> orderses, Set<Auction> auctions, Set<Feedback> feedbacks,
			Set<Auctionhistory> auctionhistories, Set<Product> products) {
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
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Gmail", length = 250)
	public String getGmail() {
		return this.gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	@Column(name = "Password", length = 250)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Fullname", length = 250)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "Phone", length = 10)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Dob", length = 10)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "Image", length = 250)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "Role")
	public ERole getRole() {
		return this.role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	@Column(name = "isdelete")
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Auction> getAuctions() {
		return this.auctions;
	}

	public void setAuctions(Set<Auction> auctions) {
		this.auctions = auctions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Auctionhistory> getAuctionhistories() {
		return this.auctionhistories;
	}

	public void setAuctionhistories(Set<Auctionhistory> auctionhistories) {
		this.auctionhistories = auctionhistories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
