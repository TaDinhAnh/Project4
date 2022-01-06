package com.demo.Dtos.Output;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.common.ERole;
import com.google.gson.annotations.SerializedName;

public class AccountOutput {
	@SerializedName("id")
	private int id;
	@SerializedName("gmail")
	private String gmail;
	@SerializedName("fullname")
	private String fullname;
	@SerializedName("phone")
	private String phone;
	@SerializedName("dob")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	@SerializedName("image")
	private String image;
	@SerializedName("role")
	private ERole role;

	public String getGmail() {
		return gmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public AccountOutput() {
		super();
	}

	public AccountOutput(String gmail, String fullname, String phone, Date dob, String image) {
		super();
		this.gmail = gmail;
		this.fullname = fullname;
		this.phone = phone;
		this.dob = dob;
		this.image = image;
	}

	public AccountOutput(int id, String gmail, String fullname, String phone, Date dob, String image, ERole role) {
		this.id = id;
		this.gmail = gmail;
		this.fullname = fullname;
		this.phone = phone;
		this.dob = dob;
		this.image = image;
		this.role = role;
	}

}
