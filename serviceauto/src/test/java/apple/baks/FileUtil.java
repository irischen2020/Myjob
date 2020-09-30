package apple.baks;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class FileUtil {
	
	//拷贝文件
	public static void fileCopy(String pathFro, String pathTo) {

		InputStream ins = null;
		OutputStream op = null;
		try {
			ins = new FileInputStream(new File(pathFro));
			op = new FileOutputStream(new File(pathTo));
			int size = 0;
			while((size = ins.read())!= -1){
				op.write(size);
			};
			if (ins !=null){
				ins.close();
			}
			if (op !=null){
				op.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//创建文件。先创建目录
	public static void fileCreate(String dirPath, String filePath) {
		
		//创建目录
		File dir = new File(dirPath);
		dir.mkdirs();
		
		//创建文件。创建文件之前需要有目录才行
		File file = new File(filePath);
		//看文件是否存在
		System.out.println(file.exists());
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("finish");
	}
	
	//解析properties文件
	public static Properties readProp(String path){
		Properties prop = new Properties();
		try{
			InputStream ins = new FileInputStream(new File(path));
			prop.load(ins);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return prop;
	}
	
	//解析XML文件
	public static void readXml(String path,String secondnode,String nodes1,String nodes2,String nodes3) throws Exception {
		
		//创建解析器SaxReader对象
		SAXReader reader = new SAXReader();
		//获取document对象
		Document document = reader.read(new File(path));
		//获取根元素
		Element root = document.getRootElement();
		//获取根元素下的子元素
		List<Element> studentsElements = root.elements(secondnode);
		//通过循环处理三个STUDENT元素
		for (Element studentElement : studentsElements) {
			String name = studentElement.elementText(nodes1);
			String age = studentElement.elementText(nodes2);
			String gender = studentElement.elementText(nodes3);
			System.out.println(name);
			System.out.println(age);
			System.out.println(gender);
			
		}
		
	}
}
