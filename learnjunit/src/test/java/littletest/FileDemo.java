//package littletest;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//public class FileDemo {
//	@Test
//	public void TestFileRw(){
//		//创建目录
//
//		File dir = new File("E:\\aa\\bb");
//		dir.mkdirs();
//
//		//创建文件。创建文件之前需要有目录才行
//		String path1 = "E:\\aa\\bb\\cc.txt";
//		File file = new File(path1);
//		System.out.println(file.exists());
//		try {
//			file.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("finish");
//	}
//
//	//拷贝图片  字节流读写
//	@Test
//	public void TestFileCopy(){
//		String pathFro = "E:\\BaiduNetdiskDownload\\高级性能测试训练营.pdf";
//		String pathTo = "E:\\BaiduNetdiskDownload高级性能测试训练营1.pdf";
//		InputStream ins = new FileInputStream("");
//
//	}
//}
