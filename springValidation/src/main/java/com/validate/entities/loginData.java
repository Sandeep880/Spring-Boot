package com.validate.entities;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import jakarta.validation.constraints.Size;

public class loginData {
	
	@NotBlank(message="User name should not be Blank !!")
	@Size(min=3, max=12 , message="User Name must be between 3 to 12 characters !")
	private String userName;
	
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message="Email Should be in correct format !!")
	private String email;
	public String getUserName() {
		return userName;
	}
	
	@AssertTrue
	private boolean agreed;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	
	@Override
	public String toString() {
		return "loginData [userName=" + userName + ", email=" + email + ", agreed=" + agreed + "]";
	}
	
	
	
	

}
