package com.ss.apis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.ss.apis.controller","com.ss.apis.service","com.ss.apis.pojo"}) //组建扫描
@SpringBootApplication
@MapperScan(basePackages = {"com.ss.apis.mapper"})
public class Application {
	public static void main(String[] args){
		SpringApplication.run(Application.class,args);
	}
}
