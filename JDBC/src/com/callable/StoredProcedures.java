package com.callable;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.util.JdbcUtil;

public class StoredProcedures {
	
	public static void main(String[] args) throws SQLException {
		
		JdbcUtil jdbcUtil = new JdbcUtil();
		
		Connection connection = jdbcUtil.getConnection();
		
		//CallableStatement statement = connection.prepareCall("{CALL getAllEMployees()}");
		
		
		CallableStatement statement2 = connection.prepareCall("{CALL getEmployeeById(?,?)}");
		statement2.setInt(1, 1);
		statement2.setString(2, "fayaz@gmail.com");
		
		
		CallableStatement statement3 = connection.prepareCall("{CALL GetSalaryById(?,?)}");
		statement3.setInt(1, 2);
		statement3.registerOutParameter(2, Types.DECIMAL);
		
		statement3.execute();
		
		double salary = statement3.getDouble(2);
		System.out.println("Salary : "+salary);
		
//		ResultSet result = statement2.executeQuery();
//		
//		while(result.next()) {
//			System.out.println(result.getInt(1)+"\t"+result.getString(2)
//			+"\t\t"+result.getDouble(3));
//		}
		
		CallableStatement statement4 = connection.prepareCall("{CALL IncreaseSalary(?)}");
		
		
		statement4.setDouble(1, 1200);
		
		statement4.registerOutParameter(1, Types.DECIMAL);
		
		statement4.execute();
		
		double sal = statement4.getDouble(1);
		System.out.println(sal);
	}

}
