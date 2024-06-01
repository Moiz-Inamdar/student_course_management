package com.bldea.studentcoursemanagement.entity;
/**
 * 
 */

/**
 * @author DELL
 *
 */

	public class Student {
		int sid;
		String sname;
		String fname; 
		String mname;
		String address;
		String city;
		String state;
		String country;
		long phone;
		String email;
		
		
	
	public Student(int sid, String sname, String fname, String mname, String address, String city, String state,
				String country, long phone, String email) {
			super();
			this.sid = sid;
			this.sname = sname;
			this.fname = fname;
			this.mname = mname;
			this.address = address;
			this.city = city;
			this.state = state;
			this.country = country;
			this.phone = phone;
			this.email = email;
		}

		

	public int getSid() {
		return sid;
	}



	public String getSname() {
		return sname;
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
