package com.dql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.util.JdbcUtil;

public class DQLOperations {
	
	public static void main(String[] args){
		
		try {
		JdbcUtil jdbcUtil = new JdbcUtil();
		
		Connection connection = jdbcUtil.getConnection();
		connection = jdbcUtil.getConnection();
		Statement statement = connection.createStatement();
		
		String query = "Select * from employees";
		
		ResultSet rs = statement.executeQuery(query);
		ResultSetMetaData metaData = rs.getMetaData();
		System.out.println(metaData.getColumnCount());
		System.out.println(metaData.getColumnLabel(1));
		System.out.println(metaData.getColumnName(1));
		System.out.println(metaData.getColumnType(1));
		System.out.println(metaData.getTableName(1));
		System.out.println("EmpId\tEmail\t\tSalary");
		
		while(rs.next()) {
			
			int empId = rs.getInt(1);
			String email = rs.getString(2);
			double salary = rs.getDouble("salary");
			
			System.out.println(empId+"\t"+email+"\t"+salary);
		}
		
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
}
