<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JDBC in JSP</title>
</head>
<body>
	<%
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/jdbc2";
		String username="root";
		String password="root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement st = con.createStatement();
		String query = "SELECT * FROM student WHERE id =3";
		
		ResultSet rs = st.executeQuery(query);
		rs.next();
	%>
	
	ID : <%= rs.getInt(1) %> <br>
	Name : <%= rs.getString(2) %> <br>
	GPA : <%= rs.getDouble(3) %> <br> 
	
</body>
</html>