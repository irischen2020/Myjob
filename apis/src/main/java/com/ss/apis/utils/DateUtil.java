package com.ss.apis.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static SimpleDateFormat yy_ssformater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat yy = new SimpleDateFormat("yyyy-MM-dd");
	
	//格式化为年月日时分秒
	public static String formatyy_ss(Date date){
		String dataString = yy_ssformater.format(date);
		return dataString;
	}
	//格式化为年月日
	public static String formatyy(Date date){
		String dataString = yy_ssformater.format(date);
		return dataString;
	}
}
