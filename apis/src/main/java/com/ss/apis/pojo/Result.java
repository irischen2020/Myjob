package com.ss.apis.pojo;

import lombok.Data;

@Data
public class Result {
	private String status;
	private Object data;
	private String message;
	
	public Result() {
	}
	
	public Result(String status, Object data, String message) {
		this.status = status;
		this.data = data;
		this.message = message;
	}
	
	
	public Result(String status, Object data) {
		this.status = status;
		this.data = data;
	}
}
