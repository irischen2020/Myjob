package com.sd.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodeFilter",urlPatterns = "/*")
public class EncodeFilter extends HttpFilter {
	public void destroy() {
	}
	
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
//		chain.doFilter(req, resp);
		//解决POST中文乱码
		System.out.println("过滤器工作中");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//放行
		chain.doFilter(req,resp);
	}
	
	public void init(FilterConfig config) throws ServletException {
		
	}
	
}
