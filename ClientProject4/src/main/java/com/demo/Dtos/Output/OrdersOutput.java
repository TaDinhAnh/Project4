package com.demo.Dtos.Output;
import java.util.Date;
import com.demo.common.EOrder;
import com.google.gson.annotations.SerializedName;

public class OrdersOutput {
	@SerializedName("id")
	private Integer id;
	@SerializedName("account")
	private AccountOutput account;
	@SerializedName("successDate")
	private Date successDate;
	@SerializedName("total")
	private Double total;
	@SerializedName("piad")
	private Double piad;
	@SerializedName("address")
	private String address;
	@SerializedName("status")
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

	public OrdersOutput(Integer id, AccountOutput account, Date successDate, Double total, Double piad,
			String address, EOrder status) {
		super();
		this.id = id;
		this.account = account;
		this.successDate = successDate;
		this.total = total;
		this.piad = piad;
		this.address = address;
		this.status = status;
	}
}
