package com.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.JdbcUtil;

public class BatchProcessing {
	
	public static void main(String[] args) throws SQLException {
		
		JdbcUtil jdbcUtil = new JdbcUtil();
		
		Connection connection = jdbcUtil.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("Insert into employees values(?,?,?)");
		
		statement.setInt(1, 7);
		statement.setString(2, "swathi@gmail.com");
		statement.setDouble(3, 10000.00);
		
		statement.addBatch();
		
		statement.setInt(1, 8);
		statement.setString(2, "vijay@gmail.com");
		statement.setDouble(3, 20000.00);
		
		statement.addBatch();
		
		statement.setInt(1, 9);
		statement.setString(2, "prasanth@gmail.com");
		statement.setDouble(3, 25000.00);
		
		statement.addBatch();
		
		statement.executeBatch();
		
		System.out.println("Added Batch..");
		
		
	}

}
