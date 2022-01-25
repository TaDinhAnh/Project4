package com.demo.Dtos.Input;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ChangePass {

	@NotEmpty
	String passOld;
	@NotEmpty
	String passNew;

	public ChangePass(@NotEmpty String passOld, @NotEmpty String passNew) {
		super();
		this.passOld = passOld;
		this.passNew = passNew;
	}

	public ChangePass() {
		super();
	}

	public String getPassOld() {
		return passOld;
	}

	public void setPassOld(String passOld) {
		this.passOld = passOld;
	}

	public String getPassNew() {
		return passNew;
	}

	public void setPassNew(String passNew) {
		this.passNew = passNew;
	}

}
