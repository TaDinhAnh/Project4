package com.demo.Dtos.Input;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ProductInput {
	@Min(value = 1)
	private int categoryId;
	@NotEmpty
	private String name;
	@Min(value = 1)
	private Double priceMin;
	private String image;
	@NotEmpty
	private String description;
	@Min(value = 1)
	private Integer vendorId;
	public ProductInput(int categoryId, String name, Double priceMin, String image, String description,
			Integer vendorId) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.priceMin = priceMin;
		this.image = image;
		this.description = description;
		this.vendorId = vendorId;
	}
	public ProductInput() {
		super();
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}	
}
