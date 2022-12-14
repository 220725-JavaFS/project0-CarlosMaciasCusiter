package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;
	
	public static Connection getConnection() throws SQLException{
		
		if(connection != null && !connection.isClosed()) {
			return connection;
		} else {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String url = "jdbc:postgresql://javafs220725.cgbxdd5yszbt.us-east-2.rds.amazonaws.com:5432/project0";
			String username = "postgres";
			String password = "password";
			connection = DriverManager.getConnection(url, username, password);
			return connection;
		}
	}
	
	public static void main(String[] args) {
		try {
			getConnection();
			System.out.println("Connection Successful!");
			System.out.println(System.getenv("Hello"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
