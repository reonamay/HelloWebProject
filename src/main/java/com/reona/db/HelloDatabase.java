package com.reona.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");


			String dbURL = "jdbc:mysql://localhost:3306/db_test?characterEncoding=utf-8"; 
			Connection con = DriverManager.getConnection(dbURL, "DBuser", "password1234");


		String SQL = "SELECT * FROM member";
		PreparedStatement ps= con.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Username = "+rs.getString("username"));
		}
		con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}