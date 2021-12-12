package com.demo.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.demo.common.EStatus;

public class BaseModel {
	private Integer id;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	private EStatus status;
	

	public BaseModel() {
		
	}
	

	public BaseModel(Integer id, Date createdAt, Date updatedAt, EStatus status) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
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


	
	
}
