<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Builtin Objects</title>
</head>
<body>
	<% 
		//request.getParameter("K");
		// pageContext.setAttribute("name", "sribinu", PageContext.SESSION_SCOPE);
		pageContext.setAttribute("name", "sribinu");
		
		String str = (String) pageContext.getAttribute("name");
		out.println(str);
		
		//try {
		//	int q = 10 /0;
		//}
		//catch(Exception e) {
		//	out.println("Error : "+e.getMessage());
		//}
		
		// using errorPage attribute in @page tag
		int q = 10 /0;
		
	%>
</body>
</html>