package com.junit5testcase;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//JUNIT5参数化

public class TestParam {
	
	//通过ValueSource传参
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	public void testWithValueSource(int age){
		assertNotNull(age);
		
	}
	
	//通过Csvsource传参
	@ParameterizedTest
	@CsvSource({"1,2","3,3","4,5","6,6"})
	public void testDemo(int actual,int expection){
//		assertThat("actual value close to 10",
//				9.88,
//				anyOf(closeTo(10.0,0.1),equalTo(9.88)));

		assertThat("demo",actual,equalTo(expection));
	}
	
	//通过MethodSource传参
	

}
