<%@page import="java.sql.Date"%>
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add using JSP</title>
</head>
<body bgcolor="yellow">
	<%!
		// Declaration
		int value = 10;
	%>
	<%
	
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		
		int k = i + j;
		
		out.println("Output is " + k);
	%>
	<h4>Special value : <%= value %></h4>
</body>
</html>