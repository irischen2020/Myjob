package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String string = request.getParameter("param");
		if (string.equals("getSession")){
			response.getWriter().write(request.getSession().getId());
			
		}else if(string.equals("invalidateSession"))
		{
			request.getSession().invalidate();
			System.out.println("session invalidate");
			response.getWriter().write("session invalidate");
			
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
