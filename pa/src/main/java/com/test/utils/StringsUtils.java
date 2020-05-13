package com.test.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;

public  class StringsUtils {
	
	
	//把字符串写到文件
	public static void StringsToFiles(String s,String filePath){
	
			try {
				FileWriter fw = new FileWriter(filePath, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(s);
				bw.close();
				fw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void main(String[] args){
		
		StringsToFiles("123","f:\11.txt");
			System.out.println("写入成功");
		}

}
