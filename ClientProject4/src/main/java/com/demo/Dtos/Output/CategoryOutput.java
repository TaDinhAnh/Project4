package com.demo.Dtos.Output;

import com.google.gson.annotations.SerializedName;

public class CategoryOutput {
	@SerializedName("id")
	private int id;
	@SerializedName("presentName")
	private String presentName;
	@SerializedName("name")
	private String name;
	@SerializedName("isDelete")
	private Boolean isDelete;
	@SerializedName("categoryOutput")
	private CategoryOutput categoryOutput;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public CategoryOutput getCategoryOutput() {
		return categoryOutput;
	}

	public void setCategoryOutput(CategoryOutput categoryOutput) {
		this.categoryOutput = categoryOutput;
	}

	public String getPresentName() {
		return presentName;
	}

	public void setPresentName(String presentName) {
		this.presentName = presentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public CategoryOutput(int id, String presentName, String name, Boolean isDelete, CategoryOutput categoryOutput) {
		super();
		this.id = id;
		this.presentName = presentName;
		this.name = name;
		this.isDelete = isDelete;
		this.categoryOutput = categoryOutput;
	}

	public CategoryOutput() {
		super();
	}

}
