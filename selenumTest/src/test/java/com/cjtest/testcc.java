package com.cjtest;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class testcc {
	public Logger logger = Logger.getLogger(testcc.class);
	@Test
	public void testlog4j(){
		//记录INFO级别日志
		logger.info("这是INFO级别日志");
		logger.debug("这是DEBUG级别日志");
	}
}
