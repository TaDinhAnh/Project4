package com.demo.Dtos.Input;

import com.demo.common.ERole;

public class AccountInput {
	private String username;
	private String password;
	private ERole role;
	public AccountInput(String username, String password, ERole role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public AccountInput() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ERole getRole() {
		return role;
	}
	public void setRole(ERole role) {
		this.role = role;
	}
	
}
