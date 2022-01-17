package com.demo.Dtos.Output;

public class CategoryOutput {
	private int id;
	private int categoryid;
	private String presentName;
	private String name;
	private Boolean isDelete;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
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

	public CategoryOutput(String presentName, String name) {
		super();
		this.presentName = presentName;
		this.name = name;
	}
	
	

	public CategoryOutput(String presentName, String name, Boolean isDelete) {
		super();
		this.presentName = presentName;
		this.name = name;
		this.isDelete = isDelete;
	}

	public CategoryOutput() {
		super();
	}

	public CategoryOutput(int id, int categoryid, String presentName, String name, Boolean isDelete) {
		super();
		this.id = id;
		this.categoryid = categoryid;
		this.presentName = presentName;
		this.name = name;
		this.isDelete = isDelete;
	}
	
	

}
