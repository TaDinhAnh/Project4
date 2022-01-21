package com.demo.Dtos.Output;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.demo.common.ERole;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AccountOutput {
	private int id;
	private String gmail;
	private String fullname;
	private String phone;
	private String password;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String image;
	private ERole role;

	public String getGmail() {
		return gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public AccountOutput(int id, String gmail, String fullname, String phone, String password, Date dob, String image,
			ERole role) {
		super();
		this.id = id;
		this.gmail = gmail;
		this.fullname = fullname;
		this.phone = phone;
		this.password = password;
		this.dob = dob;
		this.image = image;
		this.role = role;
	}

}
