package com.app.model;

import java.sql.Timestamp;

public class Users 
{

	
	private int userId;
	private String UserName;
	private String email;
	private String address;
	private String password;
	private String phoneNumber;
	private Timestamp createdDate;
	private Timestamp lastLogin;
	private String role;
	
	
	
	public Users() 
	{
		
		super();
	}

	


	public Users(String email) {
		super();
		this.email = email;
	}




	public Users(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}




	public Users(String UserName, String email, String phoneNumber ,String address, String password) {
		super();
		this.UserName = UserName;
		this.email = email;
		this.address = address;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}




	public Users(int userId, String UserName, String email, String phoneNumber, String address,String password, Timestamp createdDate,
			Timestamp lastLogin,String role) {
		super();
		this.userId = userId;
		this.UserName = UserName;
		this.email = email;
		this.address = address;
		this.password = password;
		this.phoneNumber=phoneNumber;
		this.createdDate = createdDate;
		this.lastLogin = lastLogin;
		this.role = role;
		
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return UserName;
	}



	public void setName(String UserName) {
		this.UserName = UserName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPassword() {
		return password;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Timestamp getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}



	public Timestamp getLastLogin() {
		return lastLogin;
	}



	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}



	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	@Override
	public String toString() {
		return "Users [userId=" + userId + ", UserName=" + UserName + ", email=" + email + ", address=" + address
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", createdDate=" + createdDate
				+ ", lastLogin=" + lastLogin + "]";
	}



}



	
	
	
	

