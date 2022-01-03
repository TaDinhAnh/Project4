package com.demo.Dtos.Input;

import javax.validation.constraints.NotEmpty;

public class CategoryInput {
	private int presentid;
	@NotEmpty
	private String name;


	public int getPresentid() {
		return presentid;
	}

	public void setPresentid(int presentid) {
		this.presentid = presentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryInput(int presentid, String name) {
		this.presentid = presentid;
		this.name = name;
	}

	public CategoryInput() {
	}

}
