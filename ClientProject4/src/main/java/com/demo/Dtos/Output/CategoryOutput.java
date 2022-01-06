package com.demo.Dtos.Output;

public class CategoryOutput {
	private String presentName;
	private String name;

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

	public CategoryOutput() {
		super();
	}

}
