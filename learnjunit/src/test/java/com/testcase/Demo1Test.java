package com.testcase;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class Demo1Test {
	@BeforeClass
	public static void testBeforClass(){
		System.out.println("run testBeforClass");
	}
	@AfterClass
	public static void testAfterClass(){
		System.out.println("run testAfterClass");
	}
	@Before
	public void testBefor(){
		System.out.println("run testBefor");
	}
	@After
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
