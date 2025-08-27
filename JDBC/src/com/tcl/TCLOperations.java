package com.tcl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.JdbcUtil;

public class TCLOperations {
	
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
			JdbcUtil jdbcUtil = new JdbcUtil();
			
			connection = jdbcUtil.getConnection();
			
			connection.setAutoCommit(false);
			
			PreparedStatement statement = connection.prepareStatement("update employees set salary= ? where empId=?");
			
			statement.setDouble(1, 10000);
			statement.setInt(2, 1);
			
			statement.executeUpdate();
			
			System.out.println("Updated...");
			
			connection.commit();
		
		}catch(Exception e) {
			connection.rollback();
		}

	}
}
