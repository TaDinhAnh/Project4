package com.demo.Dtos.Output;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.demo.common.EOrder;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrdersOutput {
	private Integer id;
	private AccountOutput account;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date successDate;
	private Double total;
	private Double piad;
	private String address;
	private EOrder status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AccountOutput getAccount() {
		return account;
	}

	public void setAccount(AccountOutput account) {
		this.account = account;
	}

	public Date getSuccessDate() {
		return successDate;
	}

	public void setSuccessDate(Date successDate) {
		this.successDate = successDate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getPiad() {
		return piad;
	}

	public void setPiad(Double piad) {
		this.piad = piad;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public EOrder getStatus() {
		return status;
	}

	public void setStatus(EOrder status) {
		this.status = status;
	}

	public OrdersOutput() {
		super();
	}

	public OrdersOutput(Integer id, AccountOutput account, Date successDate, Double total, Double piad, String address,
			EOrder status) {
		super();
		this.id = id;
		this.account = account;
		this.successDate = successDate;
		this.total = total;
		this.piad = piad;
		this.address = address;
		this.status = status;
	}

	public OrdersOutput(Integer id, Date successDate, Double total, Double piad, String address, EOrder status,
			int idAccount, String gmail, String fullname, String image, String phone) {
		super();
		this.id = id;
		this.successDate = successDate;
		this.total = total;
		this.piad = piad;
		this.address = address;
		this.status = status;
		this.account = new AccountOutput();
		this.account.setFullname(fullname);
		this.account.setGmail(gmail);
		this.account.setId(idAccount);
		this.account.setImage(image);
		this.account.setPhone(phone);
	}

	public OrdersOutput(Integer id, Date successDate, Double total, Double piad, EOrder status, String fullname) {
		super();
		this.id = id;
		this.successDate = successDate;
		this.total = total;
		this.piad = piad;
		this.status = status;
		this.account = new AccountOutput();
		this.account.setFullname(fullname);
	}

}
