package com.JDBC_Testing;

import java.sql.*;


public class TestJDBC 
{
	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false"; //JDBC URL ,hb_student_tracker is database schema
		String uname="hbstudent";
		String pwd="hbstudent"; //if we give wrong username or password it will give Error
		
		Connection conn=null;
//to use the upper information we can  get the connection to the database
		
		try 
		{
			System.out.println("Connecting to the database..."+url);
			conn=DriverManager.getConnection(url, uname, pwd); // DriverManager is used for connecting to database
			System.out.println("Connection established successfully!!");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
