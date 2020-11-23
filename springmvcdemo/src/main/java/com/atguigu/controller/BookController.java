//package com.atguigu.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class BookController {
//
//	@RequestMapping(value="/book/{bid}",method = RequestMethod.GET)
//	public String getBook(@PathVariable("bid")Integer id){
//		System.out.println("查询到了"+id+"号图书");
//		return "/WEB-INF/pages/success.jsp";
//	}
//
//	@RequestMapping(value="/book/{bid}",method = RequestMethod.DELETE)
//	public String deleteBook(@PathVariable("bid")Integer id){
//		System.out.println("删除了"+id+"号图书");
//		return "/WEB-INF/success.jsp";
//	}
//
//	@RequestMapping(value="/book",method = RequestMethod.POST)
//	public String addBook(@PathVariable("bid")Integer id){
//		System.out.println("添加了新的图书");
//		return "/WEB-INF/success.jsp";
//	}
//
//	@RequestMapping(value="/book/{bid}",method = RequestMethod.PUT)
//	public String updateBook(@PathVariable("bid")Integer id){
//		System.out.println("更新了"+id+"号图书");
//		return "/WEB-INF/success.jsp";
//	}
//
//	@RequestMapping("/book/1")
//	public String getBook(){
//		System.out.println("查询到了图书");
//		return "success.jsp";
//	}
//}
