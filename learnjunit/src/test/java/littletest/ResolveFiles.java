package littletest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class ResolveFiles {
	@Test
	//解析properties文件
	public void ResolvePro(){
	
	
	}
	
	
	@Test
	//解析XML文件
	public void ResolveXml() throws Exception {
		String path = "src/test/resources/student.xml";
		//创建解析器SaxReader对象
		SAXReader reader = new SAXReader();
		//获取document对象
		Document document = reader.read(new File(path));
		//获取根元素
		Element root = document.getRootElement();
		//获取根元素下的子元素
		List<Element> studentsElements = root.elements("student");
		//通过循环处理三个STUDENT元素
		for (Element studentElement : studentsElements) {
			
		}
		
	}
}
