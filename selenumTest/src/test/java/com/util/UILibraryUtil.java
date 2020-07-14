package com.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.pojo.Page;
import com.pojo.UIElement;

public class UILibraryUtil {
	// 申明一个集合用来存页面
	public static List<Page> pagelist = new ArrayList<Page>();
	static {
		// 解析XML
		parse();
	}

	private static void parse() {
		
		String filePath = "src/test/resources/UILibrary.xml";
		// 创建解析器
		SAXReader saxreader = new SAXReader();
		// 获取文档对象
		try {
			Document document = saxreader.read(new File(filePath));
			// 获取根节点
			Element root = document.getRootElement();
			// 获取根节点下所有Page元素
			List<Element> pagelistfromxml = root.elements("Page");
			// 遍历所有的page
			for (Element page : pagelistfromxml) {
				// 获取Page关键字信息
				String keyword = page.attributeValue("keyword");
				// 获取当前Page底下的所有UIElement(名称跟XML匹配)
				List<Element> uielementlistfromxml = page.elements("UIElement");
				// 申明一个List对象，用来存放UIElement对象
				List<UIElement> uielementlist = new ArrayList<UIElement>();
				for (Element el : uielementlistfromxml) {
					String elementkeyword = el.attributeValue("keyword");
					String elementBy = el.attributeValue("by");
					String elementValue = el.attributeValue("value");
					// new一个UIElement
					UIElement uielement = new UIElement();
					uielement.setKeyword(elementkeyword);
					uielement.setBy(elementBy);
					uielement.setValue(elementValue);
					uielementlist.add(uielement);
				}
				Page pa = new Page();
				pa.setKeyword(keyword);
				pa.setEIElement(uielementlist);
				pagelist.add(pa);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据pageKeyWord和elementKeyWord获取一个特定的元素
	 * @param pageKeyWord
	 * @param elementKeyWord
	 * @return
	 */
	public static UIElement getUIElement(String pageKeyWord,
			String elementKeyWord) {
		for (Page p : pagelist) {
			//判断Page的Keyword跟传进来的参数是否相等
			if (pageKeyWord.equals(p.getKeyword())) {
				//相等则获取Page里面的UIElementLIST
				List<UIElement> uielist = p.getEIElement();
				for (UIElement uie : uielist) {
					if (elementKeyWord.equals(uie.getKeyword())) {
						return uie;
					}
				}
			}

		}
		return null;
	}

}
