package com.dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLOperations {
	
	public static void main(String[] args) {
		try {
			// Register the driver
			// Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("Driver Registered");
			
			// Establish Connection
			
			String url ="jdbc:mysql://localhost:3306/flm_adv_java";
			String userName="root";
			String password="Fayaz78677@";
			
			Connection connection = DriverManager.getConnection(url, userName, password);
			
			// Create a statement
			
			Statement statement = connection.createStatement();
			
			//Prepare Query
			String query = "insert into employees values(5,'ghjg@gmail.com',25000)";
			
			//Execute statement
			statement.executeUpdate(query);
			
			System.out.println("Inserted Data...");
			
	//		String query2 = "Update employees set salary=20000 where empId=6";
	//		statement.executeUpdate(query2);
	//		System.out.println("Updated Data..");
			
			String query3 = "Delete from employees where empId=6";
			statement.executeUpdate(query3);
			System.out.println("Deleted data...");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
