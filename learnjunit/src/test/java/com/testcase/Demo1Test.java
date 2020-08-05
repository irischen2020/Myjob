package com.testcase;

import org.junit.*;
import org.junit.jupiter.api.*;


public class Demo1Test {
	@BeforeAll
	public static void testBeforClass(){
		System.out.println("run testBeforClass");
	}
	@AfterAll
	public static void testAfterClass(){
		System.out.println("run testAfterClass");
	}
	@BeforeEach
	public void testBefor(){
		System.out.println("run testBefor");
	}
	@AfterEach
	public void testAfter(){
		System.out.println("run testAfter");
	}
	@Test
	public void testDemo1(){
		System.out.println("run testDemo1");
	}
	@Test
	public void testDemo2(){
		System.out.println("run testDemo2");
	}
	@Test
	public void testDemo3(){
		System.out.println("run testDemo3");
	}

}
