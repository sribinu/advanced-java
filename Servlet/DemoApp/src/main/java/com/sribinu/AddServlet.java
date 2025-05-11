package com.sribinu;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
	// GET & POST method 
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		common(req, res);
//	}
//	
//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		common(req, res);
//	}
//	
//	public void common(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		
//		int k = i + j;
//		// System.out.println(k);
//		PrintWriter out = res.getWriter();
//		out.println("Addition is "+k);
//	}
	
	// Calling one Servlet from Another
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
		
		// 1. Calling using RequestDispatcher
//		req.setAttribute("k", k);
//		RequestDispatcher rd = req.getRequestDispatcher("square");
//		rd.forward(req, res);
		
		// 2. Using sendRedirect()
		//res.sendRedirect("square");
		
		// 2.1 URL rewriting
		//res.sendRedirect("square?k="+k);
		
		// 2.2 Using Session
		//HttpSession session = req.getSession();
		//session.setAttribute("k", k);
		//res.sendRedirect("square");
		
		// 2.3 Using Cookies
		Cookie cookie = new Cookie("k",k+"");
		res.addCookie(cookie);
		res.sendRedirect("square");
	}
	
}
