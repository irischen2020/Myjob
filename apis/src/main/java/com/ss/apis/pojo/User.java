package com.ss.apis.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
	private int id;
	private String username;
	private String password;
	private Date reg_date;
	
}
