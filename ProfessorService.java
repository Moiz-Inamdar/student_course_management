package com.bldea.studentcoursemanagement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bldea.studentcoursemanagement.utils.DBUtils;

public class ProfessorService {

	public static Connection connection;
	private PreparedStatement pstmt;

	/**
	 * We will be invoking the connection to the DB using this constructor
	 */
	public ProfessorService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DBUtils.url, DBUtils.user, DBUtils.pwd);
			System.out.println("----------- Connected to The DB ----------");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select the operation to be performed\n"
				+ "1. Register Professor\n"
				+ "2. Update Name\n"
				+ "3. Update Mobile Number\n"
				+ "4. Update Email\n"
				+ "5. exit");
		int choice=sc.nextInt();
		switch (choice) {
		case 1: {
			register();
			System.out.println("Do you wish to add more professor");
			String val = sc.next();
			if(val.equalsIgnoreCase("yes")) {
				register();
			}
			break;
		}
		case 2: {
			updateName();
			break;
		}
		case 3: {
			updateMobile();
			break;
		}
		case 4: {
			updateEmail();
			break;
		}
		case 5: {
			System.exit(0);			
		}
		default:
			System.out.println("Please enter the valid choice");
			start();
		}

	}
	

	private void updateMobile() {
		try {
			String sql="update professor set phone=? where pid=?";
		    pstmt=connection.prepareStatement(sql);
			Scanner in=new Scanner(System.in);
			System.out.println("Enter the phone no:");
			pstmt.setLong(1, in.nextLong());
			System.out.println("Enter the id:");
			pstmt.setInt(2, in.nextInt());
			int x=pstmt.executeUpdate();
					if(x>0) {
						System.out.println("Phone number updated");
					}
					else {
						System.out.println("Updating the phone number failed");
					}
		}
		catch(Exception e) {
			System.out.println("Exception handled in update name method");
		}
		
	}

	private void updateEmail() {
		try {
			String sql="update prof set email=? where pid=?";
		    pstmt=connection.prepareStatement(sql);
			Scanner in=new Scanner(System.in);
			System.out.println("Enter the email:");
			pstmt.setString(1, in.next());
			System.out.println("Enter the id:");
			pstmt.setInt(2, in.nextInt());
			int x=pstmt.executeUpdate();
					if(x>0) {
						System.out.println("Email updated");
					}
					else {
						System.out.println("Updating the email failed");
					}
		}
		catch(Exception e) {
			System.out.println("Exception handled in update email method");
		}
	}

	private void updateName() {
		try {
			String sql="update prof set pname=? where pid=?";
		    pstmt=connection.prepareStatement(sql);
			Scanner in=new Scanner(System.in);
			System.out.println("Enter the name:");
			pstmt.setString(1, in.next());
			System.out.println("Enter the id:");
			pstmt.setInt(2, in.nextInt());
			int x=pstmt.executeUpdate();
					if(x>0) {
						System.out.println("Name updated");
					}
					else {
						System.out.println("Updating the name failed");
					}
		}
		catch(Exception e) {
			System.out.println("Exception handled in update name method");
		}
	}

	public void register() {
		try {
			String sql = "insert into prof values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the id:");
			pstmt.setInt(1, sc.nextInt());
			System.out.println("Enter the name:");
			pstmt.setString(2, sc.next());
			System.out.println("Enter the father name:");
			pstmt.setString(3, sc.next());
			System.out.println("Enter the mother name:");
			pstmt.setString(4, sc.next());
			System.out.println("Enter the address:");
			pstmt.setString(5, sc.next());
			System.out.println("Enter the city:");
			pstmt.setString(6, sc.next());
			System.out.println("Enter the state:");
			pstmt.setString(7, sc.next());
			System.out.println("Enter the country:");
			pstmt.setString(8, sc.next());
			System.out.println("Enter the phone:");
			pstmt.setLong(9, sc.nextLong());
			System.out.println("Enter the email:");
			pstmt.setString(10, sc.next());

			int x = pstmt.executeUpdate();
			if(x>0) {
				System.out.println("data inserted into professor table");
				sql = "insert into users values(?,?)";
				pstmt = connection.prepareStatement(sql);
				System.out.println("Enter the user name:");
				pstmt.setString(1, sc.next());
				System.out.println("Enter the pwd:");
				pstmt.setString(2, sc.next());

				int x2 = pstmt.executeUpdate();
				if(x2>0) {
					System.out.println("Data inserted into the user table");
				}
				else {
					System.out.println("Data insertion into the user table failed");
				}
			}
			else {
				System.out.println("data insertion into student table failed");
			}

		}
		catch (Exception e) {
			System.out.println("Exception in register method");	
			}
	}

}
