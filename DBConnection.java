package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{

	private static final String url = "jdbc:mysql://localhost:3306/foodapplication";
    private static final String userName = "root";
    private static final String password = "Bhuvan@123";
    private static Connection con;
	 
	 public static Connection getConnection() 
	 {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection( url,userName, password);
			return con;
			}
			catch (ClassNotFoundException | SQLException e)
			{

				e.printStackTrace();
			}
			return con;
	 }
	 
	
	
}
