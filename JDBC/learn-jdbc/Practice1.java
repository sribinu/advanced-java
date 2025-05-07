package jdbc2;

import java.sql.*;

public class Practice1 {
	public static void main(String[] args) throws Exception {
		//select1();
		//insert1();
		//insert2();
		//insert3();
		//delete1();
		update1();
	}
	
	public static void select1() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		String query = "SELECT * FROM student";
		Statement st = con.createStatement();
		
		ResultSet res = st.executeQuery(query);
		
		while(res.next()) {
			System.out.println("ID   : "+ res.getInt(1));
			System.out.println("Name : "+ res.getString(2));
			System.out.println("GPA  : "+ res.getDouble(3));
			System.out.println();
		}
		
		con.close();
	}
	
	public static void insert1() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		String query = "INSERT INTO student VALUES (7,'Abin',25000);";
		Statement st = con.createStatement();
		
		int rows = st.executeUpdate(query);
		
		System.out.println(rows +" rows affected");
		con.close();
	}
	
	public static void insert2() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		int id = 8;
		String name = "Chris";
		double gpa = 9.6;
		
		String query = "INSERT INTO student VALUES ("+id+",'"+name+"',"+gpa+");";
		Statement st = con.createStatement();
		
		int rows = st.executeUpdate(query);
		
		System.out.println(rows +" rows affected");
		con.close();
	}
	
	public static void insert3() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		int id = 9;
		String name = "Sumith";
		double gpa = 7.6;
		
		String query = "INSERT INTO student VALUES (?,?,?);";

		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setDouble(3, gpa);
		
		int rows = pst.executeUpdate();
		
		System.out.println(rows +" rows affected");
		con.close();
	}
	
	public static void delete1() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		int id = 7;
		
		String query = "DELETE FROM student WHERE id= ?";

		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		
		int rows = pst.executeUpdate();
		
		System.out.println(rows +" rows deleted");
		con.close();
	}
	
	public static void update1() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		int id = 2;
		
		String query = "UPDATE student SET gpa = 8.1 WHERE id= ?";

		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		
		int rows = pst.executeUpdate();
		
		System.out.println(rows +" rows updated");
		con.close();
	}
}
