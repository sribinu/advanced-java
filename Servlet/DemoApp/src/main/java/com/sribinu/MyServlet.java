package com.sribinu;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/my")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("Hii ");
		
		//ServletContext ctx2 = req.getServletContext();
		ServletContext ctx = getServletContext();
		String name = ctx.getInitParameter("name"); // give the initial value
		out.println(name);
		
		String mail = ctx.getInitParameter("mail");
		out.println(mail);
		
		ServletConfig scg = getServletConfig();
		String name2 = scg.getInitParameter("name");
		out.println(name2);
	}
	
}
