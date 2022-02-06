package com.demo.Dtos.Input;

public class Socket {
	private String fullname;
	private double price;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Socket(String fullname, double price) {
		super();
		this.fullname = fullname;
		this.price = price;
	}

	public Socket() {
		super();
	}

}
