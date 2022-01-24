package com.demo.Dtos.Output;

public class CategoryOutput {
	private int id;
	private String presentName;
	private String name;
	private Boolean isDelete;
	
	private CategoryOutput categoryOutput;
	
	public CategoryOutput getCategoryOutput() {
		return categoryOutput;
	}

	public void setCategoryOutput(CategoryOutput categoryOutput) {
		this.categoryOutput = categoryOutput;
	}

	public String getPresentName() {
		return presentName;
	}

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


	public void setPresentName(String presentName) {
		this.presentName = presentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryOutput(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CategoryOutput( String presentName, String name) {
		super();
		this.presentName = presentName;
		this.name = name;
	}
	
	public CategoryOutput(int id,  int idPresent,  String presentName, String name, Boolean isDelete) {
		super();
		this.id = id;
		this.presentName = presentName;
		this.name = name;
		this.isDelete = isDelete;
		this.categoryOutput = new CategoryOutput();
		this.categoryOutput.setName(presentName);
		this.categoryOutput.setId(id);
	}
	
	public CategoryOutput(int id, String name, Boolean isDelete) {
		super();
		this.id = id;
		this.presentName = categoryOutput.getName();
		this.name = name;
		this.isDelete = isDelete;
	}
	
	
	public CategoryOutput() {
		super();
	}

}
