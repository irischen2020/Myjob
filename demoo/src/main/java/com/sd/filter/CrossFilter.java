package com.sd.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CrossFilter",urlPatterns = "/*")
public class CrossFilter implements Filter {
	
	
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// 添加参数，允许任意domain访问.响应头指定可以访问资源的URI路径
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
		
		// 这个allow-headers要配为*，这样才能允许所有的请求头
		
		resp.setHeader("Access-Control-Allow-Headers", "*");
		
		//指定响应访问所述资源时允许的一种或多种方法
		
		resp.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
		
		//设置缓存可以生存的最大秒数
		
		resp.setHeader("Access-Control-Max-Age", "3600");
		
		//指示的请求的响应是否可以暴露于该页面。当true值返回时它可以被暴露
		
		resp.setHeader("Access-Control-Allow-Credentials","true");
		
		
		chain.doFilter(request, resp);

	}
	
	public void init(FilterConfig config) throws ServletException {
		
	}
	
}
