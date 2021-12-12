package com.demo.models;
import static javax.persistence.GenerationType.IDENTITY;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.demo.common.ERole;
import com.demo.common.EStatus;

@Entity
@Table(name = "account")
public class Account {
	private Integer id;

	private Date createdAt;

	private Date updatedAt;

	private EStatus status;
	private String username;
	private String password;
	private ERole role;

	public Account() {
	}

	public Account(String username, String password, ERole role, Integer id, Date createdAt, Date updatedAt,
			EStatus status) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
		this.username = username;
		this.password = password;
		this.role = role;
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
