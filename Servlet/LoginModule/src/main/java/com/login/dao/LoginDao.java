package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {
	public static boolean checkCredentials(String username, String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/learn_servlet";
			String un="root";
			String pwd="root";
			Connection con = DriverManager.getConnection(url, un, pwd);
			

			String query = "SELECT * FROM login WHERE username= ? AND password= ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			st.setString(2, password);
			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
}
