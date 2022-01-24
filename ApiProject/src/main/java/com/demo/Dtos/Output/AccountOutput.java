package com.demo.Dtos.Output;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.demo.common.Constant;
import com.demo.common.ERole;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AccountOutput {
	private int id;
	private String gmail;
	private String fullname;
	private String phone;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String image;
	private ERole role;
	private Boolean isDelete;

	public AccountOutput(int id, String gmail, String fullname, String phone, Date dob, String image, ERole role,
			Boolean isDelete) {
		super();
		this.id = id;
		this.gmail = gmail;
		this.fullname = fullname;
		this.phone = phone;
		this.dob = dob;
		this.image = image;
		this.role = role;
		this.isDelete = isDelete;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

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
		this.image = Constant.urlAvatar + image;
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
		this.image = Constant.urlAvatar +  image;
	}

	public AccountOutput(int id, String gmail, String fullname, String phone, Date dob, String image, ERole role) {
		this.id = id;
		this.gmail = gmail;
		this.fullname = fullname;
		this.phone = phone;
		this.dob = dob;
		this.image = Constant.urlAvatar + image;
		this.role = role;
	}

}
