package com.ddl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.JdbcUtil;

public class Login {

	public static void main(String[] args) throws SQLException {
		createStatement();
		prepareStatement();
	}

	private static void createStatement() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user name : ");
		String username = sc.nextLine();

		System.out.println("Enter password");
		String password = sc.nextLine();

		JdbcUtil jdbcUtil = new JdbcUtil();
		Connection connection = jdbcUtil.getConnection();
		Statement statement = connection.createStatement();

		String query = "SELECT * FROM users where username='" + username + "' and password='" + password + "'";

		ResultSet resultSet = statement.executeQuery(query);

		if (resultSet.next()) {
			System.out.println("Logged In");
		} else {
			System.out.println("Invalid Credentials");
		}
	}

	public static void prepareStatement() throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user name : ");
		String username = sc.nextLine();

		System.out.println("Enter password");
		String password = sc.nextLine();

		JdbcUtil jdbcUtil = new JdbcUtil();
		Connection connection = jdbcUtil.getConnection();
		String query = "SELECT * FROM users where username = ? And password = ?";
		PreparedStatement statement = connection.prepareStatement(query);

		statement.setString(1, username);
		statement.setString(2, password);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			System.out.println("Logged In");
		} else {
			System.out.println("Invalid Credentials");
		}
	}

}
