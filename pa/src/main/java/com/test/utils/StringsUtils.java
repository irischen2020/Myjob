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
				e.printStackTrace();
			}
		}
		
//将字符串写入文件的五种方法
//public void WriteStringToFile(String filePath) {
//	try {
//		File file = new File(filePath);
//		PrintStream ps = new PrintStream(new FileOutputStream(file));
//		ps.println("我是程序员");// 往文件里写入字符串
//		ps.append("我是程序猿");// 在已有的基础上添加字符串
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
//	public void WriteStringToFile2(String filePath) {
//		try {
//			FileWriter fw = new FileWriter(filePath, true);
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.append("我是程序猿");
//			bw.write("我是");// 往已有的文件上添加字符串
//			bw.write("程序猿\n ");
//			bw.close();
//			fw.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public void WriteStringToFile3(String filePath) {
//		try {
//			PrintWriter pw = new PrintWriter(new FileWriter(filePath));
//			pw.println("abc ");
//			pw.println("def ");
//			pw.println("hef ");
//			pw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public void WriteStringToFile4(String filePath) {
//		try {
//			RandomAccessFile rf = new RandomAccessFile(filePath, "rw");
//			rf.writeBytes("op\r\n");
//			rf.writeBytes("app\r\n");
//			rf.writeBytes("hijklllll");
//			rf.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public void WriteStringToFile5(String filePath) {
//		try {
//			FileOutputStream fos = new FileOutputStream(filePath);
//			String s = "http://www.jb51.netl";
//			fos.write(s.getBytes());
//			fos.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
