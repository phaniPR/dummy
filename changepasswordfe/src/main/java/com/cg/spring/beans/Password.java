package com.cg.spring.beans;

public class Password {

	private String emailId;

	private String password;

	public Password() {
	}

	public Password(String emailId, String password ) {
		super();
		this.emailId = emailId;
		this.password = password;

	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
