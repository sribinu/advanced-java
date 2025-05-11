package com.sribinu;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/square")
public class SquareServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		
//		int k = (int) req.getAttribute("k");
//		
//		PrintWriter out = res.getWriter();
//		out.println("Addition is " + k);
//		out.println("This is Square Servlet");
//		k *= k;
//		out.println("Square is " + k);
		
		System.out.println("SquareServlet is called using sendRedirect() method");
		
		// int k =Integer.parseInt(req.getParameter("k")); // From URL Rewritting
		
//		HttpSession session = req.getSession(); // Using Session
//		int k = (int) session.getAttribute("k");
//		session.removeAttribute("k");
//		session.invalidate();
		
		int k = 0;
		Cookie[] cookies = req.getCookies();
		
		for(Cookie c : cookies) {
			if(c.getName().equals("k"))
				k = Integer.parseInt(c.getValue());
		}
		
		
		PrintWriter out = res.getWriter();
		out.println("<html><body bgcolor='cyan'>");
		out.println("Square is " + k*k);
		out.println("</body></html>");
	}
}
