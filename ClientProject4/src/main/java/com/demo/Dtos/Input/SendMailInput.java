package com.demo.Dtos.Input;

public class SendMailInput {
	private String toEmail;
	private String content;
	private String subject;

	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public SendMailInput(String toEmail, String content, String subject) {
		super();
		this.toEmail = toEmail;
		this.content = content;
		this.subject = subject;
	}

	public SendMailInput() {
		super();
	}

}
