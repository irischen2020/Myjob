package com.test.web;

import com.test.leis.Webpage;
import com.test.utils.HttpGetImage;

import java.net.URL;
import java.util.List;

public class WebGetImages {
	
	
	public static void main(String[] args) {
		
		Webpage webpage = new Webpage();
		webpage.setPageUrl("https://www.58pic.com/tupian/zhongguoqiantuwang.html");
		String s = webpage.getPageSource();
		List<String> urlList = webpage.getImageUrls();
		//遍历拿到的list
		for (int i = 0; i < urlList.size(); i++) {
			String imgurl = urlList.get(i).substring(15);
			imgurl = imgurl.substring(0, imgurl.length() - 1);
			String imgname = null;
			//判断拿到的imgurl是否为空
			if (imgurl.trim() != null && imgurl.trim() != "" && imgurl.length() != 0) {
				//判断是否包含http
				if (imgurl.indexOf("http") == -1) {
					imgurl = "http:" + imgurl;
					System.out.println(imgurl);
					//拿到当前的时间戳
					long timeStamp = System.currentTimeMillis();
					String stimeStamp = String.valueOf(timeStamp);
					//拼接得到以时间戳命名的文件名称
					imgname = stimeStamp + ".jpg";
					URL murl = null;
					try {
						murl = new URL(imgurl);
						//判断拿到的URL地址里面如果不存在//,才去下载图片
						if (imgurl.indexOf("//") != -1) {
							HttpGetImage.saveImageToDisk(murl,"F:\\testimages\\"+imgname);
							
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}

		}
	}
}
