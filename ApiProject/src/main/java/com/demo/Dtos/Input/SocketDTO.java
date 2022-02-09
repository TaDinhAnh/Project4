package com.demo.Dtos.Input;

public class SocketDTO {
	public String action;
	public Object payload;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public SocketDTO(String action, Object payload) {
		super();
		this.action = action;
		this.payload = payload;
	}

	public SocketDTO() {
		super();
	}

}
