package com.ll.app.entity;

public class User {
	private String userName;
	private String password;
	private String registTime;
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
