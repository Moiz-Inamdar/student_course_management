package com.bldea.studentcoursemanagement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import com.bldea.studentcoursemanagement.service.StudentService;

import com.bldea.studentcoursemanagement.utils.DBUtils;

public class AdminService {
	public static Connection connection;
	private PreparedStatement pstmt;
	Scanner in=new Scanner(System.in);
	StudentService ss=new StudentService();
	
	public AdminService() {
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
				+ "1. Login\n"
				+ "2. Register\n"
				+ "3. Exit ");
		int choice=sc.nextInt();
		switch (choice) {
		case 1: {
			Login();
			System.out.println("Do you wish to re-login?(yes/no)");
			String val = sc.next();
			if(val.equalsIgnoreCase("yes")) {
				Login();
			}
			break;
		}
		case 2: {
			Register();
			break;
		}
		case 3: {
			System.exit(0);			
		}
		default:
			System.out.println("Please enter the valid choice");
			start();
		}

		
	}


	private void Register() {
		try {
			String sql = "insert into users values(?,?)";
			pstmt = connection.prepareStatement(sql);
			System.out.println("Enter the user name:");
			pstmt.setString(1, in.next());
			System.out.println("Enter the pwd:");
			pstmt.setString(2, in.next());

			int x2 = pstmt.executeUpdate();
			if(x2>0) {
				System.out.println("Data inserted into the user table");
			}
			else {
				System.out.println("Data insertion into the user table failed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}


	private void Login(){
		try{
			String sql="select * from users where user_id=?";

			
			pstmt=connection.prepareStatement(sql);
			System.out.println("Enter the user id:");
			Scanner in=new Scanner(System.in);
			pstmt.setString(1,in.next());
			
			ResultSet res=pstmt.executeQuery(); //sql is removed bcz sql query is incomplete as emp_id=?
			if(res.next()==true) {
				System.out.println("---------------------");
				System.out.println(res.getString(1));
				System.out.println(res.getString(2));
				System.out.println("---------------------");
				ss.update();
				
			}else {
				System.out.println("Invalid");
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
 }
}
