package com.demo.Dtos.Output;

import java.util.Date;

import com.demo.common.ERole;
import com.demo.common.EStatus;

public class AccountOutput {
	private Integer id;

	private Date createdAt;

	private Date updatedAt;

	private EStatus status;

	private String username;

	private ERole role;

	public AccountOutput(Integer id, Date createdAt, Date updatedAt, EStatus status, String username, ERole role) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
		this.username = username;
		this.role = role;
	}

	public AccountOutput() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}
	
	
}
