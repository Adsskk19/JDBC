package com.metadata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.util.JdbcUtil;

public class MetaDataInfo {
	
	public static void main(String[] args) throws SQLException {
		
		JdbcUtil jdbcUtil = new JdbcUtil();
		Connection connection = jdbcUtil.getConnection();
		
		String query = "Select * from employees";
		PreparedStatement statement = connection.prepareStatement(query);
		
		
		ResultSet resultSet = statement.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		
//		System.out.println("Column count : " + metaData.getColumnCount());
//		System.out.println(metaData.getColumnName(1)+"\t"+
//		metaData.getColumnName(2)+"\t\t"+metaData.getColumnName(3));
		
		int count = metaData.getColumnCount();
		
		for(int i=1;i<=count;i++) {
			System.out.print(metaData.getColumnName(i));
			System.out.print("\t");
		}
		
		System.out.println();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)
			+"\t"+resultSet.getDouble(3));
		}
		
		System.out.println(metaData.getTableName(1));
		System.out.println(metaData.getColumnTypeName(1));
		System.out.println(metaData.getColumnTypeName(2));
	}

}
