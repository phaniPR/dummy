package com.cg.spring.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity

@Table(name="Customer")
public class Password {

	@Id
	@Column(name="customer_email",length=30)
	private String emailId;
	
	@NotNull
	@Column(name="customer_password",length=20)
	private String password;


	
	

	public Password() {
	}

	public Password(String emailId, @NotNull String password ) {
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
