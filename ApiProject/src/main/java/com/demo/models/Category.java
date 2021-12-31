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

@Entity
@Table(name = "category")
public class Category implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Category category;
	private String name;
	private Boolean isDelete;
	private Set<Category> categories = new HashSet<Category>(0);
	private Set<Product> products = new HashSet<Product>(0);

	public Category() {
	}

	public Category(Category category, String name, Boolean isDelete, Set<Category> categories, Set<Product> products) {
		this.category = category;
		this.name = name;
		this.isDelete = isDelete;
		this.categories = categories;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PresentID")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "Name", length = 250)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "isdelete")
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
