package apple.littletest;

import apple.utils.FileUtil;
import org.junit.jupiter.api.Test;

import static apple.utils.FileUtil.fileCreate;

public class FileDemo {
	//创建目录，再在此目录下创建文件
	@Test
	public void testFileRw(){
		fileCreate("E:\\aa\\bb","E:\\aa\\bb\\111.txt");
	}
	
	//拷贝文件  字节流读写
	@Test
	public void testFileCopy(){
		String pathFro = "E:\\BaiduNetdiskDownload\\高级性能测试训练营.pdf";
		String pathTo = "E:\\BaiduNetdiskDownload\\高级性能测试训练营1.pdf";
		FileUtil.fileCopy(pathFro,pathTo);
	}
	//解析XML文件
	@Test
	public void testXmlReader(){
		String path = "src/test/resources/student.xml";
		try {
			FileUtil.readXml(path,"student","name","age","gender");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
