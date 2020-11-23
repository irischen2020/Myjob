package com.atguigu.servlet;

import javafx.print.Printer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		System.out.println("dopost........");
		//给浏览器响应字符串
		PrintWriter writer = response.getWriter();
		writer.write("ssss");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		System.out.println("doget.....");
	}
}
