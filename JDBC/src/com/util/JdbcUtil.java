package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	
	public Connection connection = null;
	
	public Connection getConnection() throws SQLException {
		
		if(connection == null) {
			this.connection = DriverManager.getConnection(Constants.URL, Constants.userName, Constants.password);	
		}
		return connection;
	}

}
