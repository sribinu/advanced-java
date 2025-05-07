package jdbc2;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {
//		Driver d = new com.mysql.cj.jdbc.Driver();
//		DriverManager.registerDriver(d);
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//readRecords();
		//insertRecord();
		//insertUsingVariables();
		//insertUsingPS();
		//deleteRecord();
		//updateRecord();
		
		//callProcedure();
		//callProcedureWithIN();
		//callProcedureWithOUT();
		
		//commitDemo();
		//batchDemo();
		//batchDemo2();
		rollbackDemo();
	}
	
	// read data from DB
	public static void readRecords() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement st = con.createStatement();
		String query = "select * from employee";
		
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			System.out.println("ID is "+ rs.getInt(1));
			System.out.println("Name is "+ rs.getString(2));
			System.out.println("Salary is "+ rs.getInt(3));
		}
		con.close();
	}
	
	// insert query
	public static void insertRecord() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement st = con.createStatement();
		String query = "INSERT INTO employee VALUES (4,'Gilchrist',43200)";
		
		int value = st.executeUpdate(query);
		System.out.println(value + " rows affected");
		con.close();
	}
	
	// inserting data with PreparedStatement
	public static void insertUsingPS() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		int id = 6;
		String name = "SUBIN";
		int salary = 30000;
		
		String query = "INSERT INTO employee VALUES (?,?,?);";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setInt(3, salary);

		int value = pst.executeUpdate();
		System.out.println(value + " rows inserted");
		con.close();
	}
	
	//delete a record 
	public static void deleteRecord() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		int id = 5;
		String query = "DELETE FROM employee WHERE emp_id ="+id;
		
		Statement st = con.createStatement();

		int value = st.executeUpdate(query);
		System.out.println(value + " rows deleted");
		con.close();
	}
	
	//update a record 
	public static void updateRecord() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		String query = "UPDATE employee SET salary = 81200 WHERE emp_id = 1";
		
		Statement st = con.createStatement();

		int value = st.executeUpdate(query);
		System.out.println(value + " rows updated");
		con.close();
	}
	
	// Calling a simple stored procedure
	public static void callProcedure() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		CallableStatement cst = con.prepareCall("{call getEmp()}"); // calling stored procedure
		ResultSet rs = cst.executeQuery(); // Use it , if stored procedure will perform SELECTION
		// int rows = cst.executeUpdate(); // Use it , if stored procedure will perform INSERT, UPDATE & DELETE
		
		while(rs.next()) {
			System.out.println("ID is "+ rs.getInt(1));
			System.out.println("Name is "+ rs.getString(2));
			System.out.println("Salary is "+ rs.getInt(3));
		}
		
		con.close();
	}
	
	// Calling a stored procedure with IN parameter
	public static void callProcedureWithIN() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id : ");
		int id = sc.nextInt();
		sc.close();
		
		CallableStatement cst = con.prepareCall("{call getEmpById(?)}");
		cst.setInt(1, id);
		
		ResultSet rs = cst.executeQuery();
		
		while(rs.next()) {
			System.out.println("ID is "+ rs.getInt(1));
			System.out.println("Name is "+ rs.getString(2));
			System.out.println("Salary is "+ rs.getInt(3));
		}
		con.close();
	}
	
	// Calling a stored procedure with OUT parameter
	public static void callProcedureWithOUT() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id : ");
		int id = sc.nextInt();
		sc.close();
		
		CallableStatement cst = con.prepareCall("{call getNameById(?,?)}");
		cst.setInt(1, id);
		cst.registerOutParameter(2, Types.VARCHAR);
		
		cst.executeUpdate(); // Cuz we are updating the OUT parameter in stored procedure
		
		System.out.println("Name is : "+ cst.getString(2));
		con.close();
	}
	
	// commit vs autocommit
	public static void commitDemo() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		
		Connection con = DriverManager.getConnection(url,username, password);
		con.setAutoCommit(false);
		String query1 = "UPDATE employee SET salary = 70000 where emp_id = 1";
		String query2 = "UPDATE employee SET salary = 70000 where emp_id = 2";
		Statement st = con.createStatement();
		
		int res1 = st.executeUpdate(query1);
		System.out.println(res1 + " rows affected");
		
		int res2 = st.executeUpdate(query2);
		System.out.println(res2 + " rows affected");
		
		if (res1 > 0 && res2 > 0)
			con.commit();
		
		con.close();
	}
	
	// batch processing
	public static void batchDemo() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		
		Connection con = DriverManager.getConnection(url,username, password);
	
		String query1 = "UPDATE employee SET salary = 40000 where emp_id = 1";
		String query2 = "UPDATE employee SET salary = 40000 where emp_id = 2";
		String query3 = "UPDATE employee SET salary = 40000 where emp_id = 3";
		String query4 = "UPDATE employee SET salary = 40000 where emp_id = 4";
		Statement st = con.createStatement();
		st.addBatch(query1);
		st.addBatch(query2);
		st.addBatch(query3);
		st.addBatch(query4);
		
		int[] res = st.executeBatch();
		
		for (int i : res) {
			System.out.println(i + " rows affected");
		}
		
		con.close();
	}
	
	
	// batch processing with commit
	public static void batchDemo2() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		
		Connection con = DriverManager.getConnection(url,username, password);
		con.setAutoCommit(false);
		String query1 = "UPDATE employee SET salary = 42000 where emp_id = 1";
		String query2 = "UPDATE employee SET salary = 42000 where emp_id = 2";
		String query3 = "UPDATE employee SET salary = 42000 where emp_id = 3";
		String query4 = "UPDATE employee SET salary = 42000 where emp_id = 4";
		Statement st = con.createStatement();
		st.addBatch(query1);
		st.addBatch(query2);
		st.addBatch(query3);
		st.addBatch(query4);
		
		int[] res = st.executeBatch();
		boolean check = true;
		for (int i : res) {
			if(i < 1) {
				check= false;
				break;
			}	
			System.out.println(i + " rows affected");
		}
		if(check)
			con.commit();
		con.close();
	}
	
	// roll back
	public static void rollbackDemo() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc2";
		String username = "root";
		String password = "root";
		
		Connection con = DriverManager.getConnection(url,username, password);
		con.setAutoCommit(false);
		String query1 = "UPDATE employee SET salary = 41000 where emp_id = 1";
		String query2 = "UPDATE employee SET salary = 41000 where emp_id = 2";
		String query3 = "UPDATE employee SET salary = 41000 where emp_id = 3";
		String query4 = "UPDATE employee SET salary = 41000 where emp_id = 4";
		Statement st = con.createStatement();
		st.addBatch(query1);
		st.addBatch(query2);
		st.addBatch(query3);
		st.addBatch(query4);
		
		int[] res = st.executeBatch();
		
		for (int i : res) {
			if(i>0)
				continue;
			else
				con.rollback();
		}
		con.commit();
		con.close();
	}
}
