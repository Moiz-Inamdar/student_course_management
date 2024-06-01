package com.bldea.studentcoursemanagement.entity;

public class Admin {
	String user_id;
	String password;
	
	public Admin(String user_id, String password) {
		super();
		this.user_id = user_id;
		this.password = password;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getPassword() {
		return password;
	}
	
}
