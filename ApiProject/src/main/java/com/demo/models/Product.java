package com.demo.models;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.demo.common.EProduct;

@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Category category;
	private String name;
	private Double priceMin;
	private String image;
	private String description;
	private Integer vendorId;
	private EProduct status;
	private Boolean isDelete = false;
	private Boolean isAccept = false;
	private Set<Auctionhistory> auctionhistories = new HashSet<Auctionhistory>(0);
	private Set<Feedback> feedbacks = new HashSet<Feedback>(0);
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Auctionproduct> auctionproducts = new HashSet<Auctionproduct>(0);

	public Product() {
	}

	public Product(Category category, String name, Double priceMin, String image, String description, Integer vendorId,
			EProduct status, Boolean isDelete, Boolean isAccept, Set<Auctionhistory> auctionhistories,
			Set<Feedback> feedbacks, Set<Orders> orderses, Set<Auctionproduct> auctionproducts) {
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
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CateID")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "Name", length = 500)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pricemin", precision = 22, scale = 0)
	public Double getPriceMin() {
		return this.priceMin;
	}

	public void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}

	@Column(name = "Image", length = 250)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "Description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "vendorid")
	public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	@Column(name = "Status")
	public EProduct getStatus() {
		return this.status;
	}

	public void setStatus(EProduct status) {
		this.status = status;
	}

	@Column(name = "isdelete")
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "isaccept")
	public Boolean getIsAccept() {
		return this.isAccept;
	}

	public void setIsAccept(Boolean isAccept) {
		this.isAccept = isAccept;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Auctionhistory> getAuctionhistories() {
		return this.auctionhistories;
	}

	public void setAuctionhistories(Set<Auctionhistory> auctionhistories) {
		this.auctionhistories = auctionhistories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Auctionproduct> getAuctionproducts() {
		return this.auctionproducts;
	}

	public void setAuctionproducts(Set<Auctionproduct> auctionproducts) {
		this.auctionproducts = auctionproducts;
	}

}
