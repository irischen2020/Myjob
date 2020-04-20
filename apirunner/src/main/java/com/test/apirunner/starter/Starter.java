package com.test.apirunner.starter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.test.apirunner")
public class Starter {
	public static void main(String[] args){
		SpringApplication.run(Starter.class,args);
	}
}
