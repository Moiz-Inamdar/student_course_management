package com.bldea.studentcoursemanagement.entity;

public class Professor {
	int pid;
	String pname;
	String fname; 
	String mname;
	String address;
	String city;
	String state;
	String country;
	long phone;
	String email;
	
	public Professor(int pid, String pname, String fname, String mname, String address, String city, String state,
			String country, long phone, String email) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.fname = fname;
		this.mname = mname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phone = phone;
		this.email = email;
	}

	public int getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public String getFname() {
		return fname;
	}

	public String getMname() {
		return mname;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public long getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
