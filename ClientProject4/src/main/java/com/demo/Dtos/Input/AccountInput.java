package com.demo.Dtos.Input;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.common.ERole;

public class AccountInput {
	@Email(regexp = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$", message = "Invalid email !")
	private String gmail;
	@NotEmpty(message = "Enter password!")
	private String password;
	@Pattern(regexp = "^[a-zA-Z\\s*]+{3,250}$", message = "Enter fullName!")
	private String fullname;
	@Pattern(regexp = "^[0-9]{10}$", message = " Your phone must be phone number!")
	private String phone;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	private String image;
	private ERole role;

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public AccountInput() {
		super();
	}

	public AccountInput(String gmail, String password, String fullname, String phone, Date dob, String image,
			ERole role) {
		super();
		this.gmail = gmail;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
		this.dob = dob;
		this.image = image;
		this.role = role;
	}

}
