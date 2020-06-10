package com.testcase;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.hamcrest.Matchers;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TestParam {
	
	@Parameterized.Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{1,2},
				{3,3},
				{4,5},
				{6,6}
		});
	}
	@Parameterized.Parameter
	public int actual;
	@Parameterized.Parameter(1)
	public int expection;
	
	
	
	@Test
	public void testDemo(){
//		assertThat("actual value close to 10",
//				9.88,
//				anyOf(closeTo(10.0,0.1),equalTo(9.88)));
		
		assertThat("demo",actual,equalTo(expection));
	}

}
