<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		
		response.setHeader("Expires","0"); //Proxies
	
		if(session.getAttribute("username") == null)
			response.sendRedirect("login.jsp");
	%>
	Welcome <%= session.getAttribute("username") %>
	<br>
	
	<a href="content.jsp">Content</a>
	
	<br>
	
	<form action="logout">
		<button type="submit">Logout</button>
	</form>
</body>
</html>